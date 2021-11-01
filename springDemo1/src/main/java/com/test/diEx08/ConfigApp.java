package com.test.diEx08;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration를 선언하면 이 클래스는 spring설정에 사용되는 클래스이다.
@Configuration
public class ConfigApp {
	
	//자바 코드안에서 xml 사용하는 방법
	//xml안에서 자바코드를 사용하는 방법
	// xml, java 혼용해서 사용하능 방법
	
	
	//@Bean은 메소드 앞에 선언, "객체를 생성"한다는 뜻
	@Bean
	public Player player1() {
		ArrayList<String> position = new ArrayList<String>();
		position.add("10번 타자");
		position.add("5루수");
		
		Player player = new Player("박병호", 10, position);
		player.setHeight(166);
		player.setWeight(50);
		
		return player;
	}
	
}
