package controller;

import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.LinkedList;
=======
>>>>>>> origin/GUI_Latest
import java.util.List;

import dao.BracketDAOIF;
import dao.DbConnectionIF;
import dao.DAOFactory;
import model.Bracket;
import model.BracketRound;
import model.Match;
import model.Team;

public class BracketController implements BracketControllerIF {
	private BracketRoundControllerIF bracketRoundController;
	private BracketDAOIF bracketDAO;
	private Bracket bracket;

	public BracketController(DbConnectionIF dbConnection) {
		this.bracketDAO = DAOFactory.createBracketDAO(dbConnection);
		bracketRoundController = new BracketRoundController(dbConnection);
	}
	
	@Override
	public List<Team> getTeams() {
		return bracketDAO.getTeams();
	}

	@Override
	public void givePointsToTeam(Team team, int pointsToWin) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
<<<<<<< HEAD
	public void createBracket(List<Team> listOfTeams, int tournamentId) {
		this.bracket = new Bracket(listOfTeams);
		bracket.setBracketId(getNextBracketId());
		try {
			saveToDatabase(tournamentId);
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
=======
	public void createBracket(List<Team> listOfTeams) {
		//this.bracket = new Bracket(listOfTeams);
>>>>>>> origin/GUI_Latest
	}

	@Override
	public List<BracketRound> getBracketRound() {
		List<BracketRound> listOfBracketRounds = null;
		try {
			listOfBracketRounds = bracketDAO.getBracketRounds();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfBracketRounds;
	}

	@Override
	public void createBracketRound(List<Team> listOfTeams) {
		BracketRound bracketRound = bracketRoundController.createBracketRound((List<Team>) listOfTeams);
		addBracketRound(bracketRound);
	}
	
	@Override
	public void generateMatchesInBracketRound(GenerateBracketStrategyIF generateBracketStrategy, int noOfRounds) {
		bracketRoundController.createMatches(generateBracketStrategy, noOfRounds);
	}
	
	@Override
	public List<Match> getAllMatches(){
		return bracketRoundController.getAllMatches();
	}
	
	@Override
	public Bracket getBracket() {
		return this.bracket;
	}
	
	public void addBracketRound(BracketRound bracketRound) {
		bracket.addBracketRound(bracketRound);
		bracketRoundController.saveBracketRoundToDatabase(bracket.getBracketId(), bracketRound);
	}
	
	@Override
	public int getNextBracketId() {
		int nextId = 0;
		try {
			nextId = bracketDAO.getNextBracketId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextId;
	}
		
	private void saveToDatabase(int tournamentId) throws SQLServerException {
		try {
			bracketDAO.createBracket(tournamentId, bracket);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
