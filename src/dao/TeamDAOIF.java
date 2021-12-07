package dao;

import java.sql.SQLException;

import model.Team;

public interface TeamDAOIF {
	
	int createTeam(Team team) throws SQLException;
	
	Team getTeam (int teamId) throws SQLException;

}
