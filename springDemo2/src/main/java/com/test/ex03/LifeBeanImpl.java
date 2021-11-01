package com.test.ex03;

import org.springframework.beans.factory.BeanNameAware;

public class LifeBeanImpl implements LifeBean, BeanNameAware {
	
	private String beanName; //설정파일에서 bean의 id를 저장하기 위한 변수
	
	@Override
	public void lifeMethod() {
		System.out.println("비즈니스 로직을 수행합니다.");
		System.out.println("beanName : " + beanName );
	}
	
	//빈 객체가 자신의 이름을 알아야하는 경우 사용하는 메서드(객체가 생성 될때 해당 객체의 id값을 전달(주입) 받는 메서드)
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	
	//사용자 초기화 메서드
	public void init() {
		System.out.println("사용자 초기화 메서드");
	}
	
	//소멸 메서드
	public void end() {
		System.out.println("사용자 소멸 메서드");
	}
}
