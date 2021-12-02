package controller;

import java.util.List;

public class BracketController implements BracketControllerIF {
	private BracketRoundControllerIF bracketRoundController;
	private BracketDAOIF bracketDAO;
	private Bracket bracket;

	public BracketController(Datacontext dbConnection) {
		this.bracketDAO = DAOFactory.createBracketDAO(dbConnection); 
	}
	
	@Override
	public List<Team> getTeams() {
		return bracketDAO.getTeams();
	}

	@Override
	public void givePointsToTeam(Team team, int pointsToWin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BracketRound> getBracketRound() {
		return bracketDAO.getBracketRound();
	}

	@Override
	public void createBracketRound(List<Team> listOfTeams) {
		bracketDAO.createBracketRound(listOfTeams);
	}

}
