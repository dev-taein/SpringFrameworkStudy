package com.spring.mybatis02.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//DAO객체를 구현하는 클래스(서비스)객체 [서비스 대신 Repository를 사용해도 된다.]
//@Service
@Repository
public class MybatisMemberMapperImpl implements MybatisMemberMapper{
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public List<MybatisMember> getAllMember() {
//		List<MybatisMember> members = new ArrayList<MybatisMember>();
//		MybatisMemberMapper mybatisMemberMapper = sqlSession.getMapper(MybatisMemberMapper.class);
//		members = mybatisMemberMapper.getAllMember();
//		return members;
//		return mybatisMemberMapper.getAllMember();
		
		
		//위의 코드를 더 간결하게 처리
		return sqlSession.selectList("getAllMember");
	}//select(all)
	
	@Override
	public MybatisMember getMember(String id) {
//		MybatisMemberMapper mybatisMemberMapper = sqlSession.getMapper(MybatisMemberMapper.class);
//		return mybatisMemberMapper.getMember(id);
		
		//sqlSessionTemplate를 이용함
		//selectOne(getMember)의 getMember는 MybatisMemberMapper.xml의 select id="getMember"의 id부분이 매개변수값으로 쓰임
		//selectOne("해당메서드의 xml의 id값",메서드 매개변수 이름)
		return sqlSession.selectOne("getMember",id);
	}//select(1)
	
	@Override
	public void insertMember(MybatisMember mybatisMember) {
//		MybatisMemberMapper mybatisMemberMapper = sqlSession.getMapper(MybatisMemberMapper.class);
//		mybatisMemberMapper.insertMember(mybatisMember);
		
		//더 쉽게 쓰기
		sqlSession.insert("insertMember",mybatisMember);
	}//insert
	
	@Override
	public void updateMember(MybatisMember mybatisMember) {
		MybatisMemberMapper mybatisMemberMapper = sqlSession.getMapper(MybatisMemberMapper.class);
		mybatisMemberMapper.updateMember(mybatisMember);
		
		//또는
//		sqlSession.update("updateMember", mybatisMember);
	}//update
	
	
	@Override
	public void deleteMember(String id) {
//		MybatisMemberMapper mybatisMemberMapper = sqlSession.getMapper(MybatisMemberMapper.class);
//		mybatisMemberMapper.deleteMember(id);
		
		//또는
		sqlSession.delete("deleteMember", id);
	}//delte
}
