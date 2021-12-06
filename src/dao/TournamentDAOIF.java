package dao;

import java.sql.SQLException;

import model.Tournament;

public interface TournamentDAOIF {
	
	int createTournament(Tournament tournament) throws SQLException;
	
	Tournament getTournament(int tournamentId) throws SQLException;

}
