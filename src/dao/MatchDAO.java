package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		MatchRoundResultDAOIF matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO();
		matchRoundResultDAO.setWinner(matchRoundResultId, winningTeam);

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
			e.printStackTrace();
		}

		return listOfMatches;

	}

	@Override
	public Match getMatch(int matchId) throws SQLException {
		MatchRoundResultDAOIF matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO();
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO();
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

			rs.next();
			matchRoundResults = matchRoundResultDAO.getMatchRoundResultsFromMatch(matchId);

			listOfTeams = teamDAO.getTeamsFromMatch(matchId);

			match = new Match(matchId, matchRoundResults, listOfTeams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return match;
	}

	@Override
	public int createMatch(int bracketRoundId, Match match) throws SQLException {
		
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);
		int matchCreated = 0;

		try {
			String sqlQuery = "INSERT INTO Match (bracketRoundId) " + "VALUES (?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery, 
					PreparedStatement.RETURN_GENERATED_KEYS);

			statement.setInt(1, bracketRoundId);

			matchCreated = statement.executeUpdate();
			
			if(matchCreated == 0) {
				throw new SQLException("Match not created; id not obtained");
			}
			ResultSet matchIds = statement.getGeneratedKeys();
			
			if(matchIds.next()) {
				int matchId = matchIds.getInt(1);
				
				for(int idx = 0; idx < match.getListOfMatchRounds().size(); idx++) {
					MatchRoundResult matchRoundResult = match.getListOfMatchRounds().get(idx);
					for(Team team : match.getListOfTeams()) {
					String insertToMatchRoundResult = "INSERT INTO MatchRoundResult (matchRoundResultId, matchId, teamId) VALUES (?, ?, ?)";
					PreparedStatement insertMatchRoundResult = connection.prepareStatement(insertToMatchRoundResult);
					insertMatchRoundResult.setInt(1, matchRoundResult.getMatchRoundResultId());
					insertMatchRoundResult.setInt(2, matchId);
					insertMatchRoundResult.setInt(3, team.getTeamId());
					
					int orderLinesCreated = insertMatchRoundResult.executeUpdate();
					
					System.out.println("MatchRoundResult created");
					}
				}
			}
			connection.commit();
			System.out.println("Match created");
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new SQLException("Match not created " + match.getMatchId());
		} finally {
			connection.setAutoCommit(true);
		}
		return matchCreated;
	}

	public void createRoundResult() {

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
