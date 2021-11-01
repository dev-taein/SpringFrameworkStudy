package com.test.diEx06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBaseBall {

	public static void main(String[] args) {
		String confLoc1 = "classpath:baseBall1.xml";
		String confLoc2 = "classpath:baseBall2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(confLoc1, confLoc2);
		
		
		Player player1 = ctx.getBean("player1", Player.class);
		System.out.println(player1.getName());
		System.out.println(player1.getPosision());
		
		PlayerInfo playerInfo  = ctx.getBean("playerInfo1", PlayerInfo.class);
		Player player2 = playerInfo.getPlayer();
		System.out.println(player2.getName());
		System.out.println(player2.getPosision());
		
		if(player1.equals(player2)) {
			System.out.println("player1과 player2가 같은 선수입니다.");
		}
		
		System.out.println("--------------------------------------------");
		Player player3 = ctx.getBean("player3", Player.class);
		System.out.println(player3.getName());
		System.out.println(player3.getPosision());
		System.out.println(player3.getAge());
		
		System.out.println("---------------야구팀 구성------------------");
		
		BaseBallTeam baseBallTeam = ctx.getBean("baseBallTeam", BaseBallTeam.class);
		System.out.println("감독 : " + baseBallTeam.getManager());
		System.out.println("타격코치 : " + baseBallTeam.getBattingCoach());
		System.out.println("투수코치 : " + baseBallTeam.getPitchingCoach());
		System.out.println("타자 : " + baseBallTeam.getHitter());
		System.out.println("투수 : " + baseBallTeam.getPitcher());
		
	}

}
