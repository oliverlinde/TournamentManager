/*
 * Returns the result of a match/round to the specific team,
 * which will add the points won to the specific team. 
 */

package model;

public class MatchRoundResult {
	private int matchRoundResultId;
	private Team winner;
	private Team loser;
	private Boolean draw = false;
	
	
	public MatchRoundResult(int id) {
		setMatchRoundResultId(id);

	}
	
	public MatchRoundResult(int matchRoundResultId, Team winner, Team loser, boolean draw) {
		/*
		 * Earlier implementation - not currently used nor implemented in DAO layer. 
		 */
		//this.winner = winner;
		//this.loser = loser;
		setMatchRoundResultId(matchRoundResultId);
		setWinner(winner);
		setLoser(loser);
		setDraw(draw);
	}
	
	
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
	public void setLoser(Team loser) {
		this.loser = loser;
	}
	
	public void setDraw(boolean draw) {
		this.draw = draw;
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

	public int getMatchRoundResultId() {
		return matchRoundResultId;
	}

	public void setMatchRoundResultId(int matchRoundResultId) {
		this.matchRoundResultId = matchRoundResultId;
	}

}
