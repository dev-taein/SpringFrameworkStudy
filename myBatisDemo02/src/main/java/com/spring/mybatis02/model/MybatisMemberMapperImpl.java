package com.spring.mybatis02.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//DAO��ü�� �����ϴ� Ŭ����(����)��ü [���� ��� Repository�� ����ص� �ȴ�.]
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
		
		
		//���� �ڵ带 �� �����ϰ� ó��
		return sqlSession.selectList("getAllMember");
	}//select(all)
	
	@Override
	public MybatisMember getMember(String id) {
//		MybatisMemberMapper mybatisMemberMapper = sqlSession.getMapper(MybatisMemberMapper.class);
//		return mybatisMemberMapper.getMember(id);
		
		//sqlSessionTemplate�� �̿���
		//selectOne(getMember)�� getMember�� MybatisMemberMapper.xml�� select id="getMember"�� id�κ��� �Ű����������� ����
		//selectOne("�ش�޼����� xml�� id��",�޼��� �Ű����� �̸�)
		return sqlSession.selectOne("getMember",id);
	}//select(1)
	
	@Override
	public void insertMember(MybatisMember mybatisMember) {
//		MybatisMemberMapper mybatisMemberMapper = sqlSession.getMapper(MybatisMemberMapper.class);
//		mybatisMemberMapper.insertMember(mybatisMember);
		
		//�� ���� ����
		sqlSession.insert("insertMember",mybatisMember);
	}//insert
	
	@Override
	public void updateMember(MybatisMember mybatisMember) {
		MybatisMemberMapper mybatisMemberMapper = sqlSession.getMapper(MybatisMemberMapper.class);
		mybatisMemberMapper.updateMember(mybatisMember);
		
		//�Ǵ�
//		sqlSession.update("updateMember", mybatisMember);
	}//update
	
	
	@Override
	public void deleteMember(String id) {
//		MybatisMemberMapper mybatisMemberMapper = sqlSession.getMapper(MybatisMemberMapper.class);
//		mybatisMemberMapper.deleteMember(id);
		
		//�Ǵ�
		sqlSession.delete("deleteMember", id);
	}//delte
}
