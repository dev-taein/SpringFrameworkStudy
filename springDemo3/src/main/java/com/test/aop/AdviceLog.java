package com.test.aop;

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
}
