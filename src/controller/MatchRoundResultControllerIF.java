package controller;

import java.util.List;

import model.MatchRoundResult;
import model.Team;

public interface MatchRoundResultControllerIF {
	public void setWinner(Team team);
	public void setLoser(Team team);
	public void setDraw();
	MatchRoundResult getMatchRoundResult(int matchId);
	List<MatchRoundResult> getListOfMatchRoundResults(int matchId);
}
