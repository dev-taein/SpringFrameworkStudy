package com.test.aop2;

public class ServiceImpl implements Service {
	
	@Override
	public void getBoard() {
		System.out.println("ServiceImpl.getBoard().....");
	}
	
	@Override
	public void addBoard() {
		System.out.println("ServiceImpl.addBoard().....");
	}
	
	@Override
	public void delBoard() {
		System.out.println("ServiceImpl.delBoard().....");
	}
	
	
	
}
