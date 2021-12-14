package controller;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.DAOFactory;
import dao.DbConnection;
import dao.TournamentRuleDAOIF;
import model.Format;
import model.NoOfRounds;
import model.TournamentRule;

public class TournamentRuleController implements TournamentRuleControllerIF {
	private TournamentRule tournamentRule;
	private TournamentRuleDAOIF tournamentRuleDAO;

	public TournamentRuleController(TournamentRuleDAOIF tournamentRuleDAO) {
		this.tournamentRuleDAO = tournamentRuleDAO;
	}

	@Override
	public List<TournamentRule> getAllTournamentRule() {
		List<TournamentRule> tournamentRuleList = new LinkedList<>();
		try {
			tournamentRuleList = tournamentRuleDAO.getAllTournamentRules();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tournamentRuleList;
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
	public NoOfRounds getNoOfRounds() {
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

}
