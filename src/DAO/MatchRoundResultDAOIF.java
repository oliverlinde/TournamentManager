package DAO;

public interface MatchRoundResultDAOIF {
	
	void setWinner(Team team);
	
	void setLoser(Team team);
	
	void setDraw();
	
	MatchRoundResult getRoundResult(int matchRoundResultId);

}
