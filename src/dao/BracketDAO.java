package dao;

import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import model.BracketRound;
import model.Team;

public class BracketDAO implements BracketDAOIF {
	private List<BracketRound> listOfBracketRounds;
	private DbConnectionIF dbConnection;
	
	public BracketDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public List<Team> getTeams() {
		return null;
	}
	
	public void givePointsToTeam(Team team, int pointsToWin) {
		
	}
	
	public List<BracketRound> getBracketRounds() {
		return listOfBracketRounds;
		
	}
	
	//public void createBracketRound(List<Team> listOfTeams) throws SQLServerException {
		//dbConnection.getConnection();
	//}

	public boolean createBracket(int tournamentId) {
		String sqlQuery = "INSERT INTO Bracket (bracketId, tournamentId) WHERE tournamentId = ?  VALUES ?, ? ";
		
		boolean bracketCreated = false;
		
		
	}
	
}
