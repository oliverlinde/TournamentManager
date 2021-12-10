package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;
import dao.DbConnection;
import dao.DbConnectionIF;
import dao.MatchDAOIF;
import model.Match;
import model.MatchRoundResult;
import model.Team;

public class MatchController implements MatchControllerIF {

	private MatchRoundResultControllerIF matchRoundResultController;
	private MatchDAOIF matchDAO;
	private Match match;
	private List<Match> matches;

	public MatchController(DbConnectionIF dbConnection) {
		matchRoundResultController = new MatchRoundResultController(dbConnection);
		matchDAO = DAOFactory.createMatchDAO(dbConnection);
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
	public int getMatchId() {
		int nextMatchId = 0;
		try {
			nextMatchId = matchDAO.getNextMatchId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextMatchId;
	}

	@Override
	public void createMatch(List<Team> listOfTeams, int noOfRounds, int bracketRoundId) {
		this.match = new Match(listOfTeams, getMatchId());
		match.setMatchRoundResults(matchRoundResultController.addRoundResult(noOfRounds));
		matches.add(match);
		saveMatchToDatabase(bracketRoundId, match);

	}

	@Override
	public List<Match> getAllMatches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createMatch(List<Team> listOfTeams, int noOfRounds) {
		// TODO Auto-generated method stub
		
	}

}
