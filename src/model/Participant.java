package model;

import java.time.LocalDate;
import java.util.List;

public class Participant extends Person {
	
	public Participant(String personName, String email, LocalDate birthdate) {
		super(personName, email, birthdate);
	}
	
	public Participant(int personId, String personName, String email, LocalDate birthdate, List<Team> teams) {
		super(personId, personName, email, birthdate, teams);
	}
	
	public Participant(int personId, String personName, String email, LocalDate birthdate) {
		super(personName, email, birthdate);
	}
	
}
