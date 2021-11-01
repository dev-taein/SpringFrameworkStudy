package com.test.ex04;

import java.io.IOError;
import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainEnv {

	public static void main(String[] args) throws IOException {
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		//Environment 객체를 얻어옴 = Environment는 모든 프로퍼티를 가지고 있음 
		ConfigurableEnvironment env = ctx.getEnvironment();
		//외부파일= env.properties를 얻어옴
		MutablePropertySources propertSources = env.getPropertySources();
		
		//외부 파일 프로퍼티 추가함 = addLast() = Environment에 프로퍼티를 추가하는거임
		propertSources.addLast(new ResourcePropertySource("classpath:env.properties"));
		
		//외부파일의 값 추출하는 법 Environment
		System.out.println(env.getProperty("env.id"));
		System.out.println(env.getProperty("env.pwd"));
		
		//설정파일 env.xml 이용
		GenericXmlApplicationContext gctx = (GenericXmlApplicationContext)ctx;
		gctx.load("classpath:env.xml");
		gctx.refresh();
		EnvironmentEx envEx = gctx.getBean("env", EnvironmentEx.class);
		System.out.println("env id : " + envEx.getId());
		System.out.println("env pwd : " + envEx.getPwd());
		gctx.close();
	}

}
