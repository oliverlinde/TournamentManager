package dao;

public class DAOFactory {

	public static BracketDAOIF createBracketDAO(DbConnectionIF dbConnection) {
		return new BracketDAO(dbConnection);
	}
	
	public static MatchRoundResultDAOIF createMatchRoundResultDAO(DbConnectionIF dbConnection) {
		return new MatchRoundResultDAO(dbConnection);
	}
	
	public static TournamentDAOIF createTournamentDAO(DbConnectionIF dbConnection) {
		return new TournamentDAO(dbConnection);
	}
	
	public static BracketRoundDAOIF createBracketRoundResultDAO(DbConnectionIF dbConnection) {
		return new BracketRoundDAO(dbConnection);
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
	
	public static BracketRoundDAOIF createBracketRoundDAO(DbConnectionIF dbConnection) {
		return new BracketRoundDAO(dbConnection);
	}

	public static MatchDAOIF createMatchDAO(DbConnectionIF dbConnection) {
		return new MatchDAO(dbConnection);
	}

	
	public static BracketRoundDAOIF createBracketRoundDAO(DbConnectionIF dbConnection) {
		return new BracketRoundDAO(dbConnection);
	}

}
