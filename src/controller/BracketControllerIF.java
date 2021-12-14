package controller;

import java.util.List;

import model.Bracket;
import model.BracketRound;
import model.Team;

public interface BracketControllerIF {

	public List<BracketRound> getBracketRound();

	int getNextBracketId();

	Bracket generateBracket(BracketRound bracketRound);

	List<Team> getTeams();
}
