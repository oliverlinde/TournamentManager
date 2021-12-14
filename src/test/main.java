package test;

import java.sql.SQLException;
import controller.TournamentController;
import controller.TournamentControllerIF;
import dao.DAOFactory;
import dao.DbConnection;
import dao.DbConnectionIF;
import dao.TeamDAOIF;
import dao.TournamentDAOIF;
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
		tournamentDAO = DAOFactory.createTournamentDAO(dbConnection);
		teamDAO = DAOFactory.createTeamDAO(dbConnection);

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
		
//		tournamentController.confirmTournament();
	}
}
