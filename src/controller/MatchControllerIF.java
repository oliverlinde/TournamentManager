package controller;

import java.util.List;

import model.Match;
import model.Team;

public interface MatchControllerIF {

	public void setRoundResult(Team winningTeam);
	public void setDraw();
	public Match getMatch(int matchId);
	public void createRoundResult();
	List<Match> getAllMatches();
	void createListOfMatches();
	List<Match> getAllMatches(int bracketRoundId);
	List<Match> generateMatches(int noOfRounds, List<Team> listOfTeams);
	int getNextMatchId();
	
}
