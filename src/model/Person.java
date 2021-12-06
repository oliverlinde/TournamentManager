package model;

import java.time.LocalDate;
import java.util.List;

public abstract class Person {
	private int id;
	private String name;
	private String email;
	private LocalDate birthdate;
	private List<Team> teams;
	
	public Person(String name, String email, LocalDate birthdate) {
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
	}
	
	public Person(int id, String name, String email, LocalDate birthdate, List<Team> teams) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.teams = teams;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
