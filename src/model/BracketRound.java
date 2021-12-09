/*
 * Includes a list of matches in a bracket. 
 */

package model;

import java.util.LinkedList;
import java.util.List;

import dao.MatchRoundResultDAO;

public class BracketRound {
	private List<Match> listOfMatches;
	private int bracketRoundID;
	private BracketRoundResult bracketRoundResult;
	private List<Team> listOfTeams;
	private MatchRoundResultDAO matchRoundResultDAO;
	
	public BracketRound() {
		listOfMatches = new LinkedList<>();
		//bracketRoundResult = new BracketRoundResult();
		listOfTeams = new LinkedList<>();
		//matchRoundResultDAO = new MatchRoundResultDAO();
	}
	
	public void resetBracketRound() {
		this.listOfMatches = null;
		this.listOfTeams = null;
	}
	
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
	public void setMatchesInBracketRound(List<Match> matchesInBracketRound) {
		listOfMatches = matchesInBracketRound;
	}
	
	public List<Team> getListOfTeams() {
		return listOfTeams;
	}
	
	public List<Match> getMatches(){
		return listOfMatches;
	}

	public int getBracketRoundID() {
		return 1;
	}

	public void setBracketRoundID(int bracketRoundID) {
		this.bracketRoundID = bracketRoundID;
	}

}
