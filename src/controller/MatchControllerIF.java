package controller;

import model.Match;
import model.Team;

public interface MatchControllerIF {

	public void setRoundResult(Team winningTeam);
	public void setDraw();
	public Match getMatch(int matchId);
	public void createRoundResult();
	
}
