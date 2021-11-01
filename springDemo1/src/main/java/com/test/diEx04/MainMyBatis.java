package com.test.diEx04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainMyBatis {

	public static void main(String[] args) {
		
		String confLoc = "classpath:myBatis.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(confLoc);
		MyBatisService myBatisService = ctx.getBean("service", MyBatisService.class);
		myBatisService.myBatisTest();
		ctx.close();
	}

}
