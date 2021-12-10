package dao;

import java.sql.SQLException;
import java.util.List;

import model.BracketRound;
import model.Team;

public interface BracketRoundDAOIF {
	
	void setBracketRoundResult(List<Team> listOfWinners, List<Team> listOfLosers);
	
	//BracketRoundResult getBracketRoundResult();
	
	//void createMatches(List<Team> listOfTeams);
	
	BracketRound getBracketRound(int bracketRoundId);

	List<BracketRound> getBracketRounds(int bracketId);

	List<BracketRound> getBracketRoundsFromBracket(int bracketId) throws SQLException;

	int createBracketRound(int bracketId, BracketRound bracketRound) throws SQLException;

	int getNextBracketRoundId() throws SQLException;

	
	

}
