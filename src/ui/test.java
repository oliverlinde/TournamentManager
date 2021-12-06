package ui;
import java.sql.SQLException;

import dao.TournamentDAO;
import dao.TournamentDAOIF;
import model.Tournament;


public class test {
	
	public static void main(String[] args) throws SQLException {
		Tournament tournament = new Tournament();
		tournament.setName("testTournament");
		tournament.setGame("Counter-Strike");
		tournament.setMaxNoOfTeams(2);
		tournament.setMinNoOfTeams(1);
		TournamentDAOIF tournamentDAO = new TournamentDAO();
		System.out.println(tournamentDAO.createTournament(tournament));
		
	}
	
	

}
