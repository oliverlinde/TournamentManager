package ui;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import dao.DbConnection;
import dao.TournamentDAO;
import dao.TournamentDAOIF;
import model.Team;
import model.Tournament;


public class test {
	
	public static void main(String[] args) throws SQLException {
		/*
		Tournament tournament = new Tournament();
		tournament.setName("testTournament");
		tournament.setGame("Counter-Strike");
		tournament.setMaxNoOfTeams(2);
		tournament.setMinNoOfTeams(1);
		System.out.println(tournamentDAO.createTournament(tournament));
		*/
		TournamentDAOIF tournamentDAO = new TournamentDAO(new DbConnection());
		Tournament tournament = tournamentDAO.getTournament(1);
		System.out.println(tournament.getDateTimeOfEvent().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		System.out.println(tournament.getTournamentName());
		System.out.println(tournament.getGameName());
		for(Team t : tournament.getAllTeams()) {
			System.out.println(t.getTeamName());
		}
		
	}
	
}