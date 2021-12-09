package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import model.BracketRound;
import model.Team;
import model.Bracket;

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

	// public void createBracketRound(List<Team> listOfTeams) throws
	// SQLServerException {
	// dbConnection.getConnection();
	// }

	@Override
	public int createBracket(int tournamentId, Bracket bracket) throws SQLException {
		String sqlQuery = "INSERT INTO Bracket (bracketId, tournamentId) "
				+ "VALUES (?, ?)";
		
		int bracketCreated = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, bracket.getBracketId());
			statement.setInt(2, tournamentId);
			
			bracketCreated = statement.executeUpdate();
			
		} catch (Exception e) {
		}
		return bracketCreated;
	}

	@Override
	public int getNextBracketId() throws SQLException {
		String sqlQuery = "SELECT bracketId FROM Bracket "
				+ "WHERE bracketId = (SELECT MAX(bracketId) FROM Bracket)";
		int nextBracketId = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			nextBracketId = rs.getInt(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return nextBracketId + 1;
	}
	
}
