package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
			e.printStackTrace();
		}
	}

	@Override
	public int createMatchRoundResult(int matchId, int teamId, MatchRoundResult matchRoundResult) throws SQLException {
		String sqlQuery = "INSERT INTO MatchRoundResult (matchRoundResultId, matchId, teamId) VALUES (?, ?, ?) ";

		int matchRoundResultCreated = 0;
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);

		try {

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, matchRoundResult.getMatchRoundResultId());
			statement.setInt(2, matchId);
			statement.setInt(3, teamId);

			statement.execute();
			connection.commit();
			System.out.println("MatchRoundResult created");

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new SQLException("MatchRoundResult not created " + matchRoundResult.getMatchRoundResultId());
		} finally {
			connection.setAutoCommit(true);
		}
		return matchRoundResultCreated;
	}

	@Override
	public Set<Integer> getMatchRoundResultIds(int matchId) throws SQLException {
		Set<Integer> listOfMatchRoundResultIds = new HashSet<>();
		String sqlQuery = "SELECT matchRoundResultId FROM MatchRoundResult " + "WHERE matchId = ?";
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, matchId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				listOfMatchRoundResultIds.add(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfMatchRoundResultIds;
	}

	@Override
	public MatchRoundResult getMatchRoundResultFromMatchIdAndMatchRoundResultId(int matchId, int matchRoundResultId)
			throws SQLException {
		teamDAO = DAOFactory.createTeamDAO();
		String sqlQuery = "SELECT matchRoundResultId, teamId, isWinner, matchId FROM MatchRoundResult "
				+ "WHERE matchId = ? AND matchRoundResultId = ?";

		MatchRoundResult matchRoundResult = null;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, matchId);
			statement.setInt(2, matchRoundResultId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				if (rs.getBoolean(3) == true && matchRoundResult == null) {
					matchRoundResult = new MatchRoundResult(rs.getInt(1), teamDAO.getTeam(rs.getInt(2)), null, false);
				} else if (rs.getBoolean(3) == false && matchRoundResult == null) {
					matchRoundResult = new MatchRoundResult(rs.getInt(1), null, teamDAO.getTeam(rs.getInt(2)), false);
				}

				if (matchRoundResult.getWinner() == null && matchRoundResult.getLoser().getTeamId() != rs.getInt(2)) {
					matchRoundResult.setWinner(teamDAO.getTeam(rs.getInt(2)));
				} else if (matchRoundResult.getLoser() == null
						&& matchRoundResult.getWinner().getTeamId() != rs.getInt(2)) {
					matchRoundResult.setLoser(teamDAO.getTeam(rs.getInt(2)));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchRoundResult;
	}

	@Override
	public List<MatchRoundResult> getMatchRoundResultsFromMatch(int matchId) throws SQLException {
		List<MatchRoundResult> listOfMatchRoundResults = new ArrayList<>();

		Set<Integer> listOfMatchRoundResultIds = getMatchRoundResultIds(matchId);
		for (Integer integer : listOfMatchRoundResultIds) {
			listOfMatchRoundResults.add(getMatchRoundResultFromMatchIdAndMatchRoundResultId(matchId, integer));
		}

		return listOfMatchRoundResults;

	}

	@Override
	public List<Team> getTeamsFromMatch(int matchId) throws SQLException {
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO();
		List<Team> listOfTeams = new LinkedList<>();

		String sqlQuery = "SELECT teamId FROM MatchRoundResult WHERE matchId = ? AND matchRoundResultId = ?";

		try {
			Connection connection = dbConnection.getConnection();

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			int matchRoundResultId = getMatchRoundResultIds(matchId).iterator().next();

			statement.setInt(1, matchId);
			statement.setInt(2, matchRoundResultId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				listOfTeams.add(teamDAO.getTeam(rs.getInt(1)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfTeams;
	}

	@Override
	public int getCurrentMatchRoundResultId() throws SQLException {
		String sqlQuery = "SELECT matchRoundResultId FROM MatchRoundResult "
				+ "WHERE matchRoundResultId = (SELECT MAX(matchRoundResultId) FROM MatchRoundResult)";
		int currentMatchRoundResultId = 0;

		try {
			Connection connection = dbConnection.getConnection();

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.executeQuery();

			ResultSet rs = statement.executeQuery();
			rs.next();
			currentMatchRoundResultId = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return currentMatchRoundResultId;
	}

}
