package dao;

import java.sql.SQLException;
import java.util.List;

import model.Match;
import model.Team;

public interface MatchDAOIF {
	void setRoundResult(Team winningTeam);
	
	void setDraw();
	
	Match getMatch(int matchId) throws SQLException;
	
	void createRoundResult() throws SQLException;

	List<Match> getMatchesFromBracketRound(int bracketRoundId) throws SQLException;

	void setMatchRoundResult(int matchRoundResultId, Team winningTeam) throws SQLException;

}
