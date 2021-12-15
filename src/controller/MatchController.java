package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import dao.DAOFactory;
import dao.MatchDAOIF;
import model.Match;
import model.MatchRoundResult;
import model.Team;

public class MatchController implements MatchControllerIF {

	private MatchDAOIF matchDAO;
	private Match match;

	public MatchController(MatchDAOIF matchDAO) {
		this.matchDAO = matchDAO;
	}

	@Override
	public void createListOfMatches() {
		new ArrayList<Match>();
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
	public List<Match> getAllMatches(int bracketRoundId) {
		List<Match> listOfMatches = null;
		try {
			listOfMatches = matchDAO.getMatchesFromBracketRound(bracketRoundId);
		} catch (Exception e) {
		}

		return listOfMatches;
	}

	@Override
	public List<Match> generateMatches(int noOfRounds, List<Team> listOfTeams) {
		int matchesToCreate = listOfTeams.size() / 2;
		List<Match> listOfMatches = new ArrayList<>();
		MatchRoundResultControllerIF matchRoundResultController = new MatchRoundResultController(DAOFactory.createMatchRoundResultDAO());
		LinkedList<Team> listOfRandomTeams = (LinkedList<Team>) generateRandomListOfTeams(listOfTeams);

		for (int i = 0; i < matchesToCreate; i++) {
			List<MatchRoundResult> listOfMatchRoundResults = matchRoundResultController
					.generateMatchRoundResults(noOfRounds);
			List<Team> listOfTeamsInMatch = new ArrayList<>();
			listOfTeamsInMatch.add(listOfRandomTeams.poll());
			listOfTeamsInMatch.add(listOfRandomTeams.poll());
			listOfMatches.add(new Match(listOfMatchRoundResults, listOfTeamsInMatch));

		}
		return listOfMatches;
	}

	private List<Team> generateRandomListOfTeams(List<Team> listOfTeams) {
		List<Team> randomList = new LinkedList<>();
		Random ran = new Random();

		while (!listOfTeams.isEmpty()) {
			int randomIndex = ran.nextInt(listOfTeams.size());
			randomList.add(listOfTeams.get(randomIndex));
			listOfTeams.remove(randomIndex);
		}
		return randomList;
	}

}
