package controller;

import java.util.List;

import model.Bracket;
import model.BracketRound;
import model.Match;
import model.Team;

public interface BracketControllerIF {

	public List<Team> getTeams();
	public void givePointsToTeam(Team team, int pointsToWin);
	public List<BracketRound> getBracketRound();
	public List<Match> getAllMatches();
	int getNextBracketId();
	Bracket generateBracket(BracketRound bracketRound);
}
