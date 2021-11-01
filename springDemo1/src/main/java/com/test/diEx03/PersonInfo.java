package com.test.diEx03;

public class PersonInfo {
	
	private Person person;
	
	public PersonInfo() {
	}

	public PersonInfo(Person person) {
		super();
		this.person = person;
	}
	
	public void getPersonInfo() {
		if(person != null) {
			System.out.println("이름 : " + person.getName());
			System.out.println("성별 : " + person.getGender());
			System.out.println("나이 : " + person.getAge());
			System.out.println("주민번호 : " + person.getIdNo());
		}
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
}
