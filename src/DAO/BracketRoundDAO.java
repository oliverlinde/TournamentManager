package DAO;

import java.util.List;

import model.BracketRound;
import model.BracketRoundResult;
import model.Team;

public class BracketRoundDAO implements BracketRoundDAOIF {
	private DbConnectionIF dbConnection;
	
	public BracketRoundDAO() {
		
	}
	
	public void setBracektRoundResult(List<Team> listOfWinners, List<Team> listOfLosers) {
		
	}
	
	public BracketRoundResult getBracketRoundResult() {
		return null;
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

}
