package controller;

import java.util.ArrayList;

import java.util.List;

import model.MatchRoundResult;
import model.Team;

public interface MatchRoundResultControllerIF {
	void setWinner(Team team);

	void setLoser(Team team);

	void setDraw();

	int getNextMatchRoundResultId();

	void createMatchRoundResultList();

	ArrayList<MatchRoundResult> getMatchRoundResultList();

	List<MatchRoundResult> getListOfMatchRoundResults(int matchId);

	List<MatchRoundResult> generateMatchRoundResults(int noOfRounds);

}
