/*
 * Includes a list of bracket rounds. 
 */

package model;

import java.util.List;

public class Bracket {
	
	private List<BracketRound> listOfBracketRounds;
	
	public Bracket(List<Team> teams) {
		
	}
	
	public List<Team> getTeams(BracketRound bracketRound) {
		return bracketRound.getListOfTeams();
	}
	
	public void givePointsToTeam(Team team, int pointsToWin) {
		
	}
	
	/*
	 * Returns a list of the rounds currently implemented in the current
	 * bracket round. 
	 * 
	 * Not implemented. 
	 */
	public List<BracketRound> getBracketRounds() {
		return listOfBracketRounds;
	}
	
	/*
	 * Creates the current round in the bracket. 
	 * 
	 * Not implemented. 
	 */
	public void createBracketRound(List<Team> listOfTeams) {
		
	}

}
