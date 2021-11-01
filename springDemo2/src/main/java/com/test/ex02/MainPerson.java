package com.test.ex02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainPerson {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:person.xml");
		
		Person person1 = ctx.getBean("person", Person.class);
		System.out.println("이름 : " + person1.getName());
		System.out.println("나이 : " + person1.getAge());
		System.out.println("person1"+person1);
		System.out.println("-------------------------------------------");
		
		Person person2 = ctx.getBean("person", Person.class);
		person2.setName("기모찌");
		System.out.println("이름 : " + person2.getName());
		System.out.println("나이 : " + person2.getAge());
		System.out.println("person2"+person2);
		
//		singleton : 스프링 컨테이너에 의해 한개의 빈객체만 생성
//		prototype : 빈을 사용할 때 마다 객체를 생성
		//bean의 xml파일 person.xml에서 scope가 singleton일때는 같고 prototype일때는 같지 않다.
		if(person2.equals(person1)) {
			System.out.println(" person1과 person2는 같다");
		} else {
			System.out.println(" person1과 person2는 같지 않다");
		}
	}

}
