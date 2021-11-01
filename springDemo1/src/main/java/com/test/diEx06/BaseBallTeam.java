package com.test.diEx06;

public class BaseBallTeam {
	
	String manager; //야구 감독
	String battingCoach;
	String pitchingCoach;
	String hitter;
	String pitcher;
	
	public BaseBallTeam() {
		// TODO Auto-generated constructor stub
	}

	public BaseBallTeam(String manager, String battingCoach, String pitchingCoach) {
		super();
		this.manager = manager;
		this.battingCoach = battingCoach;
		this.pitchingCoach = pitchingCoach;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getBattingCoach() {
		return battingCoach;
	}

	public void setBattingCoach(String battingCoach) {
		this.battingCoach = battingCoach;
	}

	public String getPitchingCoach() {
		return pitchingCoach;
	}

	public void setPitchingCoach(String pitchingCoach) {
		this.pitchingCoach = pitchingCoach;
	}

	public String getHitter() {
		return hitter;
	}

	public void setHitter(String hitter) {
		this.hitter = hitter;
	}

	public String getPitcher() {
		return pitcher;
	}

	public void setPitcher(String pitcher) {
		this.pitcher = pitcher;
	}
	
	
	
}
