package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Team;

public class TeamDAO implements TeamDAOIF {
	private DbConnection dbConnection;
	
	public TeamDAO(DbConnectionIF dbConnection) {
		this.dbConnection = new DbConnection();
		
	}
	
	public int createTeam(Team team) throws SQLException {
		String sqlQuery = "INSERT INTO Team (teamId, teamName) "
				+ "VALUES (?, ?)";
		
		int newTeamId = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, team.getTeamId());
			statement.setString(2, team.getTeamName());
			
			newTeamId = statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return newTeamId;
	}
	
	public Team getTeam(int teamId) throws SQLException {
		String sqlQuery = "SELECT teamId, teamName FROM Team "
				+ "WHERE teamId = ?";
		
		Team foundTeam = null;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, teamId);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				foundTeam = new Team(rs.getInt(1), rs.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return foundTeam;
	}

}
