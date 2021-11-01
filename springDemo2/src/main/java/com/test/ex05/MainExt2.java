package com.test.ex05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainExt2 {

	public static void main(String[] args) {
		//Java 파일에 외부 프로퍼티 파일을 명시하는 방법(config)
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ExtConfig.class);
		//extConfig 빈을 가져와야됨 이유는 extConfig메서드가 ExtConfig를 사용하고 있기때문에
		ExternalFileEx ext = ctx.getBean("extConf", ExternalFileEx.class);
		System.out.println("envId :"+ext.getId());
		System.out.println("envPwd :"+ext.getPwd());
		System.out.println("-----------------");
		System.out.println("extId :"+ext.getExtId());
		System.out.println("extPwd:"+ext.getExtPwd());
		
		ctx.close();
		
	}

}
