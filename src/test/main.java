package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.TournamentController;
import controller.TournamentControllerIF;
import dao.DAOFactory;
import dao.DbConnection;
import dao.DbConnectionIF;
import dao.TeamDAOIF;
import dao.TournamentDAOIF;
import model.Bracket;
import model.BracketRound;
import model.Format;
import model.Match;
import model.MatchRoundResult;
import model.Team;
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

		Tournament tournament = tournamentDAO.getTournament(2);
		tournamentController.setTournament(tournament);

		tournamentController.addTeamToTournament(teamDAO.getTeam(10));
		tournamentController.addTeamToTournament(teamDAO.getTeam(15));
		tournamentController.addTeamToTournament(teamDAO.getTeam(22));
		tournamentController.addTeamToTournament(teamDAO.getTeam(44));

		tournamentController.initializeTournament();
		tournamentController.generateNextBracketRound(1);
		tournamentController.generateNextBracketRound(3);

		Bracket bracket = tournamentController.getBracket();
		System.out.println("Bracket ID: " + bracket.getBracketId());

		List<BracketRound> bracketRounds = bracket.getBracketRounds();

		for (BracketRound b : bracketRounds) {
			System.out.println("BracketRoundID: " + b.getBracketRoundID());
			System.out.println("===================");

			List<Match> matches = b.getMatches();
			for (Match m : matches) {
				System.out.println("MatchID: " + m.getMatchId());
				System.out.println("___________________");

				List<MatchRoundResult> rounds = m.getRoundResults();
				for (MatchRoundResult r : rounds) {
					System.out.println("RoundID: " + r.getMatchRoundResultId());
				}

				List<Team> teamsInMatch = m.getListOfTeams();
				for (Team t : teamsInMatch) {
					System.out.println("Team name: " + t.getTeamName());
				}
				System.out.println("-------------------");

			}
		}
	}
}
