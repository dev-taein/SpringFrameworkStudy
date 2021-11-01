package com.test.aop2;

import org.aspectj.lang.ProceedingJoinPoint;


public class TimeCheckAdvice {
	//대상 메서드를 실행할 수 있는 기능을 가직 ProceedingJoinPoint를 전달 받는다.
	public Object check(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("method start....."); //비즈니스 로직 메서드
		
		//인터페이스로 실행될 비즈니스 로직
		//proceed()를 호출하지 않으면 비즈니스 로직을 수행할 수 없다.
		Object returnValue = joinPoint.proceed();
		System.out.println("method end......");
		
		//대상 메서드의 실행결과로 얻어진 값을 반환한다.
		return returnValue;
	}
}
