package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Tournament;

public class TournamentDAO implements TournamentDAOIF {
	private DbConnectionIF dbConnection;
	
	public TournamentDAO() {
		dbConnection = new DbConnection();
		
	}
	
	@Override
	public int createTournament(Tournament tournament) throws SQLException{
		String sqlQuery = "INSERT INTO Tournament (tournamentId, tournamentName, gameName, maxNoOfTeams, minNoOfTeams)"
				+ "VALUES (?, ?, ?, ?, ?)";
		
		int value = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, tournament.getId());
			//statement.setInt(2, null);
			statement.setString(2, tournament.getName());
			statement.setString(3, tournament.getGame());
			//statement.setString(5, null);
			//statement.setString(6, null);
			statement.setInt(4, tournament.getMaxNoOfTeams());
			statement.setInt(5, tournament.getMinNoOfTeams());
			//statement.setString(9, null);
			
			value = statement.executeUpdate();
			//statement.setInt(9, 0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return value;
		
	}
	
	public Tournament getTournament(int tournamentId) throws SQLException{
		String sqlQuery = "SELECT tournamentId, tournamentName, gameName, maxNoOfTeams, minNoOfTeams FROM Tournament "
				+ "WHERE tournamentId = ?";
		
		Tournament foundTournament = null;
	
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, tournamentId);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				foundTournament = new Tournament(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				
			}
			
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return foundTournament; 
	}

}
