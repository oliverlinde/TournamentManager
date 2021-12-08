package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.BracketRoundResult;
import model.Team;

public class BracketRoundResultDAO implements BracketRoundResultDAOIF {
	private DbConnectionIF dbConnection;
	
	public BracketRoundResultDAO() {
		
	}
	
	public void addPointsToTeam(Team team, int points) {
		
	}

	public void setBracektRoundResult(List<Team> listOfWinners, List<Team> listOfLosers) {

	}

	public BracketRoundResult getBracketRoundResult(int bracketRoundId) {
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO(dbConnection);
		String sqlQuery = "SELECT teamId, points FROM TeamInBracketRound "
				+ "WHERE bracketRoundId = ? ";

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
