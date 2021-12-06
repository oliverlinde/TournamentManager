package model;

import java.time.LocalDate;
import java.util.List;

public class GGWUser extends Person {

	private boolean isAdmin;
	private String role;
	
	public GGWUser(boolean isAdmin, String name, String email, LocalDate birthdate, String role) {
		super(name, email, birthdate);
		this.setAdmin(isAdmin);
		this.setRole(role);
	}
	
	public GGWUser(int id, String name, String email, LocalDate birthdate, List<Team> teams) {
		super(id, name, email, birthdate, teams);
		// TODO Auto-generated constructor stub
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
