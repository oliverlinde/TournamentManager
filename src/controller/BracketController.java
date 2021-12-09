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
	public void createBracketRound(List<Team> listOfTeams, GenerateBracketStrategyIF generateBracketStrategy, int noOfRounds) {
		bracket.addBracketRound(bracketRoundController.createMatches(listOfTeams, generateBracketStrategy, noOfRounds));
	}
	
	@Override
	public List<Match> getAllMatches(){
		return bracketRoundController.getAllMatches();
	}
	
	@Override
	public Bracket getBracket() {
		return this.bracket;
	}
		
//		try {
//			bracketDAO.createBracketRound(bracket);
//		} catch (SQLServerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

}
