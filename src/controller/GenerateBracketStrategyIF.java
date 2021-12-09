package controller;

import java.util.ArrayList;

import model.Team;

public interface GenerateBracketStrategyIF {

	void proceedToNextRound(ArrayList<Team> listOfTeams, MatchControllerIF matchController, int noOfRounds);
	public int calculatePoints();
}
