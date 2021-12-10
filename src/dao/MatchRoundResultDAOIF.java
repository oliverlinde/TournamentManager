package dao;

import java.sql.SQLException;
import java.util.List;

import model.Match;
import model.MatchRoundResult;
import model.Team;

public interface MatchRoundResultDAOIF {
	
	void setWinner(int matchRoundResultId, Team team) throws SQLException;
	
	//void setLoser(Team team);
	
	//void setDraw();
	
	MatchRoundResult getRoundResult(int matchRoundResultId) throws SQLException;

	List<MatchRoundResult> getTotalListOfMatchRoundResults(int matchId) throws SQLException;

	int createMatchRoundResult(Match match, MatchRoundResult matchRoundResult) throws SQLException;

	int getNextMatchRoundResultId() throws SQLException;

}
