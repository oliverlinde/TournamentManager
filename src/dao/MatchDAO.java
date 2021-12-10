package dao;

import java.beans.Statement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import model.Match;
import model.MatchRoundResult;
import model.Team;

public class MatchDAO implements MatchDAOIF {
	private DbConnectionIF dbConnection;

	public MatchDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public void setMatchRoundResult(int matchRoundResultId, Team winningTeam) throws SQLException {
		MatchRoundResultDAOIF matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO(dbConnection);
		matchRoundResultDAO.setWinner(matchRoundResultId, winningTeam);

	}

	public void setIsDraw() {

	}


	@Override
	public List<Match> getMatchesFromBracketRound(int bracketRoundId) throws SQLException {
		List<Match> listOfMatches = new ArrayList<>();
		String sqlQuery = "SELECT matchId FROM Match WHERE bracketRoundId = ?";

		try {
			Connection connection = dbConnection.getConnection();

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, bracketRoundId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				listOfMatches.add(getMatch(rs.getInt(1)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return listOfMatches;

	}

	@Override
	public Match getMatch(int matchId) throws SQLException {
		MatchRoundResultDAOIF matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO(dbConnection);
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO(dbConnection);
		String sqlQuery = "SELECT Match.matchId, matchRoundResultId, Team.teamId, teamName FROM Match "
				+ "JOIN MatchRoundResult on Match.matchId = MatchRoundResult.matchId "
				+ "JOIN Team ON MatchRoundResult.teamId = Team.teamId " + "WHERE Match.matchId = ?";

		Match match = null;
		List<MatchRoundResult> matchRoundResults = new LinkedList<>();
		List<Team> listOfTeams = new LinkedList<>();

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, matchId);

			ResultSet rs = statement.executeQuery();

			List<MatchRoundResult> matchRoundResults = new LinkedList<>();
			List<Team> listOfTeams = new LinkedList<>();

			while (rs.next()) {
				matchRoundResults.add(matchRoundResultDAO.getRoundResult(rs.getInt(2)));
				Team team = new Team(rs.getInt(3), rs.getString(4));
				if (listOfTeams.isEmpty() || listOfTeams.contains(team)) {
					listOfTeams.add(team);
				}

			}
			foundMatch = new Match(matchRoundResults, listOfTeams);

			rs.next();
			matchRoundResults = matchRoundResultDAO.getMatchRoundResultsFromMatch(matchId);

			listOfTeams = teamDAO.getTeamsFromMatch(matchId);
			

			match = new Match(matchId, matchRoundResults, listOfTeams);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return match;
	}

	@Override
	public int createMatch(int bracketRoundId, Match match) throws SQLException {

		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);

		try {
			String sqlQuery = "INSERT INTO Match (matchId, bracketRoundId) " + "VALUES (?, ?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, match.getMatchId());
			statement.setInt(2, bracketRoundId);

			int matchCreated = statement.executeUpdate();

			if (matchCreated == 0) {
				throw new SQLException("Creating match failed.");
			}

			if (match.getMatchId() != 0) {
				for (Team t : match.getListOfTeams()) {
					for (int idx = 0; idx < match.getRoundResults().size(); idx++) {
						String insertMatchRoundResultSQL = "INSERT INTO MatchRoundResult (matchRoundResultId, matchId, teamId) "
								+ "VALUES (?, ?, ?)";
				
						PreparedStatement insertMatchRoundResult = connection
								.prepareStatement(insertMatchRoundResultSQL);
						
						insertMatchRoundResult.setInt(1, match.getRoundResults().get(idx).getMatchRoundResultId());
						insertMatchRoundResult.setInt(2, match.getMatchId());
						insertMatchRoundResult.setInt(3, t.getTeamId());
						
						insertMatchRoundResult.execute();
					}
				}
			} else {
				throw new SQLException("Creating match failed, no ID obtained");
			}

			connection.commit();
			return matchCreated;

		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			connection.setAutoCommit(true);
		}
		return 0;
	}

	public void createRoundResult() {

	}

	@Override
	public void setDraw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRoundResult(Team winningTeam) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getNextMatchId() throws SQLException {
		String sqlQuery = "SELECT matchId FROM Match " + "WHERE matchId = (SELECT MAX(matchId) FROM Match)";
		int nextMatchId = 0;

		try {
			Connection connection = dbConnection.getConnection();

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet rs = statement.executeQuery();
			rs.next();
			nextMatchId = rs.getInt(1);

		} catch (Exception e) {
		}

		return nextMatchId + 1;
	}

}
