package com.spring.customTagEx;

public class Member {
	private String id;
	private String name;
	private String email;
	private Address address;
	
	private String[] hobbys;
	private String job;
	private String[] gender;
	private String etc;
	private boolean contractAgreement;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String[] getHobbys() {
		return hobbys;
	}
	public void setHobbys(String[] hobbys) {
		this.hobbys = hobbys;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String[] getGender() {
		return gender;
	}
	public void setGender(String[] gender) {
		this.gender = gender;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public boolean isContractAgreement() {
		return contractAgreement;
	}
	public void setContractAgreement(boolean contractAgreement) {
		this.contractAgreement = contractAgreement;
	}
	
	
	

}
