package controller;

import model.Bracket;
import model.BracketRound;

public interface BracketControllerIF {

	int getNextBracketId();

	Bracket generateBracket(BracketRound bracketRound);

}
