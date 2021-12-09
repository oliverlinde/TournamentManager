package controller;

import java.util.ArrayList;
import java.util.List;

import dao.BracketRoundDAOIF;
import model.BracketRound;
import model.BracketRoundResult;
import model.Match;
import model.Team;

public class BracketRoundController implements BracketRoundControllerIF {
	private MatchControllerIF matchController;
	private BracketRoundResultControllerIF bracketRoundResultController;
	private BracketRoundDAOIF bracketRoundDAO;
	private BracketRound bracketRound;

	public BracketRoundController() {
		this.matchController = new MatchController();
	}

	@Override
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers) {
		// TODO Auto-generated method stub

	}

	@Override
	public BracketRoundResult getBracketRoundResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Match> getAllMatches() {
		return matchController.getAllMatches();
	}

	@Override
	public BracketRound createMatches(List<Team> listOfTeams, GenerateBracketStrategyIF generateBracketStrategy,
			int noOfRounds) {
	
		bracketRound = new BracketRound();
		generateBracketStrategy.proceedToNextRound((ArrayList<Team>) listOfTeams, matchController, noOfRounds);
		bracketRound.setMatchesInBracketRound(matchController.getAllMatches());
		return bracketRound;
	}

}
