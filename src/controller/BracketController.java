package controller;

import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import dao.BracketDAOIF;
import dao.DbConnectionIF;
import dao.DAOFactory;
import model.Bracket;
import model.BracketRound;
import model.Format;
import model.Team;

public class BracketController implements BracketControllerIF {
	private BracketRoundControllerIF bracketRoundController;
	private BracketDAOIF bracketDAO;
	private Bracket bracket;

	public BracketController(DbConnectionIF dbConnection) {
		this.bracketDAO = DAOFactory.createBracketDAO(dbConnection); 
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
	public List<BracketRound> getBracketRound() {
		return bracketDAO.getBracketRounds();
	}

	@Override
	public void createBracketRound(List<Team> listOfTeams, GenerateBracketStrategyIF generateBracketStrategy, int noOfRounds) {
		
		
		
		try {
			bracketDAO.createBracketRound(listOfTeams);
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
