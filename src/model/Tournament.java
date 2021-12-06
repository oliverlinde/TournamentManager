/*
 * Creates an instance of a specific tournament.
 */

package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tournament {
	private int id;
	private String name;
	private String game;
	private LocalDateTime dateTimeOfEvent;
	private LocalDateTime registrationDeadline;
	private int maxNoOfTeams;
	private int minNoOfTeams;
	private TournamentRule tournamentRule;
	private List<Team> listOfTeams;
	private List<Bracket> brackets;
	
	public Tournament() {
		brackets = new ArrayList<Bracket>();
		id = 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
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
		return id;
	}
	
	public int getMinNoOfTeams() {
		return minNoOfTeams;
	}

	public void setMinNoOfTeams(int minNoOfTeams) {
		this.minNoOfTeams = minNoOfTeams;
	}


	/*
	 * Adding a list of teams with a overhead through the @param maxNoOfTeams
	 * which will make sure that the index numbers in listOfTeams will only be as¨
	 * long as required.
	 */
	public void setMaxNoOfTeams(int maxNoOfTeams) {
		listOfTeams = new ArrayList<Team>(maxNoOfTeams);
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
	
	public List<Team> getAllTeams() {
		return listOfTeams;
	}
}
