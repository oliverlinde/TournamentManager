package controller;

import java.sql.SQLException;
import java.util.List;

import dao.TeamDAOIF;
import model.Person;
import model.Team;

/*
 * TeamController is not used yet, hence the methods are not yet implemented.
 * Intended use is to create a Team and administrate this object
 */
public class TeamController implements TeamControllerIF {
	private TeamDAOIF teamDAO;
	
	public TeamController(TeamDAOIF teamDAO) {
		this.teamDAO = teamDAO;
	}
	
	@Override
	public void addPersonToTeam(Person person) {

	}

	@Override
	public void removePersonFromTeam(Person person) {
	
	}

	@Override
	public Team getTeam(int teamId) {
		Team team = null;
		try {
			return teamDAO.getTeam(teamId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return team;
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
