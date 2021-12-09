package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Match;
import model.MatchRoundResult;
import model.Team;

public class MatchRoundResultDAO implements MatchRoundResultDAOIF {
	private DbConnectionIF dbConnection;
	private TeamDAOIF teamDAO;

	public MatchRoundResultDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
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
	
	@Override
	public int createMatchRoundResult(Match match, MatchRoundResult matchRoundResult) throws SQLException{
		String sqlQuery = "INSERT INTO Match (matchRoundResultId, matchId, teamId, isWinner) WHERE matchId = ? VALUES ?, ?, ?, ? ";
		
		int matchRoundResultCreated = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			for (Team teams : match.getListOfTeams()) {
				statement.setInt(1, matchRoundResult.getMatchRoundResultId());
				statement.setInt(2, match.getMatchId());
				statement.setInt(3, teams.getTeamId());
				
				matchRoundResultCreated += statement.executeUpdate();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return matchRoundResultCreated;
	}

	@Override
	public MatchRoundResult getRoundResult(int matchRoundResultId) throws SQLException {
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

	@Override
	public List<MatchRoundResult> getTotalListOfMatchRoundResults(int matchId) throws SQLException {

		List<MatchRoundResult> listOfMatchRoundResults = new LinkedList<>();

		String sqlQuery = "SELECT matchRoundResultId FROM MatchRoundResult WHERE matchId = ? ";

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, matchId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				listOfMatchRoundResults.add(getRoundResult(rs.getInt(1)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOfMatchRoundResults;
	}

}
