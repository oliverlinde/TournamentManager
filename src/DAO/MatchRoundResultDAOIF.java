package DAO;

import model.MatchRoundResult;
import model.Team;

public interface MatchRoundResultDAOIF {
	
	void setWinner(Team team);
	
	void setLoser(Team team);
	
	void setDraw();
	
	MatchRoundResult getRoundResult(int matchRoundResultId);

}
