package controller;

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

	void setTournamentName(String name);

	String getTournamentName();

	void setGameName(String game);

	String getGameName();

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

	boolean saveTournamentToDatabase();

	void setGenerateBracketStrategy();

	GenerateBracketStrategyIF getStrategy();

}
