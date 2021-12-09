package controller;

import java.util.List;

import model.BracketRound;
import model.BracketRoundResult;
import model.Match;
import model.Team;

public interface BracketRoundControllerIF {
	
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers);
	public BracketRoundResult getBracketRoundResult();
	public BracketRound createMatches(List<Team> listOfTeams, GenerateBracketStrategyIF generateBracketStrategy, int noOfRounds);
	public List<Match> getAllMatches();
	public void createBracketRound(int bracketId, BracketRound bracketRound);
}
