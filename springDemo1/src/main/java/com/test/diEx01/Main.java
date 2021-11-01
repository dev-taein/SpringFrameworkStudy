package com.test.diEx01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
//		MyGetSum myGetSum = new MyGetSum();
//		
//		myGetSum.setGetsum(new GetSum());
//		
//		myGetSum.setA(10);
//		myGetSum.setB(100);
		
		// setter(설정 메소드)를 이용한 주입 
//	    : 설정 메소드를 사용해서 의존성을 주입하는 것
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:getsum.xml");
		MyGetSum myGetSum = ctx.getBean("myGetSum", MyGetSum.class);
		myGetSum.sum();
		
		
		
	}

}
