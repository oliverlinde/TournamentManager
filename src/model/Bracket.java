/*
 * Includes a list of bracket rounds. 
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class Bracket {
	

	private int bracketId;
	private List<BracketRound> listOfBracketRounds;
	
	public Bracket(BracketRound bracketRound) {
		listOfBracketRounds = new ArrayList<BracketRound>();
		listOfBracketRounds.add(bracketRound);
	}
	
	public Bracket(int bracketId, List<BracketRound> listOfBracketRounds) {
		setBracketId(bracketId);
		setListOfBracketRounds(listOfBracketRounds);
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

	public List<BracketRound> getListOfBracketRounds() {
		return listOfBracketRounds;
	}

	public void setListOfBracketRounds(List<BracketRound> listOfBracketRounds) {
		this.listOfBracketRounds = listOfBracketRounds;
	}


	public void setBracketId(int bracketId) {
		this.bracketId = bracketId;
	}

	public int getBracketId() {
		return bracketId;
	}

}
