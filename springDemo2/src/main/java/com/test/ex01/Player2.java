package com.test.ex01;

//어노테이션 오류 발생시 참고
//<!-- https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
import javax.annotation.*;
public class Player2 {
	
	private String name;
	private int age;
	
	public Player2() {
	}

	public Player2(String name, int age) {
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
	
	
	@PostConstruct
	public void init() {
		System.out.println("빈 생성시 처리해야할 작업~~");
	}
	
	
	@PreDestroy
	public void destroy() {
		System.out.println("빈 소멸시 처리해야할 작업~~");
	}
}
