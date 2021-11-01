package com.test.aop4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainAop {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopEx04.xml");
		Student student = ctx.getBean("student", Student.class);
		Staff staff = ctx.getBean("staff", Staff.class);
		
		student.getInfo();
		System.out.println("=====================================================");
		staff.getInfo();
		
		ctx.close();
		
	}

}
