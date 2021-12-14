package controller;

import java.util.List;

import model.Format;
import model.NoOfRounds;
import model.TournamentRule;

public interface TournamentRuleControllerIF {

	String getDescription();

	void setDescription(String description);

	int getPointsPerWin();

	void setPointsPerWin(int pointsPerWin);

	int getPointsPerLoss();

	void setPointsPerLoss(int pointsPerLoss);

	int getPointsPerDraw();

	void setPointsPerDraw(int pointsPerDraw);

	void setNoOfRounds(NoOfRounds noOfRounds);

	NoOfRounds getNoOfRonds();

	void setFormat(Format format);

	Format getFormat();

	List<TournamentRule> getAllTournamentRule();
}
