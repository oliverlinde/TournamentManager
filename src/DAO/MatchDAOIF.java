package DAO;

public interface MatchDAOIF {
	void setRoundResult(Team winningTeam);
	
	void setDraw();
	
	Match getMatch(int matchId);
	
	private void createRoundResult();

}
