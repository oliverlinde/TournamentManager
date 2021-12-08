package controller;

import java.util.List;

import dao.MatchDAOIF;
import model.Match;
import model.Team;

public class MatchController implements MatchControllerIF {
	
	private MatchRoundResultControllerIF matchRoundResultController;
	private MatchDAOIF matchDAO;
	private Match match;
	
	public MatchController(List<Team> listOfTeams) {
		this.match = new Match(listOfTeams);
	}
	
	public MatchController() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void createMatch(List<Team> listOfTeams) {
		this.match = new Match(listOfTeams);
	}

	@Override
	public void setRoundResult(Team winningTeam) {
		match.setMatchRoundResult(winningTeam);
	}

	@Override
	public void setDraw() {
		match.setDraw();
	}

	@Override
	public Match getMatch(int matchId) {
		return matchDAO.getMatch(matchId);
	}

	@Override
	public void createRoundResult() {
		// TODO Auto-generated method stub
		
	}

}
