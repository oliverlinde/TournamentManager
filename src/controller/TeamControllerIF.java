package controller;

import java.util.List;

import model.Person;
import model.Team;

public interface TeamControllerIF {
	public void addPersonToTeam(Person person);
	public void removePersonFromTeam(Person person);
	public Team getTeam(int teamId);
	public List<Team> getAllTeams();
	public void createTeam(String teamName, Person person);
	public void removeTeam(int teamId);
	
}
