package dao;

import java.sql.SQLException;

import model.Match;
import model.Team;

public interface MatchDAOIF {
	void setRoundResult(Team winningTeam);
	
	void setDraw();
	
	Match getMatch(int matchId);
	
	void createRoundResult();

	int getNextMatchId() throws SQLException;

	int createMatch(int bracketRoundId, Match match) throws SQLException;

}
