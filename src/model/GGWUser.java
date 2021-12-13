package model;

import java.time.LocalDate;
import java.util.List;

public class GGWUser extends Person {

	private boolean isAdmin;
	private String role;
	
	/*
	 * Constructor creating a new GGWUser in application
	 */
	public GGWUser(boolean isAdmin, String personName, String email, LocalDate birthdate, String role) {
		super(personName, email, birthdate);
		setAdmin(isAdmin);
		setRole(role);
	}
	
	/*
	 * Constructor getting a GGWUser with teams from database
	 */
	public GGWUser(int personId, boolean isAdmin, String personName, String email, LocalDate birthdate, List<Team> teams, String role) {
		super(personId, personName, email, birthdate, teams);
		setAdmin(isAdmin);
		setRole(role);
	}
	
	/*
	 * Constructor getting a GGWUser from database
	 */
	public GGWUser(int personId, boolean isAdmin, String personName, String email, LocalDate birthdate, String role) {
		super(personId, personName, email, birthdate);
		setAdmin(isAdmin);
		setRole(role);
	}

	public String getRole() {
		return role;
	}

	private void setRole(String role) {
		this.role = role;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	private void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
