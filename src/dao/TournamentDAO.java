package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import model.Tournament;
import model.TournamentRule;

public class TournamentDAO implements TournamentDAOIF {
	private DbConnectionIF dbConnection;
	
	public TournamentDAO() {
		dbConnection = new DbConnection();
		
	}
	
	@Override
	public int createTournament(Tournament tournament) throws SQLException{
		String sqlQuery = "INSERT INTO Tournament "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		int value = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, tournament.getId());
			statement.setInt(2, tournament.getTournamentRule().getTournamentRuleId());
			statement.setString(3, tournament.getName());
			statement.setString(4, tournament.getGame());
			statement.setObject(5, tournament.getDateTimeOfEvent());
			statement.setObject(6, tournament.getRegistrationDeadline());
			statement.setInt(7, tournament.getMaxNoOfTeams());
			statement.setInt(8, tournament.getMinNoOfTeams());
			
			value = statement.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return value;

	}
	
	public Tournament getTournament(int tournamentId) throws SQLException{
		TournamentRuleDAOIF tournamentRuleDAO = DAOFactory.createTournamentRuleDAO(dbConnection);
		TournamentRule tournamentRule;
		
		String sqlQuery = "SELECT * FROM Tournament "
				+ " WHERE tournamentId = ?";
		
		Tournament foundTournament = null;
	
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, tournamentId);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				int tournamentRuleId = rs.getInt(2);
				String tournamentName = rs.getString(3);
				String tournamentGame = rs.getString(4);
				LocalDateTime timeOfEvent = rs.getObject(5, LocalDateTime.class);
				LocalDateTime registrationDeadline = rs.getObject(6, LocalDateTime.class);
				int maxTeams = rs.getInt(7);
				int minTeams = rs.getInt(8);
				
				tournamentRule = tournamentRuleDAO.getTournamentRule(tournamentRuleId);
				
				foundTournament = new Tournament(id, tournamentRule, tournamentName, tournamentGame, timeOfEvent, registrationDeadline, maxTeams, minTeams);
			}

			} catch (Exception e) {
				
			e.printStackTrace();
		}

		return foundTournament; 
	}

}
