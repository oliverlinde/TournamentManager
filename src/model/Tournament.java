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

	public Tournament(int tournamentId) {
		brackets = new ArrayList<Bracket>();
		setTournamentId(tournamentId);
	}
	
	/*
	 * Constructor of Tournament, used for getting a tournament from database with all information
	 */
	public Tournament(int tournamentId, TournamentRule tournamentRule, String tournamentName, String gameName, LocalDateTime dateTimeOfEvent, LocalDateTime registrationDeadline, int maxNoOfTeams, int minNoOfTeams) {
		setTournamentId(tournamentId);
		setTournamentRule(tournamentRule);
		setTournamentName(tournamentName);
		setGameName(gameName);
		setDateTimeOfEvent(dateTimeOfEvent);
		setRegistrationDeadline(registrationDeadline);
		setMaxNoOfTeams(maxNoOfTeams);
		setMinNoOfTeams(minNoOfTeams);
		brackets = new ArrayList<>();
	}
	
	/*
	 * Constructor for Tournament, used for displaying a tournament with simple data
	 */
	public Tournament(int tournamentId, String tournamentName, String gameName, LocalDateTime dateTimeOfEvent, LocalDateTime registrationDeadline, int maxNoOfTeams, int minNoOfTeams) {
		setTournamentId(tournamentId);
		setTournamentName(tournamentName);
		setGameName(gameName);
		setDateTimeOfEvent(dateTimeOfEvent);
		setRegistrationDeadline(registrationDeadline);
		setMaxNoOfTeams(maxNoOfTeams);
		setMinNoOfTeams(minNoOfTeams);
	}

	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
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
	
	public int getTournamentId() {
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
	
	public void addTeam(Team team) {
		if (listOfTeams.size() < maxNoOfTeams) {
			listOfTeams.add(team);
		}
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

	
	public void setBrackets(List<Bracket> brackets) {
		this.brackets = brackets;
	}
	
	public void addBracket(Bracket bracket) {
		brackets.add(bracket);
	}

}
