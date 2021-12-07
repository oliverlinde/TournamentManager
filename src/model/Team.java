/*
 * Creates a specific team.
 * 
 * Not fully implemented. 
 */

package model;

public class Team {
	private int teamId;
	private String teamName;
	
	public Team(int teamId) {
		setTeamId(teamId);
	}
	
	public Team(int teamId, String teamName) {
		setTeamId(teamId);
		setTeamName(teamName);
	}
	
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public int getTeamId() {
		return teamId;
	}
	
	public String getTeamName() {
		return teamName;
	}

}
