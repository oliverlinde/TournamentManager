package controller;

import java.util.List;

import dao.BracketRoundDAOIF;
import model.BracketRound;
import model.BracketRoundResult;
import model.Team;

public class BracketRoundController implements BracketRoundControllerIF {
	private MatchControllerIF matchController;
	private BracketRoundResultControllerIF bracketRoundResultController;
	private BracketRoundDAOIF bracketRoundDAO;
	private BracketRound bracketRound;
	
	public BracketRoundController() {
		
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
	public void createMatches(List<Team> listOfTeams) {
		// TODO Auto-generated method stub
		
	}

}
