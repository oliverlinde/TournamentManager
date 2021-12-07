package dao;

public class DAOFactory {

	public static BracketDAOIF createBracketDAO(DbConnectionIF dbConnection) {
		return new BracketDAO(dbConnection);
	}
	
	public static MatchRoundResultDAOIF createMatchRoundResultDAO(DbConnectionIF dbConnection) {
		return new MatchRoundResultDAO(dbConnection);
	}

	public static TournamentRuleDAOIF createTournamentRuleDAO(DbConnectionIF dbConnection) {
		return new TournamentRuleDAO(dbConnection);
	}
	
	public static PersonDAOIF createPersonDAO(DbConnectionIF dbConnection) {
		return new PersonDAO(dbConnection);
	}
	
	public static TeamDAOIF createTeamDAO(DbConnectionIF dbConnection) {
		return new TeamDAO(dbConnection);
	}
}
