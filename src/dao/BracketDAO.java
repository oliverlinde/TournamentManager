package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

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
	
	public void createBracketRound(List<Team> listOfTeams) throws SQLException {
		dbConnection.getConnection();
	}

	@Override
	public List<BracketRound> getBracketRounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
