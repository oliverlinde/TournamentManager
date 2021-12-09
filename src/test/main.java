package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.TournamentController;
import controller.TournamentControllerIF;
import dao.DAOFactory;
import dao.DbConnection;
import dao.DbConnectionIF;
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
	static DbConnectionIF dbConnection;
	
	public static void main(String[] args) throws SQLException {
		
		tournamentController = new TournamentController();
		dbConnection = new DbConnection();
		tournamentDAO = DAOFactory.createTournamentDAO(dbConnection);
		
		Tournament tournament = tournamentDAO.getTournament(2);
		tournamentController.setTournament(tournament);
		
		Team team1 = new Team(1, "1");
		Team team2 = new Team(2, "2");
		Team team3 = new Team(3, "3");
		Team team4 = new Team(4, "4");
		Team team5 = new Team(5, "5");
		Team team6 = new Team(6, "6");
		
		tournamentController.addTeamToTournament(team1);
		tournamentController.addTeamToTournament(team2);
		tournamentController.addTeamToTournament(team3);
		tournamentController.addTeamToTournament(team4);

		
		tournamentController.initializeTournament();
		tournamentController.generateNextBracketRound(3);
		
		Bracket bracket = tournamentController.getBracket();
		
		List<BracketRound> bracketRounds = bracket.getBracketRounds();
		
		for(BracketRound b : bracketRounds) {
			System.out.println("BracketRoundID: " + b.getBracketRoundID());
			System.out.println("===================");
			
			List<Match> matches = b.getMatches();
			for(Match m : matches) {
				System.out.println("MatchID: " + m.getMatchId());
				System.out.println("___________________");
				
				List<MatchRoundResult> rounds = m.getRoundResults();
				for(MatchRoundResult r : rounds) {
					System.out.println("RoundID: " + r.getMatchRoundResultId());
				}				
				
				List<Team> teamsInMatch = m.getListOfTeams();
				for(Team t : teamsInMatch) {
					System.out.println("Team name: " + t.getTeamName());
				}
					System.out.println("-------------------");
				
			}
		}
	}
}
