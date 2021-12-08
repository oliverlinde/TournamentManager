package controller;

import java.util.ArrayList;
import java.util.List;

import dao.MatchDAOIF;
import model.Match;
import model.Team;

public class MatchController implements MatchControllerIF {
	
	private MatchRoundResultControllerIF matchRoundResultController;
	private MatchDAOIF matchDAO;
	private Match match;
	private List<Match> matches;
	
	public MatchController(List<Team> listOfTeams) {
		this.match = new Match(listOfTeams);
	}
	
	public MatchController() {
		matches = new ArrayList<Match>();
	}
	
	@Override
	public void createMatch(List<Team> listOfTeams) {
		this.match = new Match(listOfTeams);
		matches.add(match);
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
		return match;
	}

	@Override
	public void createRoundResult() {
		// TODO Auto-generated method stub
		
	}

}
