package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import dao.MatchRoundResultDAOIF;
import model.MatchRoundResult;
import model.Team;

public class MatchRoundResultController implements MatchRoundResultControllerIF {
	
	private MatchRoundResult matchRoundResult;
	private MatchRoundResultDAOIF matchRoundResultDAO;
	private List<MatchRoundResult> matchRoundResults;
	
	public MatchRoundResultController(DbConnectionIF dbConnection) {
		this.matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO(dbConnection);
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



	
	@Override
	public MatchRoundResult createMatchRoundResult() {
		return this.matchRoundResult = new MatchRoundResult(getNextMatchRoundResultId());
		//matchRoundResults.add(matchRoundResult);
	}
	
	@Override
	public List<MatchRoundResult> addRoundResult(int noOfRounds){
		List<MatchRoundResult> matchRoundResults = new LinkedList<MatchRoundResult>();
		int i = 0;
		int nextMatchRoundResultId = getNextMatchRoundResultId();
		while(i<noOfRounds){
			matchRoundResults.add(new MatchRoundResult(nextMatchRoundResultId+i));
			i++;
		}
		return matchRoundResults;
	}
	
	@Override
	public int getNextMatchRoundResultId() {
		int nextId = 0;
		try {
			nextId = matchRoundResultDAO.getNextMatchRoundResultId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextId;
	}
	
	
	public void saveMatchRoundResultToDatabase(int matchId, MatchRoundResult matchRoundResult) {
		
	}
	
	@Override
	public ArrayList<MatchRoundResult> getMatchRoundResultList(){
		return (ArrayList<MatchRoundResult>) matchRoundResults;
	}

	@Override
	public void createMatchRoundResultList() {
		matchRoundResults = new ArrayList<MatchRoundResult>();
	}
	
}
