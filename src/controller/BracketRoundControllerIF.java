package controller;

import java.util.List;

import model.BracketRound;
import model.BracketRoundResult;
import model.Match;
import model.Team;

public interface BracketRoundControllerIF {
	
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers);
	public BracketRoundResult getBracketRoundResult();
	public List<Match> getAllMatches();
	public void saveBracketRoundToDatabase(int bracketId, BracketRound bracketRound);
	BracketRound generateBracketRound(List<Match> listOfMatches);
}
