package controller;

import java.util.List;

public interface BracketControllerIF {

	public List<Team> getTeams();
	public void givePointsToTeam(Team team, int pointsToWin);
	public List<BracketRound> getBracketRound();
	public void createBracketRound(List<Team> listOfTeams);
}
