package com.spring.vo;

public class StudentVO {

	private Integer hakbun;
	private String name;
	private Integer grade;
	
	
	public Integer getHakbun() {
		return hakbun;
	}
	public void setHakbun(Integer hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "StudentVO [hakbun=" + hakbun + ", name=" + name + ", grade=" + grade + "]";
	}
	
}
