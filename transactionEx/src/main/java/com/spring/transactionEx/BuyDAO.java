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
	//setTemplate�޼��嵵 @AutoWired ������̼��� ����� ����ҷ��� beans�� ����ؾ���
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//Ʈ����� ���ø� ���
	TransactionTemplate transactionTemplate2;
	
	
	@Autowired
	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplate2 = transactionTemplate2;
	}
	
	//Ʈ������� �������� �ʰ� Ƽ�� ���� ���� 6���� �ϸ� ���������� ���� ���� ���谡 �߻��Ͽ� ������ ������ ���.
	//Ʈ����� ���� �� ������ ������ ���� �ʰ� ���������� ���� �ߴٰ� ���. 
//	PlatformTransactionManager transactionManager;
	
//	@Autowired //��Ʈ�ѷ����� BuyDAO�� @Autowired�� ������ �ߴ�. BuyDAO�� @service�� ����߱� ������ �����ϴ�.
//	//BuyDAO���� setter�޼��带 ����ҷ��� servlet-context.xml�� beans�� ����ϰų�, setter�޼��忡 @Autowired ������̼��� ����ص� �ȴ�.
//	//BuyDAO�� @service ������̼��� ��������.
//	public void setTransactionManager(PlatformTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}
	

	
	public void buyTicket(final BuyVO buyVO) {
		System.out.println("--------------buyTicket()ȣ��------------");
		System.out.println("���� �� ���̵� : " + buyVO.getUserId());
		System.out.println("Ƽ�� ���� ���� : " + buyVO.getAmount());

		
		//Ʈ����� ���ø� ���
		transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
//				try{
					//card ���̺� �Է��ϴ� ���� (PreparedStatementCreator ���)
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
				
					//ticket ���̺� �Է��ϴ� ���� (PreparedStatementSetter ���)
					String sql = "insert into ticket(userName, cnt) values(?,?)";
					template.update(sql, new PreparedStatementSetter() {
						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							ps.setString(1, buyVO.getUserId());
							ps.setInt(2, Integer.parseInt(buyVO.getAmount()));						
						}
					});
//				}catch (Exception e) {
//					//�ѹ� ó���� �ȴٸ� DB�� �� ���̺� ��� DB����� �ȵǾ�� �Ѵ�.
//					status.setRollbackOnly();
//					System.out.println("�ѹ�ó�� �Ǿ����ϴ�.!!");
//				}
			}//doInTransactionWithoutResult()
		});
//		
//		//Ʈ����ǸŴ��� ������ ���� �⺻���� ��ü
//		TransactionDefinition def = new DefaultTransactionDefinition();
//		TransactionStatus status = transactionManager.getTransaction(def);
//		
//		try {
//			//update ��� 1
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
//			//update ��� 2
//			String sql = "insert into ticket(userName, cnt) values(?,?)";
//			this.template.update(sql, new PreparedStatementSetter() {
//				@Override
//				public void setValues(PreparedStatement ps) throws SQLException {
//					ps.setString(1, buyVO.getUserId());
//					ps.setInt(2, Integer.parseInt(buyVO.getAmount()));
//				}
//			});
//			//���� �������� �� ó�� �Ǹ� status��ü�� Ʈ����� ���� �Ѵ�.
//			transactionManager.commit(status);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			//���� �߻��� �ٽ� �ѹ��Ѵ�.
//			transactionManager.rollback(status);
//		}
	}//buyTicket()
}

