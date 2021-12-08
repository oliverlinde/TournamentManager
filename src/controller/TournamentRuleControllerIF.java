package controller;

import model.Format;
import model.NoOfRounds;

public interface TournamentRuleControllerIF {

	public String getDescription();
	public void setDescription(String description);
	public int getPointsPerWin();
	public void setPointsPerWin(int pointsPerWin);
	public int getPointsPerLoss();
	public void setPointsPerLoss(int pointsPerLoss);
	public int getPointsPerDraw();
	public void setPointsPerDraw(int pointsPerDraw);
	public void setNoOfRounds(NoOfRounds noOfRounds);
	public NoOfRounds getNoOfRonds();
	public void setFormat(Format format);
	public Format getFormat();
}
