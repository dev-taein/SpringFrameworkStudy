package com.test.ex06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//자바코드를 이용한 profile 설정방법
@Configuration
@Profile("service")
public class ServiceConfig {
	@Bean
	public ProfileEx profileEx() {
		ProfileEx prof = new ProfileEx();
		prof.setIp("123.255.17.35");
		prof.setPort("80");
		
		return prof;
	}
}
