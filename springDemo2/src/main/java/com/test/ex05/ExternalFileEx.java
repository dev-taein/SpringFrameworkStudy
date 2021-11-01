package com.test.ex05;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ExternalFileEx implements InitializingBean, DisposableBean {
	//XML 파일에 외부프로퍼티 파일을 명시하는 방법
	
	private String id;
	private String pwd;
	private String extId;
	private String extPwd;
	
	
	//객체 생성시 프로퍼티 설정
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() 호출");
	}
	
	
	//close()시 실행
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() 호출");
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getExtId() {
		return extId;
	}


	public void setExtId(String extId) {
		this.extId = extId;
	}


	public String getExtPwd() {
		return extPwd;
	}


	public void setExtPwd(String extPwd) {
		this.extPwd = extPwd;
	}
	
	
}
