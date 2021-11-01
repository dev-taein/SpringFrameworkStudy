package com.test.ex06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



//자바코드를 이용한 profile 설정방법
@Configuration
@Profile("devlop")
public class DevConfig {
	@Bean
	public ProfileEx profileEx() {
		ProfileEx prof = new ProfileEx();
		prof.setIp("localhost");
		prof.setPort("9090");
		
		return prof;
	}
	
	
}
