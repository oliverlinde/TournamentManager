package dao;

import model.Match;
import model.Team;

public interface MatchDAOIF {
	void setRoundResult(Team winningTeam);
	
	void setDraw();
	
	Match getMatch(int matchId);
	
	void createRoundResult();

	int getNextMatchId();

	int createMatch(int bracketRoundId, Match match);

}
