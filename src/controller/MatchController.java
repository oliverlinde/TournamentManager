package controller;

import java.util.List;

public class MatchController implements MatchControllerIF {
	
	private MatchRoundResultControllerIF matchRoundResultController;
	private MatchDAOIF matchDAO;
	private Match match;
	
	public MatchController(List<Team> listOfTeams) {
		
	}
	
	@Override
	public void setRoundResult(Team winningTeam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Match getMatch(int matchId) {
		// TODO Auto-generated method stub
		return null;
	}

}
