package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.BracketRound;
import model.BracketRoundResult;
import model.Match;
import model.Team;

public interface BracketRoundControllerIF {
	
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers);
	public BracketRoundResult getBracketRoundResult();
	public void createMatches(GenerateBracketStrategyIF generateBracketStrategy, int noOfRounds);
	public List<Match> getAllMatches();
	public void saveBracketRoundToDatabase(int bracketId, BracketRound bracketRound);
	BracketRound createBracketRound(List<Team> listOfTeams);
}
