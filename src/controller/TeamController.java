package controller;

import java.util.List;

import dao.DAOFactory;
import dao.DbConnection;
import dao.TeamDAOIF;
import model.Person;
import model.Team;

public class TeamController implements TeamControllerIF {
	private TeamDAOIF teamDAO;
	private Team team;
	
	public TeamController() {
		teamDAO = DAOFactory.createTeamDAO(new DbConnection());
	}
	
	@Override
	public void addPersonToTeam(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePersonFromTeam(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Team getTeam(int teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getAllTeams() {
		return null;
	}

	@Override
	public void createTeam(String teamName, Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTeam(int teamId) {
		// TODO Auto-generated method stub
		
	}


}
