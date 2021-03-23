package de.deda.lobby.utils.scoreboard;

public class RankPlayer {

	private String prefix;
	private String team;
	
	public RankPlayer(String prefix, String team) {
		this.setPrefix(prefix);
		this.setTeam(team);
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}
