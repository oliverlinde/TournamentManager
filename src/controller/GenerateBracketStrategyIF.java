package controller;

import java.util.ArrayList;

import model.Bracket;
import model.Team;
import model.Tournament;

public interface GenerateBracketStrategyIF {

	void proceedToNextRound(ArrayList<Team> linkedList, MatchControllerIF matchController, int noOfRounds,
			int bracketRoundId);

	int calculatePoints();

	Bracket initializeTournament(Tournament tournament);
}
