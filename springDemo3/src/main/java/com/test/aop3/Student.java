package com.test.aop3;

//XML 스키마 기반의 AOP
//aop 작업순서 
//1. pom.xml 설정
//2. 공통기능 클래스 제작 - advice역할 = 여기서는 Student, Staff클래스를 이용함
//3. 핵심기능은 xml파일로 만든다. = pointcut 합치는 기능을 함 = aspect(핵심 기능의 영역)
public class Student {
	private String name;
	private String hackbun;
	private String age;
	private String grade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHackbun() {
		return hackbun;
	}
	public void setHackbun(String hackbun) {
		this.hackbun = hackbun;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	//학생 정보 얻어 오기
	public void getInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("학번 : " + getHackbun());
		System.out.println("나이 : " + getAge());
		System.out.println("학년 : " + getGrade());
		
			System.out.println(10/0);
			
	}
}
