/*
 * Creates an instance of a specific tournament.
 */

package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
	private int tournamentId;
	private String tournamentName;
	private String gameName;
	private LocalDateTime dateTimeOfEvent;
	private LocalDateTime registrationDeadline;
	private int maxNoOfTeams;
	private int minNoOfTeams;
	private TournamentRule tournamentRule;
	private List<Team> listOfTeams;
	private List<Bracket> brackets;
	
	public Tournament() {
		brackets = new ArrayList<Bracket>();
		tournamentId = 1;
	}
	
	public Tournament(int tournamentId, TournamentRule tournamentRule, String tournamentName, String gameName, LocalDateTime dateTimeOfEvent, LocalDateTime registrationDeadline, int maxNoOfTeams, int minNoOfTeams) {
		this.tournamentId = tournamentId;
		setTournamentRule(tournamentRule);
		setName(tournamentName);
		setGame(gameName);
		setDateTimeOfEvent(dateTimeOfEvent);
		setRegistrationDeadline(registrationDeadline);
		setMaxNoOfTeams(maxNoOfTeams);
		setMinNoOfTeams(minNoOfTeams);
	}

	public String getName() {
		return tournamentName;
	}

	public void setName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public String getGame() {
		return gameName;
	}

	public void setGame(String gameName) {
		this.gameName = gameName;
	}

	public LocalDateTime getDateTimeOfEvent() {
		return dateTimeOfEvent;
	}

	public void setDateTimeOfEvent(LocalDateTime dateTimeOfEvent) {
		this.dateTimeOfEvent = dateTimeOfEvent;
	}

	public LocalDateTime getRegistrationDeadline() {
		return registrationDeadline;
	}

	public void setRegistrationDeadline(LocalDateTime registrationDeadline) {
		this.registrationDeadline = registrationDeadline;
	}

	public int getMaxNoOfTeams() {
		return maxNoOfTeams;
	}
	
	public int getId() {
		return tournamentId;
	}
	
	public int getMinNoOfTeams() {
		return minNoOfTeams;
	}

	public void setMinNoOfTeams(int minNoOfTeams) {
		this.minNoOfTeams = minNoOfTeams;
	}


	/*
	 * Adding a list of teams with a overhead through the @param maxNoOfTeams
	 * which will make sure that the index numbers in listOfTeams will only be as�
	 * long as required.
	 */
	public void setMaxNoOfTeams(int maxNoOfTeams) {
		listOfTeams = new ArrayList<>(maxNoOfTeams);
		this.maxNoOfTeams = maxNoOfTeams;
	}

	public TournamentRule getTournamentRule() {
		return tournamentRule;
	}

	public void setTournamentRule(TournamentRule tournamentRule) {
		this.tournamentRule = tournamentRule;
	}

	/*
	 * Search for a specific team through an  @param teamId, which returns
	 * the team with an equal teamId. 
	 */
	public Team findTeam(int teamId) {
		Team foundTeam = null;
		
		for (Team team : listOfTeams) {
			if(teamId == team.getTeamId()) {
				foundTeam = team;
			}
			
		}
		return foundTeam;
	}
	
	public void addTeam(Team team) {
		listOfTeams.add(team);
	}
	
	public void setAllTeams(List<Team> teams) {
		listOfTeams = teams;
	}
	
	public List<Team> getAllTeams() {
		return listOfTeams;
	}
	
	public List<Bracket> getBrackets(){
		return brackets;
	}
}
