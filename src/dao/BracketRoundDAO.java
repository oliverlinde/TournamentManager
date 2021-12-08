package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public void createMatches(List<Team> listOfTeams) {

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

	@Override
	public BracketRoundResult getBracketRoundResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
