package controller;

import java.util.List;

import model.Match;
import model.Team;

public interface MatchControllerIF {

	void setRoundResult(Team winningTeam);

	void setDraw();

	Match getMatch(int matchId);

	List<Match> getAllMatches(int bracketRoundId);

	void createListOfMatches();

	List<Match> generateMatches(int noOfRounds, List<Team> listOfTeams);

	int getNextMatchId();

}
