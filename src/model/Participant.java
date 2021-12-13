package model;

import java.time.LocalDate;
import java.util.List;

public class Participant extends Person {
	
	/*
	 * Constructor creates a new Participant in the application
	 */
	public Participant(String personName, String email, LocalDate birthdate) {
		super(personName, email, birthdate);
	}
	
	/*
	 * Constructor displays a person an their teams from the database
	 */
	public Participant(int personId, String personName, String email, LocalDate birthdate, List<Team> teams) {
		super(personId, personName, email, birthdate, teams);
	}
	
	/*
	 * Constructor displays a person when searching from a team from the database
	 */
	public Participant(int personId, String personName, String email, LocalDate birthdate) {
		super(personId, personName, email, birthdate);
	}
	
}
