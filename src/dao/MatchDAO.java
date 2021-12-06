package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Match;
import model.Team;

public class MatchDAO implements MatchDAOIF{
	private DbConnectionIF dbConnection;
	
	public MatchDAO() {
		
	}
	
	public void setMatchRoundResult(Team winningTeam) {
		
	}
	
	public void setIsDraw() {
		
	}
	
	public Match getMatch(int matchId) {
		String sqlQuery = "SELECT matchId, matchRoundResultId, teamId, teamName FROM Match "
				+ "JOIN MatchRoundResult ON Match.matchRoundResultId = MatchRoundResult.matchRoundResultId "
				+ "JOIN Team ON MatchRoundResult.teamId = Team.teamId "
				+ "WHERE matchId = ?"
				;
		
		Match foundMatch = null;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, matchId);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Team team = new Team(rs.getInt(3), rs.getString(4));
				foundMatch = new Match(null, null);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
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
