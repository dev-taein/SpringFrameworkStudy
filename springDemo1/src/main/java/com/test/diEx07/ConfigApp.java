package com.test.diEx07;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration를 선언하면 이 클래스는 spring설정에 사용되는 클래스이다.
@Configuration
public class ConfigApp {
	
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
	
	@Bean
	public Player player2() {
		ArrayList<String> position = new ArrayList<String>();
		position.add("13번 타자");
		position.add("1루수");
		
		Player player = new Player("장성호", 22, position);
		player.setHeight(186);
		player.setWeight(54);
		
		return player;
	}
}
