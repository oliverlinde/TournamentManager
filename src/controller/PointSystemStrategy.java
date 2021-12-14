package controller;

import java.util.ArrayList;

import model.Bracket;
import model.Team;
import model.Tournament;

/*
 * Not yet implemented. The strategy is implementing the GenerateBracketStrategyIF and determines which way the bracket generates.
 */
public class PointSystemStrategy implements GenerateBracketStrategyIF {

	@Override
	public int calculatePoints() {
		return 0;
	}

	@Override
	public void proceedToNextRound(ArrayList<Team> linkedList, MatchControllerIF matchController, int noOfRounds,
			int bracketRoundId) {	
	}


	@Override
	public Bracket initializeTournament(Tournament tournament) {
		return null;
	}
}
