package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.BracketDAO;
import dao.BracketRoundDAOIF;
import dao.DAOFactory;
import dao.DbConnection;
import dao.DbConnectionIF;
import model.BracketRound;
import model.BracketRoundResult;
import model.Match;
import model.Team;

public class BracketRoundController implements BracketRoundControllerIF {
	private MatchControllerIF matchController;
	private BracketRoundResultControllerIF bracketRoundResultController;
	private BracketRoundDAOIF bracketRoundDAO;
	private BracketRound bracketRound;

	public BracketRoundController(DbConnectionIF dbConnection) {
		bracketRoundDAO = DAOFactory.createBracketRoundDAO(dbConnection);
		this.matchController = new MatchController(dbConnection);
	}

	@Override
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public BracketRound createBracketRound(List<Team> listOfTeams) {
		bracketRound = new BracketRound((List<Team>) listOfTeams, getBracketRoundId());
		return bracketRound;
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
	public void createMatches(GenerateBracketStrategyIF generateBracketStrategy, int noOfRounds) {
		generateBracketStrategy.proceedToNextRound((ArrayList<Team>) bracketRound.getListOfTeams(), matchController, noOfRounds, bracketRound.getBracketRoundID());
		bracketRound.setMatchesInBracketRound(matchController.getAllMatches());
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
	public void saveBracketRoundToDatabase(int bracketId, BracketRound bracketRound) {
		try {
			bracketRoundDAO.createBracketRound(bracketId, bracketRound);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
