package controller;

import java.util.List;

import model.BracketRoundResult;
import model.Team;

public interface BracketRoundControllerIF {
	
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers);
	public BracketRoundResult getBracketRoundResult();
	public void createMatches(List<Team> listOfTeams, GenerateBracketStrategyIF generateBracketStrategy);
}
