/*
 * Returns the result of a match/round to the specific team,
 * which will add the points won to the specific team. 
 */

package model;

public class MatchRoundResult {
	private Team winner;
	private Team loser;
	private Boolean draw = false;
	
	public MatchRoundResult() {
		
	}
	
	public MatchRoundResult(Team winner, Team loser) {
		this.winner = winner;
		this.loser = loser;
	}
	
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
	public void setLoser(Team loser) {
		this.loser = loser;
	}
	
	public void setDraw() {
		draw = true;
	}
	
	public Team getWinner() {
		return winner;
	}
	
	public Team getLoser() {
		return loser;
	}
	
	public Boolean getIsDraw() {
		return draw;
	}

}
