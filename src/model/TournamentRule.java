/*
 * Applies the desired rules for the current bracket round. 
 * This includes the number of rounds played in the match, as well as
 * the desired format being played in the tournament.
 */

package model;

public class TournamentRule {
	private String description;
	private int pointsPerWin;
	private int pointsPerDraw;
	private int pointsPerLoss;
	private NoOfRounds noOfRounds;
	private Format format;

	public TournamentRule(String description, int pointsPerWin, int pointsPerLoss, int pointsPerDraw, NoOfRounds noOfRounds,Format format) {
		this.description = description;
		this.pointsPerWin = pointsPerWin;
		this.pointsPerLoss = pointsPerLoss;
		this.pointsPerDraw = pointsPerDraw;
		this.noOfRounds = noOfRounds;
		this.format = format;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPointsPerWin() {
		return pointsPerWin;
	}

	public void setPointsPerWin(int pointsPerWin) {
		this.pointsPerWin = pointsPerWin;
	}

	public int getPointsPerDraw() {
		return pointsPerDraw;
	}

	public void setPointsPerDraw(int pointsPerDraw) {
		this.pointsPerDraw = pointsPerDraw;
	}

	public int getPointsPerLoss() {
		return pointsPerLoss;
	}

	public void setPointsPerLoss(int pointsPerLoss) {
		this.pointsPerLoss = pointsPerLoss;
	}

	/*
	 * Selects an @enum through a list of predefined list of 
	 * noOfRounds. 
	 */
	public NoOfRounds getNoOfRounds() {
		return noOfRounds;
	}

	public void setNoOfRounds(NoOfRounds noOfRounds) {
		this.noOfRounds = noOfRounds;
	}

	/*
	 * Selects an @enum through a list of predefined list of 
	 * formats. 
	 */
	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}
	
	

}
