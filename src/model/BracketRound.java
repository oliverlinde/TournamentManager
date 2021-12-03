/*
 * Includes a list of matches in a bracket. 
 */

package model;

import java.util.List;

public class BracketRound {
	private List<Match> listOfMatches;
	private BracketRoundResult bracketRoundResult;
	private List<Team> listOfTeams;
	
	public void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers) {
		
	}
	
	public BracketRoundResult getBracketRoundResult() {
		return bracketRoundResult;
	}
	
	/*
	 * A method for creating in instance of a match. 
	 * Should be private, not meant to be accessible other than
	 * from the system itself. 
	 * 
	 * Not implemented. 
	 */
	public void createMatches(List<Team> listOfTeams) {
		
	}
	
	public List<Team> getListOfTeams() {
		return listOfTeams;
	}

}
