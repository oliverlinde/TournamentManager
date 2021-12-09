package dao;

import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import model.Bracket;
import model.BracketRound;
import model.Team;

public interface BracketDAOIF {
	List<Team> getTeams();
	
	void givePointsToTeam(Team team, int pointsToWin);
	
	List<BracketRound> getBracketRounds();
	
	int createBracket(int tournamentId, Bracket bracket) throws SQLServerException;
	
}
