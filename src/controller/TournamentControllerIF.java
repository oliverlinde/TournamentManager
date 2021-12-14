package controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import model.Team;
import model.Tournament;
import model.TournamentRule;

public interface TournamentControllerIF {

	void setTournament(Tournament tournament);

	void initializeTournament();
	
	Tournament getTournamentById(int tournamentId);

	Tournament getTournament();

	Tournament createTournament();

	void setName(String name);

	String getName();

	void setGame(String game);

	String getGame();

	void setRegistrationDeadline(LocalDateTime registrationDeadline);

	LocalDateTime getRegistrationDeadline();

	void setDateTimeOfEvent(LocalDateTime dateTimeOfEvent);

	LocalDateTime getDateTimeOfEvent();

	void setMaxNoOfTeams(int maxNoOfTeams);

	int getMaxNoOfTeams();

	boolean confirmTournament();

	TournamentRule getTournamentRule();

	void setTournamentRule(TournamentRule tournamentRule);

	void addTeamToTournament(Team team);

	List<Team> getAllTeams();

	List<Tournament> getAllTournaments();

	List<TournamentRule> getAllTournamentRules();

	void changeFormat(Object object);

	void setMinNoOfTeams(int minNoOfTeams);

	int getMinNoOfTeams();

	int getNextTournamentId();

	boolean saveToDatabase() throws SQLException;

	void setGenerateBracketStrategy();

	GenerateBracketStrategyIF getStrategy();

}
