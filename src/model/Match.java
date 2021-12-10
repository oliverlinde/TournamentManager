/*
 * Creates a list of rounds, called a match. 
 * 
 * Receives the results through the MatchRoundResult class. 
 */

package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Match {
	private int matchId;
	private List<MatchRoundResult> listOfMatchRounds;
	private List<Team> listOfTeams;
	
	public Match(List<Team> listOfTeams, int matchId) {
		this.listOfTeams = listOfTeams;
		setMatchId(matchId);
		this.listOfMatchRounds = new ArrayList<MatchRoundResult>();
	}

	public Match(int matchId, List<MatchRoundResult> listOfMatchRounds, List<Team> listOfTeams) {
		setMatchId(matchId);
		setListOfMatchRounds(listOfMatchRounds);
		setListOfTeams(listOfTeams);	
	}
	
	public void setMatchRoundResult(Team winningTeam) {
		
	}
	
	public List<MatchRoundResult> getListOfMatchRounds() {
		return listOfMatchRounds;
	}
	
	public void setListOfMatchRounds(List<MatchRoundResult> listOfMatchRounds) {
		this.listOfMatchRounds = listOfMatchRounds;
	}
	
	public void setDraw() {
		
	}
	
	public Team getWinner() {
		return sortByWinner().get(0);
	}

	public Team getLoser() {
		return sortByWinner().get(1);
	}
	
	
	private List<Team> sortByWinner() {
		int team1Wins = 0;
		int team2Wins = 0;

		LinkedList<Team> listOfTeamsToSortableList = (LinkedList<Team>) listOfTeams;
		List<Team> sortedByWinnerList = new LinkedList<>();

		for (MatchRoundResult matchResult : listOfMatchRounds) {
			if (matchResult.getWinner().getTeamId() == (listOfTeamsToSortableList.get(0).getTeamId())) {
				team1Wins++;
			} else {
				team2Wins++;
			}
		}

		if (team1Wins > team2Wins) {
			sortedByWinnerList.add(listOfTeamsToSortableList.pollFirst());
		} else if (team2Wins > team1Wins){
			sortedByWinnerList.add(listOfTeamsToSortableList.pollLast());
		}
		sortedByWinnerList.add(listOfTeamsToSortableList.poll());

		return sortedByWinnerList;
	}
	
	public Boolean getIsDraw(MatchRoundResult matchRoundResult) {
		return matchRoundResult.getIsDraw();
	}
	

	public void addRoundResult(MatchRoundResult matchRoundResult) {
		listOfMatchRounds.add(matchRoundResult);
	}

	public void createRoundResult(MatchRoundResult matchRoundResult) {
		listOfMatchRounds.add(matchRoundResult);

	}

	public List<Team> getListOfTeams() {
		return listOfTeams;
	}

	public void setListOfTeams(List<Team> listOfTeams) {
		this.listOfTeams = listOfTeams;
	}
	
	public void setMatchRoundResults(List<MatchRoundResult> matchRoundResults) {
		this.listOfMatchRounds = matchRoundResults;
	}
	
	public List<MatchRoundResult> getRoundResults(){
		return listOfMatchRounds;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
}
