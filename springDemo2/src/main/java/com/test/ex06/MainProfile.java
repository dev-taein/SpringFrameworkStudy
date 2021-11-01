package com.test.ex06;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainProfile {

	public static void main(String[] args) {
		
		//xml파일로 이용한 profile 설정 방법
		String profile = null;
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.next();
		if(str.equals("devlop")) {
			profile = "devlop";
		} else if(str.equals("service")) {
			profile = "service";
		}
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//설정파일을 결정해주는 부분
		ctx.getEnvironment().setActiveProfiles(profile);
		//xml설정파일 가져오기
		ctx.load("dev.xml", "service.xml");
		
		ProfileEx prof = ctx.getBean("profileEx", ProfileEx.class);
		System.out.println("ip : " + prof.getIp());
		System.out.println("port : " + prof.getPort());
		
		ctx.close();
		
		
		
	}

}
