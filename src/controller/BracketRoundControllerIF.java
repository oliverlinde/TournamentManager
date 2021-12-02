package controller;

public interface BracketRoundControllerIF {
	
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers);
	public BracketRoundResult getBracketRoundResult();
	public void createMatches(List<Team> listOfTeams);
}
