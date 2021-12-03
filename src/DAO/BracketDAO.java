package DAO;

import java.sql.Connection;
import java.util.List;

public class BracketDAO implements BracketDAOIF {
	private List<BracketRounds> listOfBracketRounds;
	private DbConnectionIF dbConnection;
	
	public BracketDAO(List<Team> teams) {
		dbConnection = new DbConnection();
	}
	
	public List<Team> getTeams() {
		return getListOfTeams();
	}
	
	public void givePointsToTeam(Team team, int pointsToWin) {
		
	}
	
	public List<BracketRounds> getBracketRounds() {
		
	}
	
	public void createBracketRound(List<Team> listOfTeams) {
		dbConnection.getConnection()
	}

	@Override
	public void createBrackRound(List<Team> listOfTeams) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
