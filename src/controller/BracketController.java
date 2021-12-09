package controller;

import java.sql.SQLException;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import dao.BracketDAOIF;
import dao.DbConnectionIF;
import dao.DAOFactory;
import model.Bracket;
import model.BracketRound;
import model.Format;
import model.Match;
import model.Team;

public class BracketController implements BracketControllerIF {
	private BracketRoundControllerIF bracketRoundController;
	private BracketDAOIF bracketDAO;
	private Bracket bracket;

	public BracketController(DbConnectionIF dbConnection) {
		this.bracketDAO = DAOFactory.createBracketDAO(dbConnection);
		bracketRoundController = new BracketRoundController();
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
		this.bracket = new Bracket(listOfTeams);
		bracket.setBracketId(getNextBracketId());
		try {
			saveToDatabase(tournamentId);
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<BracketRound> getBracketRound() {
		return bracketDAO.getBracketRounds();
	}

	@Override
	public void createBracketRound(List<Team> listOfTeams, GenerateBracketStrategyIF generateBracketStrategy, int noOfRounds) {
		BracketRound bracketRound = bracketRoundController.createMatches(listOfTeams, generateBracketStrategy, noOfRounds);
		addBracketRound(bracketRound);
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
		bracketRoundController.createBracketRound(bracket.getBracketId(), bracketRound);
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
