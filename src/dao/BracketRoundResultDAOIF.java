package dao;

import java.sql.SQLException;

import model.BracketRoundResult;
import model.Team;

public interface BracketRoundResultDAOIF {

	BracketRoundResult getBracketRoundResult(int bracketRoundId) throws SQLException;

	Team getWinnerOfBracketRound(int matchRoundResultId);

	void setBracketRoundResult(int bracketRoundId, Team team) throws SQLException;

	int getNextBracketRoundId();

}
