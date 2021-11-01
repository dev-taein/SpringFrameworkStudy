package com.test.ex06;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainProfile2 {

	
	public static void main(String[] args) {
		//자바코드를 이용한 profile 설정방법
		String profile = null;
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.next();
		if(str.equals("devlop")) {
			profile = "devlop";
		} else if(str.equals("service")) {
			profile = "service";
		}
		scanner.close();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(profile);
		//자바파일 가져오기
		ctx.register(DevConfig.class, ServiceConfig.class);
		ctx.refresh();
		
		ProfileEx prof = ctx.getBean("profileEx", ProfileEx.class);
		System.out.println("ip : " + prof.getIp());
		System.out.println("port : " + prof.getPort() );
		
		ctx.close();
	}

}
