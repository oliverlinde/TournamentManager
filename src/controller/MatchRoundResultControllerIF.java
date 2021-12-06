package controller;

import model.MatchRoundResult;
import model.Team;

public interface MatchRoundResultControllerIF {
	public void setWinner(Team team);
	public void setLoser(Team team);
	public void setDraw();
	public MatchRoundResult getRoundResult(int matchRoundResultId);
}
