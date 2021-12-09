package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	public MatchRoundResult getRoundResult(int matchRoundResultId) throws SQLException {
		teamDAO = DAOFactory.createTeamDAO(dbConnection);
		String sqlQuery = "SELECT matchRoundResultId, teamId, isWinner FROM MatchRoundResult "
				+ "WHERE matchRoundResultId = ?";

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
			foundMatchRoundResult = new MatchRoundResult(matchRoundResultId, winner, loser, false);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return foundMatchRoundResult;

	}

	@Override
	public List<MatchRoundResult> getMatchRoundResultsFromMatch(int matchId) throws SQLException {
		List<MatchRoundResult> listOfMatchRoundResults = new ArrayList<>();

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
	
	@Override
	public List<Team> getTeamsFromMatchRoundResult(int matchRoundResultId) throws SQLException{
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO(dbConnection);
		List<Team> listOfTeams = new LinkedList<>();
		String sqlQuery = "SELECT teamId FROM MatchRoundResult WHERE matchRoundResultId = ?";
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, matchRoundResultId);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				listOfTeams.add(teamDAO.getTeam(rs.getInt(1)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOfTeams;
	}

	@Override
	public List<MatchRoundResult> getTotalListOfMatchRoundResults(int matchId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
