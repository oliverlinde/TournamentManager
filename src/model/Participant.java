package model;

import java.time.LocalDate;
import java.util.List;

public class Participant extends Person {
	
	public Participant(String name, String email, LocalDate birthdate) {
		super(name, email, birthdate);
	}
	
	public Participant(int id, String name, String email, LocalDate birthdate, List<Team> teams) {
		super(id, email, email, birthdate, teams);
	}
}
