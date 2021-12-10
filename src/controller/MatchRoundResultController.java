package controller;

import java.sql.SQLException;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import dao.MatchRoundResultDAOIF;
import model.MatchRoundResult;
import model.Team;

public class MatchRoundResultController implements MatchRoundResultControllerIF {
	
	private MatchRoundResult matchRoundResult;
	private MatchRoundResultDAOIF matchRoundResultDAO;
	
	public MatchRoundResultController() {
		//this.matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO();
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
	public MatchRoundResult getMatchRoundResult(int matchId) {
		MatchRoundResult matchRoundResult = null;
		matchRoundResult = null;
//		try {
//			matchRoundResult = matchRoundResultDAO.get(matchId);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return matchRoundResult;
	}
	
	@Override
	public List<MatchRoundResult> getListOfMatchRoundResults(int matchId){
		List<MatchRoundResult> listMatchRoundResults = null;
		try {
			listMatchRoundResults = matchRoundResultDAO.getMatchRoundResultsFromMatch(matchId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listMatchRoundResults;
	}
	
	
	public List<MatchRoundResult> getAllRoundResults(int matchId) {
		
		List<MatchRoundResult> allRoundResults = null;
		
		try {
			allRoundResults = matchRoundResultDAO.getTotalListOfMatchRoundResults(matchId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allRoundResults;
	}



	
}
