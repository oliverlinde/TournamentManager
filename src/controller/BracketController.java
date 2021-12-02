package controller;

import java.util.List;

public class BracketController implements BracketControllerIF {
	private BracketRoundControllerIF bracketRoundController;
	private BracketDAOIF bracketDAO;
	private Bracket bracket;

	public BracketController() {
		
	}
	
	@Override
	public List<Team> getTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void givePointsToTeam(Team team, int pointsToWin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BracketRound> getBracketRound() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBracketRound(List<Team> listOfTeams) {
		// TODO Auto-generated method stub
		
	}

}
