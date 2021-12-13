package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.BracketRoundResult;
import model.Team;

public class BracketRoundResultDAO implements BracketRoundResultDAOIF {
	private DbConnectionIF dbConnection;
	private MatchRoundResultDAOIF matchRoundResultDAO;
	private TeamDAOIF teamDAO;

	public BracketRoundResultDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}

	public void addPointsToTeam(Team team, int points) {

	}

	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers, int point) {
		String sqlQuery = "INSERT INTO TeamInBracketRound (teamId, bracketRoundId, points) " + "VALUES (?, ?, ?) ";

		int nextBracketRoundId = getNextBracketRoundId();

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			for (Team winner : listOfWinners) {
				statement.setInt(1, winner.getTeamId());
				statement.setInt(2, nextBracketRoundId);
				statement.setInt(3, point);
			}

			for (Team loser : listOfLosers) {
				statement.setInt(1, loser.getTeamId());
				statement.setInt(2, nextBracketRoundId);
				statement.setInt(3, 0);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

	public Team getWinnerOfBracketRound(int matchRoundResultId) {

		Team winnerTeam = null; // matchRoundResultDAO.getTotalListOfMatchRoundResults(matchId);

		String sqlQuery = "SELECT matchRoundResultId, teamId, isWinner FROM MatchRoundResult WHERE matchRoundResultId = ? ";

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, matchRoundResultId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				if (rs.getBoolean(4)) {
					winnerTeam = teamDAO.getTeam(rs.getInt(3));
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return winnerTeam;

	}

	public void setBracketRoundResult(int bracketRoundId, Team team) throws SQLException {
		String sqlQuery = "UPDATE BracketRoundResult " + "SET isWinner = (?) "
				+ "WHERE matchRoundResult = ? AND teamId = ? ";

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, bracketRoundId);
			statement.setInt(3, team.getTeamId());
			statement.setBoolean(4, true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int getNextBracketRoundId() {
		String sqlQuery = "SELECT bracketRoundId FROM BracketRound WHERE bracketRoundId = (SELECT MAX (bracketRoundId) FROM BracketRound) ";

		int nextBracketRoundId = 0;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet rs = statement.executeQuery();

			rs.next();
			nextBracketRoundId = rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nextBracketRoundId + 1;
	}
	

	public BracketRoundResult getBracketRoundResult(int bracketRoundId) throws SQLException {
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO(dbConnection);
		String sqlQuery = "SELECT teamId, points FROM TeamInBracketRound " + "WHERE bracketRoundId = ? ";

		BracketRoundResult foundBracketRoundResult = null;
		Map<Team, Integer> pointsToTeam = new HashMap<>();

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				pointsToTeam.put(teamDAO.getTeam(rs.getInt(1)), rs.getInt(2));
			}

			foundBracketRoundResult = new BracketRoundResult(pointsToTeam);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return foundBracketRoundResult;
	}
}
