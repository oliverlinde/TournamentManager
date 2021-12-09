/*
 * Creates a list of rounds, called a match. 
 * 
 * Receives the results through the MatchRoundResult class. 
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class Match {
	private int matchId;
	private List<MatchRoundResult> rounds;
	private List<Team> listOfTeams;
	
	public Match(List<Team> listOfTeams) {
		this.listOfTeams = listOfTeams;
		this.rounds = new ArrayList<MatchRoundResult>();
	}
	
	public Match(List<MatchRoundResult> rounds, List<Team> listOfTeams) {
		
	}
	
	public void setMatchRoundResult(Team winningTeam) {
		
	}
	
	
	public void setDraw() {
		
	}
	
	public Team getWinner(MatchRoundResult matchRoundResult) {
		return matchRoundResult.getWinner();
	}
	
	public Team getLoser(MatchRoundResult matchRoundResult) {
		return matchRoundResult.getLoser();
	}
	
	public Boolean getIsDraw(MatchRoundResult matchRoundResult) {
		return matchRoundResult.getIsDraw();
	}
	
	public void createRoundResult(MatchRoundResult matchRoundResult) {
		rounds.add(matchRoundResult);
	}

	public List<Team> getListOfTeams() {
		return listOfTeams;
	}

	public void setListOfTeams(List<Team> listOfTeams) {
		this.listOfTeams = listOfTeams;
	}
	
	public List<MatchRoundResult> getRoundResults(){
		return rounds;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	
	

}
