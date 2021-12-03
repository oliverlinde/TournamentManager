package DAO;

import java.util.List;

import model.BracketRound;
import model.Team;

public interface BracketDAOIF {
	List<Team> getTeams();
	
	void givePointsToTeam(Team team, int pointsToWin);
	
	List<BracketRound> getBracketRounds();
	
	void createBrackRound(List<Team> listOfTeams);
	
}
