package com.spring.ormDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import com.spring.ormVO.BVO;


@Service
public class BbsDAO implements BDAO {
	
	//템플릿은 JDBCTemplate 적용
	JdbcTemplate template;
	
	@Autowired //servlete.context.xml에서 만든 template 적용
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public ArrayList<BVO> list() {
		//MyBatis이용해서 적용
		String sql = "select * from mybatis_bbs order by bId desc";
		ArrayList<BVO> bvos = (ArrayList<BVO>) template.query(sql, new BeanPropertyRowMapper<BVO>(BVO.class));
		return bvos;
	}
	
	@Override
	public void writeOk(final String name,final String bContent) {
		System.out.println("writeOk()호출");
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				String sql = "insert into mybatis_bbs(bId, bName, bContent)"
								+ " values(seq_mybatis_bbs.nextval,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, bContent);
				
				return ps;
			}
		});
	}
	
	@Override
	public void delete(String bId) {
		System.out.println("delete() 호출");
		
//		this.template.upda
	}
}
