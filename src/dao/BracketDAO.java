package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import model.Bracket;
import model.BracketRound;
import model.Team;

public class BracketDAO implements BracketDAOIF {
	private List<BracketRound> listOfBracketRounds;
	private DbConnectionIF dbConnection;

	public BracketDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}

	public List<Team> getTeams() {
		return null;
	}

	public void givePointsToTeam(Team team, int pointsToWin) {

	}
	
	@Override
	public List<Bracket> getBracketsFromTournament(int tournamentId) throws SQLException {
		BracketRoundDAOIF bracketRoundDAO = DAOFactory.createBracketRoundDAO(dbConnection);
		List<Bracket> listOFBrackets = new ArrayList<>();
		
		String sqlQuery = "SELECT bracketId FROM Bracket WHERE tournamentId = ?";
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, tournamentId);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				listOFBrackets.add(new Bracket(tournamentId, bracketRoundDAO.getBracketRoundsFromBracket(rs.getInt(1))));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listOFBrackets;
	}
	
	
	public List<BracketRound> getBracketRounds(int bracketId) throws SQLException {
		List<BracketRound> bracketRounds = new ArrayList<>();
		
		String sqlQuery = "SELECT bracketRoundId FROM BracketRound WHERE bracketId = ?";
		BracketRoundDAOIF bracketRoundDAO = DAOFactory.createBracketRoundDAO(dbConnection);
		
		try {
			
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, bracketId);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				bracketRounds.add(bracketRoundDAO.getBracketRound(rs.getInt(1)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

		return listOfBracketRounds;

	}


	// public void createBracketRound(List<Team> listOfTeams) throws
	// SQLServerException {
	// dbConnection.getConnection();
	// }

	@Override
	public int createBracket(int tournamentId, Bracket bracket) throws SQLException {
		String sqlQuery = "INSERT INTO Bracket (bracketId, tournamentId) "
				+ "VALUES (?, ?)";
		
		int bracketCreated = 0;
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, bracket.getBracketId());
			statement.setInt(2, tournamentId);
			
			statement.execute();
			
			connection.commit();
			System.out.println("Bracket created");

			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new SQLException("Bracket not created " + bracket.getBracketId());
		} finally {
			connection.setAutoCommit(true);
		}
		return bracketCreated;
	}

	@Override
	public int getNextBracketId() throws SQLException {
		String sqlQuery = "SELECT bracketId FROM Bracket "
				+ "WHERE bracketId = (SELECT MAX(bracketId) FROM Bracket)";
		int nextBracketId = 0;
		
		try {
			Connection connection = dbConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			nextBracketId = rs.getInt(1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return nextBracketId + 1;
	}
	
	
	public void createBracketRound(List<Team> listOfTeams) throws SQLException {
		dbConnection.getConnection();
	}

	@Override
	public List<BracketRound> getBracketRounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
