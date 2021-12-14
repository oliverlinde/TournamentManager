package controller;

import java.sql.SQLException;
import java.util.List;

import dao.BracketRoundDAOIF;
import dao.DAOFactory;
import dao.DbConnection;
import model.BracketRound;
import model.Match;

public class BracketRoundController implements BracketRoundControllerIF {
	private MatchControllerIF matchController;
	private BracketRoundDAOIF bracketRoundDAO;
	public BracketRoundController() {
		bracketRoundDAO = DAOFactory.createBracketRoundDAO(new DbConnection());
	}

	@Override
	public List<Match> getAllMatches() {
		return matchController.getAllMatches();
	}

	@Override
	public BracketRound generateBracketRound(List<Match> listOfMatches) {
		return new BracketRound(getBracketRoundId(), listOfMatches);
	}

	private int getBracketRoundId() {
		int id = 0;
		try {
			id = bracketRoundDAO.getNextBracketRoundId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void saveBracketRoundToDatabase(int bracketId, BracketRound bracketRound) {
		try {
			bracketRoundDAO.createBracketRound(bracketId, bracketRound);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
