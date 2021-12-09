package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.BracketDAO;
import dao.BracketRoundDAOIF;
import dao.DAOFactory;
import dao.DbConnection;
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
		bracketRoundDAO = DAOFactory.createBracketRoundDAO(new DbConnection());
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
	
		bracketRound = new BracketRound((ArrayList<Team>) listOfTeams, getBracketRoundId());
		generateBracketStrategy.proceedToNextRound((ArrayList<Team>) listOfTeams, matchController, noOfRounds, getBracketRoundId());
		bracketRound.setMatchesInBracketRound(matchController.getAllMatches());
		return bracketRound;
	}
	
	private int getBracketRoundId() {
		int id = 0;
		try {
			id = bracketRoundDAO.getNextBracketRoundId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void createBracketRound(int bracketId, BracketRound bracketRound) {
		try {
			bracketRoundDAO.createBracketRound(bracketId, bracketRound);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
