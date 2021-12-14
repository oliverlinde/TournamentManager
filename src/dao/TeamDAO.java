package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Team;

public class TeamDAO implements TeamDAOIF {
	private DbConnectionIF dbConnection;

	public TeamDAO(DbConnectionIF dbConnection) {
		this.dbConnection = new DbConnectionTest();

	}

	public int createTeam(Team team) throws SQLException {
		String sqlQuery = "INSERT INTO Team (teamId, teamName) " + "VALUES (?, ?)";

		int newTeamId = 0;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, team.getTeamId());
			statement.setString(2, team.getTeamName());

			newTeamId = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newTeamId;
	}

	@Override
	public Team getTeam(int teamId) throws SQLException {
		String sqlQuery = "SELECT * FROM Team " + "WHERE teamId = ?";

		Team foundTeam = null;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, teamId);

			statement.execute();
			ResultSet foundTeams = statement.getResultSet();

			foundTeams.next();
			int foundTeamId = foundTeams.getInt(1);
			String foundTeamName = foundTeams.getString(2);
			foundTeam = new Team(foundTeamId, foundTeamName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundTeam;
	}

	@Override
	public List<Team> getTeamsFromMatch(int matchId) throws SQLException {

		MatchRoundResultDAOIF matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO();

		return matchRoundResultDAO.getTeamsFromMatch(matchId);
	}

}
