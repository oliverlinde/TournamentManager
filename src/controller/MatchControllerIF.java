package controller;

import java.util.List;

import model.Match;
import model.Team;

public interface MatchControllerIF {

	public void setRoundResult(Team winningTeam);
	public void setDraw();
	public Match getMatch(int matchId);
	public void createRoundResult();
	void createMatch(List<Team> listOfTeams);
	
}
