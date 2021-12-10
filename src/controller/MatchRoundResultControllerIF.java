package controller;


import java.util.ArrayList;

import java.util.List;

import model.MatchRoundResult;
import model.Team;

public interface MatchRoundResultControllerIF {
	public void setWinner(Team team);
	public void setLoser(Team team);
	public void setDraw();

	public MatchRoundResult getRoundResult(int matchRoundResultId);
	MatchRoundResult getMatchRoundResult();
	int getNextMatchRoundResultId();
	MatchRoundResult createMatchRoundResult();
	public void createMatchRoundResultList();
	ArrayList<MatchRoundResult> getMatchRoundResultList();
	List<MatchRoundResult> addRoundResult(int noOfRounds);

	MatchRoundResult getMatchRoundResult(int matchId);
	List<MatchRoundResult> getListOfMatchRoundResults(int matchId);

}
