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


public class MatchDAO implements MatchDAOIF{
	private DbConnectionIF dbConnection;

	
	public MatchDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	@Override
	public void setMatchRoundResult(int matchRoundResultId ,Team winningTeam) throws SQLException {
		MatchRoundResultDAOIF matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO(dbConnection);
		matchRoundResultDAO.setWinner(matchRoundResultId, winningTeam);
		
	}
	
	public void setIsDraw() {
		
	}
	
	@Override
	public List<Match> getMatchesFromBracketRound(int bracketRoundId) throws SQLException{
		List<Match> listOfMatches = new ArrayList<>();
		String sqlQuery = "SELECT matchId FROM Match WHERE bracketRoundId = ?";
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, bracketRoundId);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
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
				+ "JOIN Team ON MatchRoundResult.teamId = Team.teamId "
				+ "WHERE Match.matchId = ?";
	
		
		Match match = null;
		List<MatchRoundResult> matchRoundResults = new LinkedList<>();
		List<Team> listOfTeams = new LinkedList<>();
		
		
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, matchId);
			
			ResultSet rs = statement.executeQuery();
			
			
			
			while (rs.next()) {
				matchRoundResults.add(matchRoundResultDAO.getRoundResult(rs.getInt(2)));
				
				Team team = teamDAO.getTeam(rs.getInt(3));
				if(listOfTeams.isEmpty() || listOfTeams.contains(team)) {
					listOfTeams.add(team);
				}
				
			}
			match = new Match(matchId, matchRoundResults, listOfTeams);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return match;
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

}
