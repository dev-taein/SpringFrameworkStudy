package com.test.diEx05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarTester {
	public static void main(String[] args) {
		
		String confLoc = "classpath:car.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(confLoc);
		
		Car car = ctx.getBean("car", Car.class);
		car.drive();
	}

}
