package controller;

import java.util.ArrayList;

import java.util.List;

import model.Bracket;
import model.BracketRound;
import model.Match;
import model.Team;
import model.Tournament;

public class SingleEliminationStrategy implements GenerateBracketStrategyIF {

	MatchControllerIF matchController;
	
	@Override
	public void proceedToNextRound(ArrayList<Team> listOfTeams, MatchControllerIF matchController, int noOfRounds, int bracketRoundId) {
//		this.matchController = matchController;
//		matchController.createListOfMatches();
//		for(int i = 1 ; i <= Math.floor((listOfTeams.size()/2)) ; i++){
//			ArrayList<Team> temp = subArray(listOfTeams, ((i*2)-2), (i*2)-1);
//			matchController.createMatch(temp, noOfRounds, bracketRoundId);
//		}
	}

	@Override
	public int calculatePoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bracket initializeTournament(Tournament tournament) {
		MatchControllerIF matchController = new MatchController();
		List<Match> listOfMatches = matchController.generateMatches(tournament.getTournamentRule().getNoOfRounds().getValue(), tournament.getAllTeams());
		
		BracketRoundControllerIF bracketRoundController = new BracketRoundController();
		BracketRound bracketRound = bracketRoundController.generateBracketRound(listOfMatches);
		
		BracketControllerIF bracketController = new BracketController();
		Bracket bracket = bracketController.generateBracket(bracketRound);
		return bracket;
	}

}
