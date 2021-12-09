/*
 * Includes a list of bracket rounds. 
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class Bracket {
	
	private List<BracketRound> listOfBracketRounds;
	private int bracketId;

	public Bracket(List<Team> teams) {
		listOfBracketRounds = new ArrayList<BracketRound>();
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
	public void addBracketRound(BracketRound bracketRound) {
		listOfBracketRounds.add(bracketRound);
	}
	
	public int getBracketId() {
		return bracketId;
	}

	public void setBracketId(int bracketId) {
		this.bracketId = bracketId;
	}

}
