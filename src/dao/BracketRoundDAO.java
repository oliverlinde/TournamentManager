package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BracketRound;

public class BracketRoundDAO implements BracketRoundDAOIF {
	private DbConnectionIF dbConnection;

	public BracketRoundDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public int createBracketRound(int bracketId, BracketRound bracketRound) throws SQLException{
		String sqlQuery = "INSERT INTO BracketRound (bracketRoundId, bracketId)"
				+ " VALUES (?, ?)";
		
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);
		int bracketRoundCreated = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, bracketRound.getBracketRoundID());
			statement.setInt(2, bracketId);
			
			statement.execute();
			
			connection.commit();
			System.out.println("BracketRound created");

			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new SQLException("BracketRound not created " + bracketRound.getBracketRoundID());
		} finally {
			connection.setAutoCommit(true);
		}
		return bracketRoundCreated;
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
			e.printStackTrace();
		}
		
		
		return listOfBracketRounds;
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

}
