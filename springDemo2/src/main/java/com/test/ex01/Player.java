package com.test.ex01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
public class Player implements InitializingBean, DisposableBean {

	//빈의 생명주기
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("빈의 생성시 처리할 명령들~~~");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("빈의 소멸시 처리할 명령들~~~");
	}
	
	
	
	private String name;
	private int age;
	
	public Player() {
	}

	public Player(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
}
