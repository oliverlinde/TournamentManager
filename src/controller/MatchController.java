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
		matchRoundResultController = new MatchRoundResultController();
	}

	public MatchController() {
		matches = new ArrayList<Match>();
		matchRoundResultController = new MatchRoundResultController();
	}

	@Override
	public void createMatch(List<Team> listOfTeams, int noOfRounds) {
		this.match = new Match(listOfTeams);
		int i = 0;
		while (i < noOfRounds) {
			match.createRoundResult(matchRoundResultController.getMatchRoundResult());
			i++;
		}
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

	@Override
	public List<Match> getAllMatches() {
		return matches;
	}

}
