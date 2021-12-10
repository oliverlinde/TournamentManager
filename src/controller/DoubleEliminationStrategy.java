package controller;

import java.util.ArrayList;
import java.util.List;

import model.Team;

public class DoubleEliminationStrategy implements GenerateBracketStrategyIF {


	@Override
	public int calculatePoints() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void initializeTournament(List<Team> listOfTeams, BracketControllerIF bracketController, int tournamentId) {



}

	@Override
	public void proceedToNextRound(ArrayList<Team> linkedList, MatchControllerIF matchController, int noOfRounds,
			int bracketRoundId) {
		// TODO Auto-generated method stub
		
	}
}
