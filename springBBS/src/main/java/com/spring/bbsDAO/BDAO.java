package com.spring.bbsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.spring.bbsVO.BVO;
import com.spring.template.StaticTemplate;

public class BDAO {
	//Template 사용 시
	JdbcTemplate template;
	
//	DataSource dataSource;
	
	//톰캣서버의 context.xml에서 sql의 DB를 등록해줘야 한다.
	public BDAO() {
//		try {
//			Context ctx = new InitialContext();
//			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle18g"); //  java:comp/env/jdbc/context.xml의 name를 써준다.
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
		//template 사용 시 (위의 코드도 필요없음)
		this.template = StaticTemplate.template;
	}
	
	/*Jdbctemplate 사용할 수 있는 메소드
	-query() 메소드 : select 쿼리문을 실행할 때 사용하는 메서드
		:List query(String sql, Object[] args, RowMapper rowMapper)
		:List query(String sql, RowMapper rowMapper)
		
		.BeanPropertyRowMapper<T> 클래스는 RowMapper<T> 인터페이스를 구현 했다.
		.RowMapper<T> 인터페이스에서 정의하고 있는 메소드는 T mapRow(ResultSet rs, int rowNum) throws SQLException; 
		//rowNum은 행번호(0부터 시작)
		.mapRow() 메소드 - ResultSet에서 읽어온 값을 이용해서 원하는 타입의 객체를 생성한 뒤 리턴
	
	-queryForObject() 메소드 : 쿼리 실행 결과의 행의 개수가 한개인 경우에 사용하는 메소드
		전달되는 각 파라미터가 query() 메소드와 동일하다. 대신 List를 반환하는 대신에 한 개의 객체를 리턴
		리턴 되는 행(레코드)의 개수가 한개가 아닌 경우에는 IncorrectResultSizeDataAcessException 예외 발생
	 : public Object queryForObject(String sql, RowMapper rowMapper)
	 : public Object queryForObject(String sql, Object[] args, RowMapper rowMapper
		리턴 타입이 Object가 아닌 경우에는 Int, Long 타입의 결과를 구할 때 사용하는 
		queryForInt(), queryForLong()
	
	
	-update() 메소드 : update, insert, delete 쿼리문을 실행할 때 사용하는 메소드
		쿼리 실행결과 변경된 행의 개수를 리턴
	 :update(String sql)
	 :update(String sql, Object[] args)
	
	-execute() 메소드 : Connection을 직접 사용해야 하는 경우에 사용하는 메서드.
		.커넥션의 생성과 종료는 JdbcTemplate에서 처리하기 때문에 Connection을 종료하기 때문에 따로 사용할 필요가 없다.
	
	*/
	//DB의 게시글을 가져올 메서드 
	public ArrayList<BVO> list() {
		//template 이용
		ArrayList<BVO> bVOs = null;
		
		String sql = "select bNo, bName, bSubject, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_bbs"
				+ " order by bGroup desc, bStep asc"; // order 앞에 한칸을 뛰어쓰기 해줘야한다.
		RowMapper<BVO> rm = new BeanPropertyRowMapper<BVO>(BVO.class);
		bVOs = (ArrayList<BVO>)template.query(sql, rm);
		return bVOs;
		
		
		
//		ArrayList<BVO> bVOs = new ArrayList<BVO>();
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			
//			String sql = "select bNo, bName, bSubject, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_bbs"
//					+ " order by bGroup desc, bStep asc"; // order 앞에 한칸을 뛰어쓰기 해줘야한다.
//			
//			System.out.println("검색 성공");
//			
//			preparedStatement = connection.prepareStatement(sql);
//			resultSet = preparedStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				int bNo = resultSet.getInt("bNo");
//				String bName = resultSet.getString("bName");
//				String bSubject = resultSet.getString("bSubject");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				
//				int bHit = resultSet.getInt("bHit");
//				int bGroup = resultSet.getInt("bGroup");
//				int bStep = resultSet.getInt("bStep");
//				int bIndent = resultSet.getInt("bIndent");
//				
//				BVO bVO = new BVO(bNo, bName, bSubject, bContent, bDate, bHit, bGroup, bStep, bIndent);
//				bVOs.add(bVO);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(resultSet != null ) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null ) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return bVOs;
	}//list()
	
	
	//글쓰기 메서드 write()
	public void write(final String bName, final String bSubject, final String bContent) {
		
		//익명클래스( 클래스안에 클래스)
		//update 방법 1  createPreparedStatement를 이용
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				String sql = "insert into mvc_bbs(bNo, bName, bSubject, bContent, bHit, bGroup, bStep, bIndent)"
						+ "values(seq_bbs.nextval,?,?,?,0,seq_bbs.currval,0,0)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
			    //내부 클래스에서 파라미터 변수가 변경되지 않을려면 write()메서드의 파라미터 값을 final해줘야한다.
				preparedStatement.setString(1, bName);
				preparedStatement.setString(2, bSubject);
				preparedStatement.setString(3, bContent);
				
				return preparedStatement;
			}
		});
		
	
		
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			System.out.println("---------connetion 확보--------------");
//			
//			String sql = "insert into mvc_bbs(bNo, bName, bSubject, bContent, bHit, bGroup, bStep, bIndent)"
//					+ "values(seq_bbs.nextval,?,?,?,0,seq_bbs.currval,0,0)";
//			
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, bName);
//			preparedStatement.setString(2, bSubject);
//			preparedStatement.setString(3, bContent);
//			
//			int n = preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try{
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e2) {
//			e2.printStackTrace();
//			}
//		}
	}//write()
	
	//글 보기 메서
	public BVO contentView(String bbsNo) {
		//조회수 메서드 추가
		addHit(bbsNo);
		String sql = "select * from mvc_bbs where bNo = "+ bbsNo;
		
		RowMapper<BVO> rm = new BeanPropertyRowMapper<BVO>(BVO.class);
		return this.template.queryForObject(sql, rm);
		
//		BVO bVo = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			
//			String sql = "select * from mvc_bbs where bNo = ?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, Integer.parseInt(bbsNo)); //1은 위의 sql식의 ?에 들어갈 값
//																//bbsNo를 String으로 받아서 parseInt로 정수로 변경, 
//			resultSet = preparedStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				int bNo = resultSet.getInt("bNo");
//				String bName = resultSet.getString("bName");
//				String bSubject = resultSet.getString("bSubject");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				
//				int bHit = resultSet.getInt("bHit");
//				int bGroup = resultSet.getInt("bGroup");
//				int bStep = resultSet.getInt("bStep");
//				int bIndent = resultSet.getInt("bIndent");
//				
//				bVo = new BVO(bNo, bName, bSubject, bContent, bDate, bHit, bGroup, bStep, bIndent);
//			}
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(resultSet != null ) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null ) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return bVo;
	}//contentView()
	
	//글 수정
	public void modify(final String bNo, final String bName, final String bSubject, final String bContent) {
		//update 방법 2 PreparedStatementSetter를 이용
		String sql = "update mvc_bbs set bName = ?, bSubject = ?, bContent = ? where bNo = ?";
		this.template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, bName);
				preparedStatement.setString(2, bSubject);
				preparedStatement.setString(3, bContent);
				preparedStatement.setInt(4, Integer.parseInt(bNo));
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			System.out.println("커넥션 확보!!---------------------");
//			
//			String sql = "update mvc_bbs set bName = ?, bSubject = ?, bContent = ? where bNo = ?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, bName);
//			preparedStatement.setString(2, bSubject);
//			preparedStatement.setString(3, bContent);
//			preparedStatement.setInt(4, Integer.parseInt(bNo));
//			
//			int n = preparedStatement.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null ) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		
	}//modify()
		
	//글 삭제
	public void delete(final String bNo) {
		String sql = "delete from mvc_bbs where bNo = ?";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, Integer.parseInt(bNo));				
			}
		});
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String sql = "delete from mvc_bbs where bNo = ?";
//			
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, Integer.parseInt(bNo));
//			
//			
//			int n = preparedStatement.executeUpdate();
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null ) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
	}//delete()
	
	//답글 보기
	public BVO replyForm(String bNos) {
		
		String sql = "select * from mvc_bbs where bNo = " + bNos; //행(레코드)가 하나이므로 queryForObject() 사용
		//RowMapper 인터페이스가 제네릭타입의 BVO객체 정보를 반복문으로 정보를 하나씩 다 가져오게 된다.
		//sql문의 레코드가 하나 이므로 코드를 더 쉽고 빠르게 간결하게 가져올 수 있다.
		RowMapper<BVO> rm = new BeanPropertyRowMapper<BVO>(BVO.class); 
		return this.template.queryForObject(bNos, rm);
		
//		BVO bVO = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		try {
//			connection = dataSource.getConnection();
//			String sql = "select * from mvc_bbs where bNo = ?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, Integer.parseInt(bNos));
//			
//			resultSet = preparedStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				int bNo = resultSet.getInt("bNo");
//				String bName = resultSet.getString("bName");
//				String bSubject = resultSet.getString("bSubject");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				int bHit = resultSet.getInt("bHit");
//				int bGroup = resultSet.getInt("bGroup");
//				int bStep = resultSet.getInt("bStep");
//				int bIndent = resultSet.getInt("bIndent");
//				
//				bVO = new BVO(bNo, bName, bSubject, bContent, bDate, bHit, bGroup, bStep, bIndent);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null ) connection.close();
//				if(resultSet != null) resultSet.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return  bVO;
	}//replyForm()
		
	
	public void replyOk(String bNo,final String bName,final String bSubject,final String bContent, 
							final String bGroup,final String bStep,final String bIndent) {
		
		//글번호의 그룹과 몇번째 단계냐
		replySet(bGroup, bStep);
		
		String sql = "insert into mvc_bbs(bNo, bName, bSubject, bContent, bGroup, bStep, bIndent)"
				+ " values(seq_bbs.nextVal,?,?,?,?,?,?)";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, bName); //?값을 지정 1은 첫번쨰
				preparedStatement.setString(2, bSubject);
				preparedStatement.setString(3, bContent);
				preparedStatement.setInt(4, Integer.parseInt(bGroup));
				preparedStatement.setInt(5, Integer.parseInt(bStep)+1);
				preparedStatement.setInt(6, Integer.parseInt(bIndent)+1);
			}
		});
	
		
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String sql = "insert into mvc_bbs(bNo, bName, bSubject, bContent, bGroup, bStep, bIndent)"
//							+ " values(seq_bbs.nextVal,?,?,?,?,?,?)";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, bName); //?값 지정 1은 첫번쨰
//			preparedStatement.setString(2, bSubject);
//			preparedStatement.setString(3, bContent);
//			preparedStatement.setInt(4, Integer.parseInt(bGroup));
//			preparedStatement.setInt(5, Integer.parseInt(bStep)+1);
//			preparedStatement.setInt(6, Integer.parseInt(bIndent)+1);
//			
//			int n = preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null ) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
	}//replyOk()
	
	public void replySet(final String group, final String step){
		String sql = "update mvc_bbs set bStep = bStep+1 where bGroup = ? and bStep>?";
		this.template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setInt(1, Integer.parseInt(group));
				preparedStatement.setInt(2, Integer.parseInt(step));
			}
		});
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String sql = "update mvc_bbs set bStep = bStep+1 where bGroup = ? and bStep>?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, Integer.parseInt(group));
//			preparedStatement.setInt(2, Integer.parseInt(step));
//			
//			int n = preparedStatement.executeUpdate();
//			//내용을 update하는 것은 ResultSet이 필요없다.
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null ) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
	}//replySet()
	
	//조회수 증가 메서드
	private void addHit(final String bNo){
		String sql = "update mvc_bbs set bHit = bHit + 1 where bNo = ?";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, bNo);				
			}
		});
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			
//			String sql = "update mvc_bbs set bHit = bHit + 1 where bNo = ?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, bNo);
//			
//			int n = preparedStatement.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null ) connection.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
	}//addHit()
	
	
}
