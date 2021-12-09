package dao;

import java.sql.SQLException;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import model.Bracket;
import model.BracketRound;
import model.Team;

public interface BracketDAOIF {
	List<Team> getTeams();
	
	void givePointsToTeam(Team team, int pointsToWin);
	
	List<BracketRound> getBracketRounds();
	
	int createBracket(int tournamentId, Bracket bracket) throws SQLException;

	int getNextBracketId() throws SQLException;
	
}
