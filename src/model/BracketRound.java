/*
 * Includes a list of matches in a bracket. 
 */

package model;

import java.util.List;

public class BracketRound {
	private int bracketRoundId;
	private List<Match> listOfMatches;
	
	/*
	 * Creating an empty BracketRound
	 */
	public BracketRound(List<Match> listOfMatch) {
		setMatchesInBracketRound(listOfMatch);
	}
	
	public BracketRound(int bracketRoundId, List<Match> listOfMatches) {
		setBracketRoundID(bracketRoundId);
		setMatchesInBracketRound(listOfMatches);
	}
	
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers) {
		
	}
	
	/*
	 * A method for creating in instance of a match. 
	 * Should be private, not meant to be accessible other than
	 * from the system itself. 
	 * 
	 * Not implemented. 
	 */
	public void setMatchesInBracketRound(List<Match> matchesInBracketRound) {
		listOfMatches = matchesInBracketRound;
	}
	
	public List<Match> getMatches(){
		return listOfMatches;
	}

	public int getBracketRoundID() {
		return bracketRoundId;
	}

	public void setBracketRoundID(int bracketRoundID) {
		this.bracketRoundId = bracketRoundID;
	}

}
