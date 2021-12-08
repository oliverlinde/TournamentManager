package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.MatchRoundResult;
import model.Team;

public class MatchRoundResultDAO implements MatchRoundResultDAOIF {
	private DbConnectionIF dbConnection;
	private TeamDAOIF teamDAO;

	public MatchRoundResultDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}

	public void setWinner(int matchRoundResultId, Team team) throws SQLException {
		String sqlQuery = "UPDATE MatchRoundResult " + "SET isWinner = (?) "
				+ "WHERE matchRoundResult = ? AND teamId = ?";

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(2, matchRoundResultId);
			statement.setInt(3, team.getTeamId());
			statement.setBoolean(1, true);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * Not currently implemented
	 * 
	 * public void setLoser(Team team) {
	 * 
	 * }
	 * 
	 * public void setDraw(int matchRoundResultId) {
	 * 
	 * }
	 */

	public MatchRoundResult getRoundResult(int matchRoundResultId) {
		teamDAO = DAOFactory.createTeamDAO(dbConnection);
		String sqlQuery = "SELECT matchRoundResultId, teamId, isWinner " + "WHERE matchRoundResultId = ?";

		MatchRoundResult foundMatchRoundResult = null;
		Team winner = null;
		Team loser = null;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, matchRoundResultId);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getBoolean(3)) {
					winner = teamDAO.getTeam(rs.getInt(2));
				} else {
					loser = teamDAO.getTeam(rs.getInt(2));
				}

			}
			foundMatchRoundResult = new MatchRoundResult(rs.getInt(1), winner, loser, rs.getBoolean(3));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return foundMatchRoundResult;
		
	}
	
	/*
	public MatchRoundResult getTotalRoundResult() {
		String sqlQuery = "SELECT matchRoundResultId, teamId, isWinner ";
		
		List<Team> listOfWinners = null;
		List<Team> listOfLosers = null;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				if(rs.getBoolean(3)) {
					listOfWinners.add(rs.getInt(2));
				} else {
					listOfLosers.add(rs.getInt(2));
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	*/

}
