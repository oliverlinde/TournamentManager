package controller;

import java.util.List;

import model.BracketRound;
import model.Format;
import model.Team;

public interface BracketControllerIF {

	public List<Team> getTeams();
	public void givePointsToTeam(Team team, int pointsToWin);
	public List<BracketRound> getBracketRound();
	public void createBracketRound(List<Team> listOfTeams, GenerateBracketStrategyIF generateBracketStrategy, int noOfRounds);
}
