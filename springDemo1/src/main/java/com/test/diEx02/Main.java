package com.test.diEx02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		Constructor(생성자)를 통한 주입
//	    : 생성자를 사용해서 의존성을 주입하는 것
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:examDao.xml");
		ExamDao eDao = ctx.getBean("examDao", ExamDao.class);
		eDao.outputMsg();
	}

}
