package controller;

import java.util.List;

import dao.DAOFactory;
import dao.DbConnection;
import model.Person;
import model.Team;

/*
 * TeamController is not used yet, hence the methods are not yet implemented.
 * Intended use is to create a Team and administrate this object
 */
public class TeamController implements TeamControllerIF {
	public TeamController() {
		DAOFactory.createTeamDAO(new DbConnection());
	}
	
	@Override
	public void addPersonToTeam(Person person) {

	}

	@Override
	public void removePersonFromTeam(Person person) {
	
	}

	@Override
	public Team getTeam(int teamId) {
		return null;
	}

	@Override
	public List<Team> getAllTeams() {
		return null;
	}

	@Override
	public void createTeam(String teamName, Person person) {

	}

	@Override
	public void removeTeam(int teamId) {

	}


}
