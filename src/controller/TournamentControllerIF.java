package controller;

import java.time.LocalDateTime;
import java.util.List;

import model.Bracket;
import model.Format;

import model.Team;
import model.Tournament;
import model.TournamentRule;

public interface TournamentControllerIF {

	public Tournament createTournament();
	public void setName(String name);
	public String getName();
	public void setGame(String game);
	public String getGame();
	public void setRegistrationDeadline(LocalDateTime registrationDeadline);
	public LocalDateTime getRegistrationDeadline();
	public void setDateTimeOfEvent(LocalDateTime dateTimeOfEvent);
	public LocalDateTime getDateTimeOfEvent();
	public void setMaxNoOfTeams(int maxNoOfTeams);
	public int getMaxNoOfTeams();
	public boolean confirmTournament();
	public boolean cancelTournament();
	public TournamentRule getTournamentRule();
	public void setTournamentRule(TournamentRule tournamentRule);
	public int calculatePoints(TournamentRule tournamentRule);
	public void generateNextBracketRound(int noOfRounds);
	public void addTeamToTournament(Team team);
	public List<Team> getAllTeams();
	public List<Tournament> getAllTournaments();
	List<TournamentRule> getAllTournamentRules();
	void changeFormat(Object object);
	void setMinNoOfTeams(int minNoOfTeams);
	int getMinNoOfTeams();
	int getNextTournamentId();

	public Bracket getBracket();
	void setTournament(Tournament tournament);
	void initializeTournament();
	void removeTeamFromTournament(Team team);

	Tournament getTournamentById(int tournamentId);

}
