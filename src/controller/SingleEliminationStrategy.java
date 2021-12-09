package controller;

import java.util.ArrayList;
import java.util.List;

import model.Format;
import model.Team;

public class SingleEliminationStrategy implements GenerateBracketStrategyIF {

	MatchControllerIF matchController;
	
	@Override
	public void proceedToNextRound(ArrayList<Team> listOfTeams, MatchControllerIF matchController, int noOfRounds) {
		this.matchController = matchController;
		for(int i = 1 ; i <= Math.floor((listOfTeams.size()/2)) ; i++){
			ArrayList<Team> temp = subArray(listOfTeams, ((i*2)-2), (i*2)-1);
			matchController.createMatch(temp, noOfRounds);
		}
	}

	@Override
	public int calculatePoints() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private ArrayList<Team> subArray(ArrayList<Team> teams, int start, int end){
		ArrayList<Team> toReturn = new ArrayList<>();
		for(int i = start ; i <= end ; i++) {
			toReturn.add(teams.get(i));
		}
		return toReturn;
	}

}
