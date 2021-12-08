package dao;

import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import model.BracketRound;
import model.Team;

public interface BracketDAOIF {
	List<Team> getTeams();
	
	void givePointsToTeam(Team team, int pointsToWin);
	
	List<BracketRound> getBracketRounds();
	
	void createBracketRound(List<Team> listOfTeams) throws SQLServerException;
	
}
