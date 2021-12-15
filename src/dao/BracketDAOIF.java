package dao;

import java.sql.SQLException;
import java.util.List;
import model.Bracket;

public interface BracketDAOIF {

	int createBracket(int tournamentId, Bracket bracket) throws SQLException;

	List<Bracket> getBracketsFromTournament(int tournamentId) throws SQLException;
	
}
