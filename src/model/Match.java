/*
 * Creates a list of rounds, called a match. 
 * 
 * Receives the results through the MatchRoundResult class. 
 */

package model;

import java.util.LinkedList;
import java.util.List;

public class Match {
	private List<MatchRoundResult> listOfMatchRounds;
	private List<Team> listOfTeams;

	public Match(List<Team> listOfTeams) {
		listOfMatchRounds = new LinkedList<>();
		this.listOfTeams = listOfTeams;
	}

	public Match(List<MatchRoundResult> listOfMatchRounds, List<Team> listOfTeams) {
		this.listOfMatchRounds = listOfMatchRounds;
		this.listOfTeams = listOfTeams;
	}

	public void setMatchRoundResult(Team winningTeam) {

	}

	public void setDraw() {

	}

	public Team getWinner() {
		return sortByWinner().get(0);
	}

	public Team getLoser() {
		return sortByWinner().get(1);
	}

	public Boolean getIsDraw(MatchRoundResult matchRoundResult) {
		return matchRoundResult.getIsDraw();
	}

	public void createRoundResult() {

	}

	private List<Team> sortByWinner() {
		int team1 = 0;
		int team2 = 0;

		LinkedList<Team> teams = (LinkedList<Team>) listOfTeams;
		List<Team> sortedByWinnerList = new LinkedList<>();

		for (MatchRoundResult matchResult : listOfMatchRounds) {
			if (matchResult.getWinner().equals(teams.getFirst())) {
				team1++;
			} else {
				team2++;
			}
		}

		if (team1 > team2) {
			sortedByWinnerList.add(teams.pollFirst());
		} else {
			sortedByWinnerList.add(teams.pollLast());
		}
		sortedByWinnerList.add(teams.poll());

		return sortedByWinnerList;
	}

}
