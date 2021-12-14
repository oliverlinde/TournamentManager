package controller;

import java.util.List;

import model.Person;
import model.Team;

public interface TeamControllerIF {
	void addPersonToTeam(Person person);

	void removePersonFromTeam(Person person);

	Team getTeam(int teamId);

	List<Team> getAllTeams();

	void createTeam(String teamName, Person person);

	void removeTeam(int teamId);

}
