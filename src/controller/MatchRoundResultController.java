package controller;

import dao.DbConnectionIF;

import java.util.List;

import dao.DAOFactory;
import dao.MatchRoundResultDAOIF;
import model.MatchRoundResult;
import model.Team;

public class MatchRoundResultController implements MatchRoundResultControllerIF {
	
	private MatchRoundResult matchRoundResult;
	private MatchRoundResultDAOIF matchRoundResultDAO;
	
	public MatchRoundResultController(DbConnectionIF dbConnection) {
		this.matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO(dbConnection);
		matchRoundResult = new MatchRoundResult();
	}

	@Override
	public void setWinner(Team team) {
		matchRoundResult.setWinner(team);
	}

	@Override
	public void setLoser(Team team) {
		matchRoundResult.setLoser(team);
	}

	@Override
	public void setDraw() {
		matchRoundResult.setDraw(true);
	}

	@Override
	public MatchRoundResult getRoundResult(int matchRoundResultId) {
		return matchRoundResultDAO.getRoundResult(matchRoundResultId);
	}
	
	
	public List<MatchRoundResult> getAllRoundResults(int matchId) {
		return matchRoundResultDAO.getTotalListOfMatchRoundResults(matchId);
	}
	
}
