package model;

import java.time.LocalDate;
import java.util.List;

public abstract class Person {
	private int personId;
	private String personName;
	private String email;
	private LocalDate birthdate;
	private List<Team> teams;
	
	public Person(String personName, String email, LocalDate birthdate) {
		this.personName = personName;
		this.email = email;
		this.birthdate = birthdate;
	}
	
	public Person(int personId, String personName, String email, LocalDate birthdate, List<Team> teams) {
		this.personId = personId;
		this.personName = personName;
		this.email = email;
		this.birthdate = birthdate;
		this.teams = teams;
	}
	
	public Person(int personId, String personName, String email, LocalDate birthdate) {
		setPersonId(personId);
		setPersonName(personName);
		setEmail(email);
		setBirthdate(birthdate);
	}
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
