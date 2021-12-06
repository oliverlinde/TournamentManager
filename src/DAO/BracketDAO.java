package DAO;

import java.sql.Connection;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import model.BracketRound;
import model.Team;

public class BracketDAO implements BracketDAOIF {
	private List<BracketRound> listOfBracketRounds;
	private DbConnectionIF dbConnection;
	
	public BracketDAO(List<Team> teams) {
		dbConnection = new DbConnection();
	}
	
	public List<Team> getTeams() {
		return null;
	}
	
	public void givePointsToTeam(Team team, int pointsToWin) {
		
	}
	
	public List<BracketRound> getBracketRounds() {
		return listOfBracketRounds;
		
	}
	
	public void createBracketRound(List<Team> listOfTeams) throws SQLServerException {
		dbConnection.getConnection();
	}

	@Override
	public void createBrackRound(List<Team> listOfTeams) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
