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
		setTeamName(teamName);
		setTeamId(teamId);
	}

	public int getTeamId() {
		return teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	private void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	private void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
