package controller;

import java.util.List;

import model.BracketRound;
import model.Match;

public interface BracketRoundControllerIF {

	public List<Match> getAllMatches();

	public void saveBracketRoundToDatabase(int bracketId, BracketRound bracketRound);

	BracketRound generateBracketRound(List<Match> listOfMatches);
}
