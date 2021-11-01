package com.test.diEx03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainPerson {

	public static void main(String[] args) {
		//xml설정코드로 사용한 의존관계
		String confLoc = "classpath:person.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(confLoc);
		PersonInfo personInfo = ctx.getBean("personInfo", PersonInfo.class);
		personInfo.getPersonInfo();
		
		System.out.println("----------------------------------------");
		
		//자바코드를 사용한 의존관계
		//빈에서 person2 생성자정보를 가져오는 법
		Person person = ctx.getBean("person2", Person.class);
		personInfo.setPerson(person);
		personInfo.getPersonInfo();
		
		ctx.close();
	}

}
