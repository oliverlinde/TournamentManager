package dao;

import model.MatchRoundResult;
import model.Team;

public class MatchRoundResultDAO implements MatchRoundResultDAOIF {
	private DbConnectionIF dbConnection;
	
	public MatchRoundResultDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public void setWinner(Team team) {
		
	}
	
	public void setLoser(Team team) {
		
	}
	
	public void setDraw() {
		
	}
	
	public MatchRoundResult getRoundResult(int matchRoundResultId) {
		return null;
	}

}
