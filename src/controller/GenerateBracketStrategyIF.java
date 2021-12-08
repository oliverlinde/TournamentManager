package controller;

import java.util.ArrayList;

import model.Team;

public interface GenerateBracketStrategyIF {

	public void proceedToNextRound(ArrayList<Team> listOfTeams);
	public int calculatePoints();
}
