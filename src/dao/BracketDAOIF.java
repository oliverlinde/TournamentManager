package dao;

import java.sql.SQLException;
import java.util.List;

import model.Bracket;
import model.BracketRound;
import model.Team;

public interface BracketDAOIF {
	List<Team> getTeams();
	
	void givePointsToTeam(Team team, int pointsToWin) throws SQLException;
	
	List<BracketRound> getBracketRounds() throws SQLException;
	
	void createBracketRound(List<Team> listOfTeams) throws  SQLException;

	List<Bracket> getBracketsFromTournament(int tournamentId) throws SQLException;
	
}
