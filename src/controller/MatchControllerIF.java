package controller;

public interface MatchControllerIF {

	public void setRoundResult(Team winningTeam);
	public void setDraw();
	public Match getMatch(int matchId);
	private void createRoundResult();
	
}
