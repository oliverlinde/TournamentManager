package DAO;

import java.util.List;

public interface BracketRoundsDAOIF {
	
	void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers);
	
	BracketRoundResult getBracketRoundResult();
	
	void createMatches(List<Team> listOfTeams);
	
	BracketRoundsDAOIF getBracketRound();

	
	

}
