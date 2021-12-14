package dao;

import java.sql.SQLException;
import java.util.List;

import model.BracketRound;

public interface BracketRoundDAOIF {

	List<BracketRound> getBracketRoundsFromBracket(int bracketId) throws SQLException;

	int createBracketRound(int bracketId, BracketRound bracketRound) throws SQLException;

	int getNextBracketRoundId() throws SQLException;

}
