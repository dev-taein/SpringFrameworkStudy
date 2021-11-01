package com.test.diEx02;

public class ExamDao {
	private String msg;
	
	public ExamDao() {
		
	}
	
	public ExamDao(String msg) {
		this.msg = msg;
	}
	
	public void outputMsg() {
		System.out.println("msg : " + msg);
	}
}
