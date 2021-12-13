package dao;

import java.sql.SQLException;
import java.util.List;

import model.Team;
import model.Tournament;

public interface TournamentDAOIF {
	
	int createTournament(Tournament tournament) throws SQLException;
	
	Tournament getTournament(int tournamentId) throws SQLException;

	List<Team> getTeamsInTournament(int tournamentId) throws SQLException;
	List<Tournament> getAllTournaments() throws SQLException;
	int getNextTournamentId() throws SQLException;

	int updateTournament(Tournament tournament) throws SQLException;
	
}
