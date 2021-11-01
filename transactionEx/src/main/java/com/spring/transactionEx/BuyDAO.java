package com.spring.transactionEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class BuyDAO {

	JdbcTemplate template;
	//setTemplate메서드도 @AutoWired 어노테이션을 지우고 사용할려면 beans에 등록해야함
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//트랜잭션 템플릿 사용
	TransactionTemplate transactionTemplate2;
	
	
	@Autowired
	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplate2 = transactionTemplate2;
	}
	
	//트랜잭션을 설정하지 않고 티켓 구매 수를 6으로 하면 페이지에서 제약 조건 위배가 발생하여 페이지 오류가 뜬다.
	//트랜잭션 설정 후 페이지 오류는 뜨지 않고 정상적으로 구매 했다고 뜬다. 
//	PlatformTransactionManager transactionManager;
	
//	@Autowired //컨트롤러에서 BuyDAO를 @Autowired를 설정을 했다. BuyDAO는 @service로 등록했기 때문에 가능하다.
//	//BuyDAO에서 setter메서드를 사용할려면 servlet-context.xml에 beans를 등록하거나, setter메서드에 @Autowired 어노테이션을 사용해도 된다.
//	//BuyDAO의 @service 어노테이션을 지워야함.
//	public void setTransactionManager(PlatformTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}
	

	
	public void buyTicket(final BuyVO buyVO) {
		System.out.println("--------------buyTicket()호출------------");
		System.out.println("구매 고객 아이디 : " + buyVO.getUserId());
		System.out.println("티켓 구매 수량 : " + buyVO.getAmount());

		
		//트랜잭션 템플릿 사용
		transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
//				try{
					//card 테이블에 입력하는 과정 (PreparedStatementCreator 방식)
					template.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						String sql = "insert into card(userName, amount) values(?,?)";
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, buyVO.getUserId());
						ps.setInt(2, Integer.parseInt(buyVO.getAmount()));
						return ps;
						}
					});
				
					//ticket 테이블에 입력하는 과정 (PreparedStatementSetter 방식)
					String sql = "insert into ticket(userName, cnt) values(?,?)";
					template.update(sql, new PreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							ps.setString(1, buyVO.getUserId());
							ps.setInt(2, Integer.parseInt(buyVO.getAmount()));						
						}
					});
//				}catch (Exception e) {
//					//롤백 처리가 된다면 DB에 두 테이블 모두 DB등록이 안되어야 한다.
//					status.setRollbackOnly();
//					System.out.println("롤백처리 되었습니다.!!");
//				}
			}//doInTransactionWithoutResult()
		});
//		
//		//트랜잭션매니저 구동을 위한 기본적인 객체
//		TransactionDefinition def = new DefaultTransactionDefinition();
//		TransactionStatus status = transactionManager.getTransaction(def);
//		
//		try {
//			//update 방법 1
//			this.template.update(new PreparedStatementCreator() {
//				@Override
//				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//					String sql = "insert into card(userName, amount) values(?,?)";
//					PreparedStatement ps = con.prepareStatement(sql);
//					ps.setString(1, buyVO.getUserId());
//					ps.setInt(2, Integer.parseInt(buyVO.getAmount()));
//					return ps;
//				}
//			});
//			
//			
//			//update 방법 2
//			String sql = "insert into ticket(userName, cnt) values(?,?)";
//			this.template.update(sql, new PreparedStatementSetter() {
//				@Override
//				public void setValues(PreparedStatement ps) throws SQLException {
//					ps.setString(1, buyVO.getUserId());
//					ps.setInt(2, Integer.parseInt(buyVO.getAmount()));
//				}
//			});
//			//위의 쿼리문이 다 처리 되면 status객체가 트랜잭션 수행 한다.
//			transactionManager.commit(status);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			//예외 발생시 다시 롤백한다.
//			transactionManager.rollback(status);
//		}
	}//buyTicket()
}

