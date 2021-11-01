package com.test.aop4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//공통 기능 advice
//로그 기록을 남기는 코드

//@Aspect 어노테이션을 이용한 AOP
@Aspect
public class AdviceLog {
	//ProceedingJoinPoint는 원래 실행되어야할 대상의 메소드(핵심 기능)
//	@Pointcut("within(com.test.aop4.*)") //aop4 패키지 안의 모든 메서드를 동일하게 적용하겠다. @Before("within(com.test.aop4.*)") 방법1
//	@Pointcut("execution(* com.test.aop4.*.*())") //aop4 패키지 안의 모든 메서드를 동일하게 적용하겠다. @Before("pointcutMethod()") 방법 2
	@Pointcut("bean(student)") //student는 해당 xml파일의 bean id를 넣어야 한다. 해당 빈에만 적용하는 방법. 방법 3 //이것이 바로 관점지향프로그래밍(AOP)
	private void pointcutMethod() {}
	
	
	//공통 기능을 구현 할 내용 (around방식(시작,끝))
	@Around("pointcutMethod()")
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
	
	
//	@Before("within(com.test.aop4.*)")
	@Before("pointcutMethod()")
	//@Aspect를 이용시 @Before는 JoinPoint필요없음
	public void beforeAdvice() {
		System.out.println("beforeAdvice().....");
	}
//	//JoinPoint인터페이스 필요없음
//	public void afterReturningAdvice() {
//		System.out.println("afterReturningAdvice()...");
//	}
//	
//	public void afterThrowingAdive() {
//		System.out.println("afterThrowingAdive()...");
//	}
//	
//	public void afterAdvice() {
//		System.out.println("afterAdvice()...");
//	}
	
}
