package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.DAOFactory;
import dao.DbConnection;
import dao.MatchRoundResultDAOIF;
import model.MatchRoundResult;
import model.Team;

public class MatchRoundResultController implements MatchRoundResultControllerIF {
	
	private MatchRoundResult matchRoundResult;
	private MatchRoundResultDAOIF matchRoundResultDAO;
	private List<MatchRoundResult> matchRoundResults;
	private static int count = -1;
	
	public MatchRoundResultController() {
		this.matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO(new DbConnection());
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
	public List<MatchRoundResult> generateMatchRoundResults(int noOfRounds){
		List<MatchRoundResult> matchRoundResults = new LinkedList<MatchRoundResult>();
		int nextMatchRoundResultId = getNextMatchRoundResultId();
		int i = 0;
		while(i<noOfRounds){
			matchRoundResults.add(new MatchRoundResult(nextMatchRoundResultId+countMatchRoundId()));
			i++;
		}
		return matchRoundResults;
	}
	
	private int countMatchRoundId() {
		count++;
		return count;
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
