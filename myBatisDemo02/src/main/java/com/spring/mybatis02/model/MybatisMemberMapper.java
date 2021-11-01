package com.spring.mybatis02.model;

import java.util.List;


//DAO와 같은 역할
public interface MybatisMemberMapper {
	
	public List<MybatisMember> getAllMember(); //여러명의 정보를 가져옴
	public MybatisMember getMember(String id); //한명의 정보를 가져옴
	
	//insert
	public void insertMember(MybatisMember mybatisMember);
	//update
	public void updateMember(MybatisMember mybatisMember);
	//delete
	public void deleteMember(String	id);
	
	//위의 메서드를 처리하는것은 xml
	
}
