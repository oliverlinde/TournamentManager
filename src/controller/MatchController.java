package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;
import dao.DbConnection;
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
		matchDAO = DAOFactory.createMatchDAO(new DbConnection());
	}

	@Override
	public void createMatch(List<Team> listOfTeams, int noOfRounds, int bracketRoundId) {
		this.match = new Match(listOfTeams);
		int i = 0;
		while (i < noOfRounds) {
			match.createRoundResult(matchRoundResultController.getMatchRoundResult());
			i++;
		}
		matches.add(match);
		saveMatchToDatabase(getMatchId(), match);
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
	
	private void saveMatchToDatabase(int bracketRoundId, Match match) {
		matchDAO.createMatch(bracketRoundId, match);
	}

	@Override
	public List<Match> getAllMatches() {
		return matches;
	}
	
	@Override
	public int getMatchId() {
		int matchId = 0;
		matchId = matchDAO.getNextMatchId();
		return matchId;
	}

}
