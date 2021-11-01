package com.spring.mybatis02.model;

import java.util.List;


//DAO�� ���� ����
public interface MybatisMemberMapper {
	
	public List<MybatisMember> getAllMember(); //�������� ������ ������
	public MybatisMember getMember(String id); //�Ѹ��� ������ ������
	
	//insert
	public void insertMember(MybatisMember mybatisMember);
	//update
	public void updateMember(MybatisMember mybatisMember);
	//delete
	public void deleteMember(String	id);
	
	//���� �޼��带 ó���ϴ°��� xml
	
}
