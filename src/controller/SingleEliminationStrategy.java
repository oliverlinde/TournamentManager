package controller;

import java.util.ArrayList;

import java.util.List;

import dao.DAOFactory;
import model.Bracket;
import model.BracketRound;
import model.Match;
import model.Team;
import model.Tournament;

public class SingleEliminationStrategy implements GenerateBracketStrategyIF {

	MatchControllerIF matchController;
	

	//Not yet implemented, intended use is to take the winning teams and create a new BracketRound in the tournament
	@Override
	public void proceedToNextRound(ArrayList<Team> listOfTeams, MatchControllerIF matchController, int noOfRounds, int bracketRoundId) {

	}

	
	//Not yet implemented, intended use is to calculate the points of the team in the BracketRound
	@Override
	public int calculatePoints() {
		return 0;
	}

	//Used for initalizing a tournament, this method is single use only for the Tournament object, as this generates the initial Tournament structure
	@Override
	public Bracket initializeTournament(Tournament tournament) {
		MatchControllerIF matchController = new MatchController(DAOFactory.createMatchDAO());
		List<Match> listOfMatches = matchController.generateMatches(tournament.getTournamentRule().getNoOfRounds().getValue(), tournament.getAllTeams());
		
		BracketRoundControllerIF bracketRoundController = new BracketRoundController(DAOFactory.createBracketRoundDAO());
		BracketRound bracketRound = bracketRoundController.generateBracketRound(listOfMatches);
		
		BracketControllerIF bracketController = new BracketController(DAOFactory.createBracketDAO());
		Bracket bracket = bracketController.generateBracket(bracketRound);
		return bracket;
	}

}
