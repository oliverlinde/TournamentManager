package dao;

import java.sql.SQLException;
import java.util.List;

import model.TournamentRule;

public interface TournamentRuleDAOIF {

	List<TournamentRule> getAllTournamentRules() throws SQLException;
}
