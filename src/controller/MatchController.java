package controller;

import java.util.List;

public class MatchController implements MatchControllerIF {
	
	private MatchRoundResultControllerIF matchRoundResultController;
	private MatchDAOIF matchDAO;
	private Match match;
	
	public MatchController(List<Team> listOfTeams) {
		this.match = new Match();
	}
	
	@Override
	public void setRoundResult(Team winningTeam) {
		match.setRoundResult(winningTeam);
	}

	@Override
	public void setDraw() {
		match.setDraw();
	}

	@Override
	public Match getMatch(int matchId) {
		matchDAO.getMatch(matchId);
	}

}
