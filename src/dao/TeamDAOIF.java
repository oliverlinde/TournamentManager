package dao;

import java.sql.SQLException;
import java.util.List;

import model.Team;

public interface TeamDAOIF {
	
	int createTeam(Team team) throws SQLException;
	
	Team getTeam (int teamId) throws SQLException;

	List<Team> getTeamsFromMatch(int matchId) throws SQLException;

}
