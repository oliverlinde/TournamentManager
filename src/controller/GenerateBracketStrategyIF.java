package controller;

import java.util.ArrayList;
import java.util.List;

import model.Team;

public interface GenerateBracketStrategyIF {

	public void proceedToNextRound(ArrayList<Team> listOfTeams, MatchControllerIF matchController, int noOfRounds);
	public int calculatePoints();
	public void initializeTournament(List<Team> listOfTeams, BracketControllerIF bracketController);
}
