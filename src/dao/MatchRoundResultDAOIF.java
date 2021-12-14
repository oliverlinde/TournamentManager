package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import model.MatchRoundResult;
import model.Team;

public interface MatchRoundResultDAOIF {
	
	void setWinner(int matchRoundResultId, Team team) throws SQLException;

	int getNextMatchRoundResultId() throws SQLException;

	List<MatchRoundResult> getMatchRoundResultsFromMatch(int matchId) throws SQLException;

	MatchRoundResult getMatchRoundResultFromMatchIdAndMatchRoundResultId(int matchId, int matchRoundResultId) throws SQLException;

	List<Team> getTeamsFromMatch(int matchId) throws SQLException;

	int createMatchRoundResult(int matchId, int teamId, MatchRoundResult matchRoundResult) throws SQLException;

	Set<Integer> getMatchRoundResultIds(int matchId) throws SQLException;

}
