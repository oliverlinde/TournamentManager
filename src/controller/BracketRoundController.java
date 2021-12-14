package controller;

import java.sql.SQLException;
import java.util.List;

import dao.BracketRoundDAOIF;
import model.BracketRound;
import model.Match;

public class BracketRoundController implements BracketRoundControllerIF {
	private BracketRoundDAOIF bracketRoundDAO;
	
	public BracketRoundController(BracketRoundDAOIF bracketRoundDAO) {
		this.bracketRoundDAO = bracketRoundDAO;
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
