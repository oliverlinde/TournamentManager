package dao;

import java.sql.SQLException;
import java.util.List;

import model.TournamentRule;

public interface TournamentRuleDAOIF {

	TournamentRule getTournamentRule(int tournamentRuleId) throws SQLException;
	List<TournamentRule> getAllTournamentRules() throws SQLException;
}
