package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Format;
import model.NoOfRounds;
import model.TournamentRule;

public class TournamentRuleDAO implements TournamentRuleDAOIF {

	private DbConnectionIF dbConnnection;

	public TournamentRuleDAO(DbConnectionIF dbConnection) {
		this.dbConnnection = dbConnection;

	}
	
	@Override
	public TournamentRule getTournamentRule(int tournamentRuleId) throws SQLException {
		TournamentRule tournamentRule = null;
		
		String sqlQuery = "SELECT * FROM TournamentRule WHERE tournamentRuleId = ?";
		
		try {
			Connection connection = dbConnnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			statement.setInt(1, tournamentRuleId);
			
			ResultSet rs = statement.executeQuery();
			
			rs.next();
			
			tournamentRule = new TournamentRule(tournamentRuleId, rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), getNoOfRounds(rs), getFormat(rs));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tournamentRule;
	}

	@Override
	public List<TournamentRule> getAllTournamentRules() throws SQLException {
		List<TournamentRule> listOfRules = new LinkedList<>();
		String sqlQuery = "SELECT * FROM TournamentRule";
		
		try {
			Connection connection = dbConnnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {

				listOfRules.add(new TournamentRule(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), getNoOfRounds(rs), getFormat(rs)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listOfRules;
	}
	
	private NoOfRounds getNoOfRounds(ResultSet rs) throws SQLException {
		NoOfRounds noOfRounds = null;
		
		switch (rs.getInt(6)) {
		case 3:
			noOfRounds = NoOfRounds.BestOfThree;
			break;
		case 5: 
			noOfRounds = NoOfRounds.BestOfFive;
			break;
		default:
			noOfRounds = NoOfRounds.BestOfOne;
			break;
		}
		return noOfRounds;
	}
	
	private Format getFormat(ResultSet rs) throws SQLException {
		Format format = null;

		switch (rs.getString(7)) {
		case "DoubleElimination": 
			format = Format.DoubleElimination;
			break;
		case "PointsSystem": 
			format = Format.PointsSystem;
			break;
		default:
			format = Format.SingleElimination;
			break;
		}
		return format;
	}

}
