package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import dao.DAOFactory;
import dao.DbConnection;
import dao.MatchDAOIF;
import model.Match;
import model.MatchRoundResult;
import model.Team;

public class MatchController implements MatchControllerIF {

	private MatchRoundResultControllerIF matchRoundResultController;
	private MatchDAOIF matchDAO;
	private Match match;
	private List<Match> matches;

	public MatchController() {
		matchDAO = DAOFactory.createMatchDAO(new DbConnection());
	}

	@Override
	public void createListOfMatches() {
		matches = new ArrayList<Match>();
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
		try {
			matchDAO.createMatch(bracketRoundId, match);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Match> getAllMatches(int bracketRoundId) {
		List<Match> listOfMatches = null;
		try {
			listOfMatches = matchDAO.getMatchesFromBracketRound(bracketRoundId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listOfMatches;
	}

	@Override
	public int getNextMatchId() {
		int nextMatchId = 0;
		try {
			nextMatchId = matchDAO.getNextMatchId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextMatchId;
	}

	@Override
	public List<Match> generateMatches(int noOfRounds, List<Team> listOfTeams) {
		List<Match> listOfMatches = new ArrayList<>();
		MatchRoundResultControllerIF matchRoundResultController = new MatchRoundResultController();
		LinkedList<Team> listOfRandomTeams = (LinkedList<Team>) generateRandomListOfTeams(listOfTeams);
		
		for(int i = 0 ; i <= listOfRandomTeams.size() ; i++){
			List<MatchRoundResult> listOfMatchRoundResults = matchRoundResultController.generateMatchRoundResults(noOfRounds);
			List<Team> listOfTeamsInMatch = new ArrayList<>();
			listOfTeamsInMatch.add(listOfRandomTeams.poll());
			listOfTeamsInMatch.add(listOfRandomTeams.poll());
			listOfMatches.add(new Match(getNextMatchId()+i, listOfMatchRoundResults, listOfTeamsInMatch));

		}
		
		return listOfMatches;
		
//		match.setMatchRoundResults(matchRoundResultController.addRoundResult(noOfRounds));
//		matches.add(match);
//		saveMatchToDatabase(bracketRoundId, match);

	}
	
	private List<Team> generateRandomListOfTeams(List<Team> listOfTeams){
		List<Team> randomList = new LinkedList<>();
		Random ran = new Random();
		
		while(!listOfTeams.isEmpty()) {
			int randomIndex = ran.nextInt(listOfTeams.size());
			randomList.add(listOfTeams.get(randomIndex));
			listOfTeams.remove(randomIndex);
		}
		return randomList;
	}

	@Override
	public List<Match> getAllMatches() {
		// TODO Auto-generated method stub
		return null;
	}



}
