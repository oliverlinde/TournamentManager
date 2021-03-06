package dao;

public class DAOFactory {

	private static boolean isTest = true;

	public static BracketDAOIF createBracketDAO() {
		return new BracketDAO(getConnection());
	}
	
	public static MatchRoundResultDAOIF createMatchRoundResultDAO() {
		return new MatchRoundResultDAO(getConnection());
	}
	
	public static TournamentDAOIF createTournamentDAO() {
		return new TournamentDAO(getConnection());
	}
	
	public static BracketRoundDAOIF createBracketRoundResultDAO() {
		return new BracketRoundDAO(getConnection());
	}

	public static TournamentRuleDAOIF createTournamentRuleDAO() {
		return new TournamentRuleDAO(getConnection());
	}
	
	public static PersonDAOIF createPersonDAO() {
		return new PersonDAO(getConnection());
	}
	
	public static TeamDAOIF createTeamDAO() {
		return new TeamDAO(getConnection());
	}
	
	public static BracketRoundDAOIF createBracketRoundDAO() {
		return new BracketRoundDAO(getConnection());
	}

	public static MatchDAOIF createMatchDAO() {
		return new MatchDAO(getConnection());
	}
	
	private static DbConnectionIF getConnection() {
		if(isTest) {
			return new DbConnectionTest();
		} else {
			return new DbConnection();
		}
	}


}
