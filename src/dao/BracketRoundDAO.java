package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BracketRound;
import model.Team;

public class BracketRoundDAO implements BracketRoundDAOIF {
	private DbConnectionIF dbConnection;

	public BracketRoundDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public int createBracketRound(int bracketId, BracketRound bracketRound) throws SQLException{
		String sqlQuery = "INSERT INTO BracketRound (bracketRoundId, bracketId)"
				+ " VALUES (?, ?)";
		
		int bracketRoundCreated = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, bracketRound.getBracketRoundID());
			statement.setInt(2, bracketId);
			
			bracketRoundCreated = statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bracketRoundCreated;
	}

	@Override
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BracketRound> getBracketRoundsFromBracket(int bracketId) throws SQLException {
		MatchDAOIF matchDAO = DAOFactory.createMatchDAO();
		List<BracketRound> listOfBracketRounds = new ArrayList<>();
		String sqlQuery = "SELECT bracketRoundId FROM BracketRound WHERE bracketId = ? ";
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, bracketId);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				listOfBracketRounds.add(new BracketRound(rs.getInt(1), matchDAO.getMatchesFromBracketRound(rs.getInt(1))));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return listOfBracketRounds;
	}

	@Override
	public BracketRound getBracketRound(int bracketRoundId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BracketRound> getBracketRounds(int bracketId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getNextBracketRoundId() throws SQLException {
		String sqlQuery = "SELECT bracketRoundId FROM BracketRound "
				+ "WHERE bracketRoundId = (SELECT MAX(bracketRoundId) FROM BracketRound)";
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

	/*
	 * @Override public BracketRoundResult getBracketRoundResult() { // TODO
	 * Auto-generated method stub return null; }
	 */

}
