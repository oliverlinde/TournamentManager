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
	public int createMatchRoundResult(Match match) throws SQLException{
		String sqlQuery = "INSERT INTO MatchRoundResult (matchRoundResultId, matchId) VALUES (?, ?) ";
		
		int matchRoundResultCreated = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, matchRoundResult.getMatchRoundResultId());
			statement.setInt(2, matchId);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return matchRoundResultCreated;
	}

	public Set<Integer> getMatchRoundResultIds(int matchId) throws SQLException{
		Set<Integer> listOfMatchRoundResultIds = new HashSet<>();
		String sqlQuery ="SELECT matchRoundResultId FROM MatchRoundResult "
				+ "WHERE matchId = ?";
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, matchId);

			ResultSet rs = statement.executeQuery();
			
			while (rs.next()){
				listOfMatchRoundResultIds.add(rs.getInt(1));
			}
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOfMatchRoundResultIds;
	}
	
	@Override
	public MatchRoundResult getMatchRoundResultFromMatchIdAndMatchRoundResultId(int matchId, int matchRoundResultId) throws SQLException {
		teamDAO = DAOFactory.createTeamDAO(dbConnection);
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
				}
				else if (rs.getBoolean(3) == false && matchRoundResult == null) {
					matchRoundResult = new MatchRoundResult(rs.getInt(1), null, teamDAO.getTeam(rs.getInt(2)), false);
				}
				
				if (matchRoundResult.getWinner() == null && matchRoundResult.getLoser().getTeamId() != rs.getInt(2)) {
					matchRoundResult.setWinner(teamDAO.getTeam(rs.getInt(2)));
				}
				else if (matchRoundResult.getLoser() == null && matchRoundResult.getWinner().getTeamId() != rs.getInt(2)) {
					matchRoundResult.setLoser(teamDAO.getTeam(rs.getInt(2)));
				}	
			}

		} catch (Exception e) {
			// TODO: handle exception
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

//	@Override
//	public List<MatchRoundResult> getMatchRoundResultsFromMatch(int matchId) throws SQLException {
//		List<MatchRoundResult> listOfMatchRoundResults = new ArrayList<>();
//
//		String sqlQuery = "SELECT matchRoundResultId FROM MatchRoundResult WHERE matchId = ? ";
//
//		try {
//			Connection connection = dbConnection.getConnection();
//			PreparedStatement statement = connection.prepareStatement(sqlQuery);
//
//			statement.setInt(1, matchId);
//
//			ResultSet rs = statement.executeQuery();
//
//			while (rs.next()) {
//				listOfMatchRoundResults.add(getMatchRoundResult(rs.getInt(1)));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return listOfMatchRoundResults;
//	}
	
	@Override
	public List<Team> getTeamsFromMatch(int matchId) throws SQLException{
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO(dbConnection);
		List<Team> listOfTeams = new LinkedList<>();
		
		
		String sqlQuery = "SELECT teamId FROM MatchRoundResult WHERE matchId = ? AND matchRoundResultId = ?";
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			int matchRoundResultId = getMatchRoundResultIds(matchId).iterator().next();
			
			statement.setInt(1, matchId);
			statement.setInt(2, matchRoundResultId);
			
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
	public int getNextMatchRoundResultId() throws SQLException {
		String sqlQuery = "SELECT matchRoundResultId FROM MatchRoundResult "
				+ "WHERE matchRoundResultId = (SELECT MAX(matchRoundResultId) FROM MatchRoundResult)";
		int nextMatchRoundResultId = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			nextMatchRoundResultId = rs.getInt(1);
			
		} catch (Exception e) {
		}
		
		return nextMatchRoundResultId + 1;
	}

	@Override
	public List<MatchRoundResult> getTotalListOfMatchRoundResults(int matchId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getTeamsFromMatchRoundResult(int matchRoundResultId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
