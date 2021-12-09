package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.BracketRound;
import model.BracketRoundResult;
import model.Team;
import model.MatchRoundResult;

public class BracketRoundDAO implements BracketRoundDAOIF {
	private DbConnectionIF dbConnection;

	public BracketRoundDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public int createBracketRound(int bracketId, BracketRound bracketRound) throws SQLException{
		String sqlQuery = "INSERT INTO BracketRound (bracketRoundId, bracketId) WHERE bracketId = ? VALUES ?, ? ";
		
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
	public BracketRound getBracketRound() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public BracketRoundResult getBracketRoundResult() { // TODO
	 * Auto-generated method stub return null; }
	 */

}
