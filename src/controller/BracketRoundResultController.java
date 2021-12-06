package controller;

import dao.BracketRoundResultDAOIF;
import model.BracketRoundResult;
import model.Team;

public class BracketRoundResultController implements BracketRoundResultControllerIF {
	
	private BracketRoundResultDAOIF bracketRoundResultDAO;
	private BracketRoundResult bracketRoundResult;
	
	public BracketRoundResultController() {
		
	}
	
	@Override
	public void addPointsToTeam(Team team, int points) {
		// TODO Auto-generated method stub
		
	}

}
