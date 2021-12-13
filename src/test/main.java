package test;

import java.sql.SQLException;
import controller.TournamentController;
import controller.TournamentControllerIF;
import dao.BracketDAOIF;
import dao.BracketRoundDAOIF;
import dao.DAOFactory;
import dao.DbConnection;
import dao.DbConnectionIF;
import dao.MatchDAO;
import dao.MatchDAOIF;
import dao.MatchRoundResultDAOIF;
import dao.TeamDAOIF;
import dao.TournamentDAOIF;
import dao.TournamentRuleDAOIF;

import model.Bracket;
import model.BracketRound;
import model.Match;
import model.MatchRoundResult;
import model.Tournament;

public class main {
	static TournamentControllerIF tournamentController;
	static TournamentDAOIF tournamentDAO;
	static TeamDAOIF teamDAO;
	static DbConnectionIF dbConnection;

	public static void main(String[] args) throws SQLException {

		
		tournamentController = new TournamentController();
		dbConnection = new DbConnection();
		MatchRoundResultDAOIF matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO(dbConnection);
		MatchDAOIF matchDAO = DAOFactory.createMatchDAO(dbConnection);
		BracketRoundDAOIF bracketRoundDAO = DAOFactory.createBracketRoundDAO(dbConnection);
		BracketDAOIF bracketDAO = DAOFactory.createBracketDAO(dbConnection);
		TournamentRuleDAOIF tournamentRuleDAO = DAOFactory.createTournamentRuleDAO(dbConnection);
		tournamentDAO = DAOFactory.createTournamentDAO(dbConnection);
		teamDAO = DAOFactory.createTeamDAO(dbConnection);
		

//		tournamentController.createTournament();
//		
//		tournamentController.setName("Test");
//		tournamentController.setGame("Spil");
//		tournamentController.setMaxNoOfTeams(16);
//		tournamentController.setTournamentRule(tournamentRuleDAO.getTournamentRule(1));
//		tournamentController.confirmTournament();

		tournamentController.getTournamentById(3);
		tournamentController.addTeamToTournament(teamDAO.getTeam(10));
		tournamentController.addTeamToTournament(teamDAO.getTeam(15));
		tournamentController.addTeamToTournament(teamDAO.getTeam(22));
		tournamentController.addTeamToTournament(teamDAO.getTeam(44));

		tournamentController.initializeTournament();

		Tournament tournament = tournamentController.getTournament();

		System.out.println("Tournament ID: " + tournament.getId() + "\n" + "Tournament name: " + tournament.getName());
		System.out.println("-----------------");

		for (Bracket bracket : tournament.getBrackets()) {
			System.out.println("Bracket ID: " + bracket.getBracketId());
			System.out.println("-----------------");

			for (BracketRound bracketRound : bracket.getBracketRounds()) {
				System.out.println("BracketRound ID: " + bracketRound.getBracketRoundID());

				for (Match match : bracketRound.getMatches()) {
					System.out.println("Match ID: " + match.getMatchId());
					System.out.println(match.getListOfTeams().get(0).getTeamName());
					System.out.println(match.getListOfTeams().get(1).getTeamName());
					System.out.println("_________________");
					for (MatchRoundResult matchRound : match.getListOfMatchRounds()) {
						System.out.println("MatchRoundID: " + match.getMatchId() + "." + matchRound.getMatchRoundResultId());
						System.out.println("-----------------");
					}
				}
			}
		}
		

//		Bracket bracket = tournamentController.get;
//		System.out.println("Bracket ID: " + bracket.getBracketId());
//
//		List<BracketRound> bracketRounds = bracket.getBracketRounds();
//
//		for (BracketRound b : bracketRounds) {
//			System.out.println("BracketRoundID: " + b.getBracketRoundID());
//			System.out.println("===================");
//
//			List<Match> matches = b.getMatches();
//			for (Match m : matches) {
//				System.out.println("MatchID: " + m.getMatchId());
//				System.out.println("___________________");
//
//				List<MatchRoundResult> rounds = m.getRoundResults();
//				for (MatchRoundResult r : rounds) {
//					System.out.println("RoundID: " + r.getMatchRoundResultId());
//				}
//
//				List<Team> teamsInMatch = m.getListOfTeams();
//				for (Team t : teamsInMatch) {
//					System.out.println("Team name: " + t.getTeamName());
//				}
//				System.out.println("-------------------");
//
//			}
//		}
	}
}
