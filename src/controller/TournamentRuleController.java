package controller;

public class TournamentRuleController implements TournamentRuleControllerIF {
	private TournamentRule tournamentRule;
	
	public TournamentRuleController(String description, int pointsPerWin, int pointsPerLoss, int pointsPerDraw, NoOfRounds noOfRounds, Format format) {
		tournamentRule = new TournamentRule(description, pointsPerWin, pointsPerLoss, pointsPerDraw, noOfRounds, format);
	}

	@Override
	public String getDescription() {
		return tournamentRule.getDescription();
	}

	@Override
	public void setDescription(String description) {
		tournamentRule.setDescription(description);
	}

	@Override
	public int getPointsPerWin() {
		return tournamentRule.getPointsPerWin();
	}

	@Override
	public void setPointsPerWin(int pointsPerWin) {
		tournamentRule.setPointsPerWin(pointsPerWin);
	}

	@Override
	public int getPointsPerLoss() {
		return tournamentRule.getPointsPerLoss();
	}

	@Override
	public void setPointsPerLoss(int pointsPerLoss) {
		tournamentRule.setPointsPerLoss(pointsPerLoss);
	}

	@Override
	public int getPointsPerDraw() {
		return tournamentRule.getPointsPerDraw();
	}

	@Override
	public void setPointsPerDraw(int pointsPerDraw) {
		tournamentRule.setPointsPerDraw(pointsPerDraw);
	}

	@Override
	public void setNoOfRounds(NoOfRounds noOfRounds) {
		tournamentRule.setNoOfRounds(noOfRounds);
	}

	@Override
	public NoOfRounds getNoOfRonds() {
		return tournamentRule.getNoOfRounds();
	}

	@Override
	public void setFormat(Format format) {
		tournamentRule.setFormat(format);
	}

	@Override
	public Format getFormat() {
		tournamentRule.getFormat();
	}

}
