package test;

import java.util.List;

import controller.TournamentRuleControllerIF;
import dao.DAOFactory;
import dao.DbConnectionIF;
import dao.TournamentRuleDAOIF;
import model.Format;
import model.NoOfRounds;
import model.TournamentRule;

public class TournamentRuleControllerStub implements TournamentRuleControllerIF {
	private TournamentRule tournamentRule;
	private TournamentRuleDAOIF tournamentRuleDAO;
	
	public TournamentRuleControllerStub(DbConnectionIF dbConnection) {
		tournamentRule = new TournamentRule("Single elimination CS:GO", 1, 0, 0, NoOfRounds.BestOfOne, Format.SingleElimination);
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
		return tournamentRule.getFormat();
	}
	
	public TournamentRule getTournamentRule() {
		return tournamentRule;
	}

	@Override
	public List<TournamentRule> getAllTournamentRule() {
		// TODO Auto-generated method stub
		return null;
	}

}
