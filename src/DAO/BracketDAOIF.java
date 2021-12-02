package DAO;

import java.util.List;

public interface BracketDAOIF {
	List<Team> getTeams();
	
	void givePointsToTeam(Team team, int pointsToWin);
	
	List<BracketRounds> getBracketRounds();
	
	void createBrackRound(List<Team> listOfTeams);
	
}
