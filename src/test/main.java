package test;

import java.util.ArrayList;

import controller.TournamentControllerIF;
import model.Match;
import model.Team;

public class main {
	static TournamentControllerStub tournamentController;
	
	public static void main(String[] args) {
		tournamentController = new TournamentControllerStub();
		tournamentController.createTournament();
		
		Team team1 = new Team(1, "1");
		Team team2 = new Team(2, "2");
		Team team3 = new Team(3, "3");
		Team team4 = new Team(4, "4");
		
		tournamentController.addTeamToTournament(team1);
		tournamentController.addTeamToTournament(team2);
		tournamentController.addTeamToTournament(team3);
		tournamentController.addTeamToTournament(team4);

		tournamentController.generateNextBracket(1);

		ArrayList<Match> list = tournamentController.getMatch();
		
		for(Match m : list) {
			System.out.println(m.getListOfTeams());
		}
	}
}
