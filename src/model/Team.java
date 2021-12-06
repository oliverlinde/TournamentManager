/*
 * Creates a specific team.
 * 
 * Not fully implemented. 
 */

package model;

public class Team {
	private int teamId;
	private String teamName;
	
	public Team(Team teamId) {
		
	}
	
	public Team(int teamId, String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}
	
	public int getTeamId() {
		return teamId;
	}

}
