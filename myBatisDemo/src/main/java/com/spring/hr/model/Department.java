package com.spring.hr.model;

public class Department {
	
	private int deptId;
	private String deptName;
	private String deptMgr;
	private String locationId;
	
	public Department() {
	}
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptNmae(String deptNmae) {
		this.deptName = deptNmae;
	}
	public String getDeptMgr() {
		return deptMgr;
	}
	public void setDeptMgr(String deptMgr) {
		this.deptMgr = deptMgr;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	
}
