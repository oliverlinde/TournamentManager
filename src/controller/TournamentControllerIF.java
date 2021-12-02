package controller;

import java.time.LocalDate;
import java.util.List;

import model.Tournament;

public interface TournamentControllerIF {

	public Tournament createTournament();
	public void setName(String name);
	public String getName();
	public void setGame(String game);
	public String getGame();
	public void setRegistrationDeadline(LocalDate registrationDeadline);
	public LocalDate getRegistrationDeadline();
	public void setDateTimeOfEvent(LocalDate dateTimeOfEvent);
	public LocalDate getDateTimeOfEvent();
	public void setMaxNoOfTeams(int maxNoOfTeams);
	public int getMaxNoOfTeams();
	public boolean confirmTournament();
	public boolean cancelTournament();
	public List<TournamentRule> getTournamentRule();
	public void setTournamentRules(TournamentRule tournamentRule);
	public int calculatePoints(TournamentRule tournamentRule);
	public void generateNextBracket();
	public void addTeamToTournament(Team team);
	public List<Team> getAllTeams();
}
