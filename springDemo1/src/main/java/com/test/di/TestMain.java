package com.test.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		String confLocation = "classpath:test.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(confLocation);
		
		//TestDAO testDao = new TestDAOImp(); 코드를 사용하지 않았음에도 불구하고 printMSG()를 호출하고 있다.
		TestDAO testdDao = ctx.getBean("TestDAOImp", TestDAOImp.class);
		System.out.println("=====================");
		testdDao.printMSG();
		System.out.println("=====================");
	}

}
