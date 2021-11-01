package com.test.ex05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ExtConfig {
	//Java 파일에 외부 프로퍼티 파일을 명시하는 방법(config)
	
	@Value("${env.id}")
	private String envid;
	@Value("${env.pwd}")
	private String envpwd;
	@Value("${ext.id}")
	private String extid;
	@Value("${ext.pwd}")
	private String extpwd;
	
	
	//properties파일 컨테이너에서 호출해서 사용하는 메서드
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		//해당 프로퍼티 파일의 위치값을 저장하는 객체
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("env.properties");
		locations[1] = new ClassPathResource("external.properties");
		configurer.setLocations(locations);
		
		return configurer;
	}
	
	//extConfig()파일
	@Bean
	public ExternalFileEx extConf() {
		ExternalFileEx ext = new ExternalFileEx();
		ext.setId(envid);
		ext.setPwd(envpwd);
		ext.setExtId(extid);
		ext.setExtPwd(extpwd);
		
		return ext;
	}
	
}
