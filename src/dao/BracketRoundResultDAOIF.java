package dao;

import java.sql.SQLException;

import model.BracketRoundResult;

public interface BracketRoundResultDAOIF {

	BracketRoundResult getBracketRoundResult(int bracketRoundId) throws SQLException;

}
