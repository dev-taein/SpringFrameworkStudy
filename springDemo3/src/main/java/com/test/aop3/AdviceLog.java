package com.test.aop3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//공통 기능 advice
//로그 기록을 남기는 코드
public class AdviceLog {
	//ProceedingJoinPoint는 원래 실행되어야할 대상의 메소드(핵심 기능)
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable{
		String signStr = joinPoint.getSignature().toString();
		System.out.println(signStr + " is start!!");
		//시작시간
		long startTime = System.currentTimeMillis();
		
		try {
			//핵심기능이 있는 메서드를 의미한다.
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			long endTime = System.currentTimeMillis();
			System.out.println(signStr + "isfinished!!!");
			System.out.println(signStr + " 경과 시간  : " + (endTime - startTime));
		} 
	}
	
	
// 		  [Advice 실행 종류]
//	      <aop:before> : 핵심기능이 실행 되기 전엔 advice를 실행한다.
//	      <aop:after-returning> : 정상적으로 핵심기능 실행 후에 advice를 실행
//	      <aop:after-throwing> : 핵심기능 실행 중에 exception이 발생 시 advice를 실행
//	      <aop:after> : 핵심기능 실행 후에 advice를 실행한다.(exception이 발생하더라도..)
//	      <aop:around> : 핵심기능 실행 전/후 및 exception 발생시 advice 실행
	
	//before는 JoinPoint필요함
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("beforeAdvice().....");
	}
	//JoinPoint인터페이스 필요없음
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()...");
	}
	
	public void afterThrowingAdive() {
		System.out.println("afterThrowingAdive()...");
	}
	
	public void afterAdvice() {
		System.out.println("afterAdvice()...");
	}
	
}
