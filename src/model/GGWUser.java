package model;

import java.time.LocalDate;
import java.util.List;

public class GGWUser extends Person {

	private boolean isAdmin;
	private String role;
	
	public GGWUser(boolean isAdmin, String personName, String email, LocalDate birthdate, String role) {
		super(personName, email, birthdate);
		setAdmin(isAdmin);
		setRole(role);
	}
	
	public GGWUser(int personId, String personName, String email, LocalDate birthdate, List<Team> teams) {
		super(personId, personName, email, birthdate, teams);
		// TODO Auto-generated constructor stub
	}
	
	public GGWUser(int personId, boolean isAdmin, String personName, String email, LocalDate birthdate, String role) {
		super(personId, personName, email, birthdate);
		setAdmin(isAdmin);
		setRole(role);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
