package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
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
	public void createBracket(List<Team> listOfTeams, int tournamentId) {
		this.bracket = new Bracket();
		bracket.setBracketId(getNextBracketId());
		try {
			saveToDatabase(tournamentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createBracket(List<Team> listOfTeams) {
		//this.bracket = new Bracket(listOfTeams);

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
		
	private void saveToDatabase(int tournamentId) throws SQLException {
		try {
			bracketDAO.createBracket(tournamentId, bracket);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
