package controller;

import java.util.ArrayList;
import java.util.List;

import model.Team;

public interface GenerateBracketStrategyIF {

	void proceedToNextRound(ArrayList<Team> listOfTeams, MatchControllerIF matchController, int noOfRounds, int bracketRoundId);
	public int calculatePoints();
	public void initializeTournament(List<Team> listOfTeams, BracketControllerIF bracketController, int tournamentId);
}
