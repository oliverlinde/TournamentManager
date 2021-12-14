package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Bracket;
import model.Team;
import model.Tournament;
import model.TournamentRule;

public class TournamentDAO implements TournamentDAOIF {
	private DbConnectionIF dbConnection;

	public TournamentDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;

	}

	@Override
	public int createTournament(Tournament tournament) throws SQLException {
		String sqlQuery = "INSERT INTO Tournament VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

		int tournamentCreated = 0;
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);

		try {

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, tournament.getId());
			statement.setInt(2, tournament.getTournamentRule().getTournamentRuleId());
			statement.setString(3, tournament.getName());
			statement.setString(4, tournament.getGame());
			statement.setObject(5, tournament.getDateTimeOfEvent());
			statement.setObject(6, tournament.getRegistrationDeadline());
			statement.setInt(7, tournament.getMaxNoOfTeams());
			statement.setInt(8, tournament.getMinNoOfTeams());

			tournamentCreated = statement.executeUpdate();

			connection.commit();
			
			BracketDAOIF bracketDAO = DAOFactory.createBracketDAO(dbConnection);
			for (Bracket b : tournament.getBrackets()) {
				bracketDAO.createBracket(tournament.getId(), b);
			}

			

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new SQLException("Tournament not created " + tournament.getId());
		} finally {
			connection.setAutoCommit(true);
		}

		return tournamentCreated;

	}
	
	@Override
	public int updateTournament(Tournament tournament) throws SQLException {
		String sqlQuery = "UPDATE Tournament "
				+ "SET tournamentRuleId= ?, "
				+ "tournamentName = ?, "
				+ "gameName = ?, "
				+ "dateTimeOfEvent = ?, "
				+ "registrationDeadline = ?, "
				+ "maxNoOfTeams = ?, "
				+ "minNoOfTeams = ? "
				+ "WHERE tournamentId = ? ";

		int tournamentCreated = 0;
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);

		try {

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, tournament.getTournamentRule().getTournamentRuleId());
			statement.setString(2, tournament.getName());
			statement.setString(3, tournament.getGame());
			statement.setObject(4, tournament.getDateTimeOfEvent());
			statement.setObject(5, tournament.getRegistrationDeadline());
			statement.setInt(6, tournament.getMaxNoOfTeams());
			statement.setInt(7, tournament.getMinNoOfTeams());
			statement.setInt(8, tournament.getId());

			statement.execute();

			connection.commit();
			System.out.println("Tournament created");


		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new SQLException("Tournament not created " + tournament.getId());
		} finally {
			connection.setAutoCommit(true);
		}
		return tournamentCreated;
	}

	@Override
	public Tournament getTournament(int tournamentId) throws SQLException {
		TournamentRuleDAOIF tournamentRuleDAO = DAOFactory.createTournamentRuleDAO(dbConnection);
		BracketDAOIF bracketDAO = DAOFactory.createBracketDAO(dbConnection);
		TournamentRule tournamentRule;

		String sqlQuery = "SELECT * FROM Tournament " + " WHERE tournamentId = ?";

		Tournament tournament = null;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, tournamentId);

			ResultSet rs = statement.executeQuery();

			rs.next();

			int tournamentRuleId = rs.getInt(2);
			String tournamentName = rs.getString(3);
			String tournamentGame = rs.getString(4);
			LocalDateTime timeOfEvent = rs.getObject(5, LocalDateTime.class);
			LocalDateTime registrationDeadline = rs.getObject(6, LocalDateTime.class);
			int maxTeams = rs.getInt(7);
			int minTeams = rs.getInt(8);

			tournamentRule = tournamentRuleDAO.getTournamentRule(tournamentRuleId);

			tournament = new Tournament(tournamentId, tournamentRule, tournamentName, tournamentGame, timeOfEvent,
					registrationDeadline, maxTeams, minTeams);
			tournament.setBrackets(bracketDAO.getBracketsFromTournament(tournamentId));
			tournament.setAllTeams(getTeamsInTournament(tournamentId));

		} catch (Exception e) {

			e.printStackTrace();
		}

		return tournament;
	}

	@Override
	public List<Team> getTeamsInTournament(int tournamentId) throws SQLException {
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO(dbConnection);

		List<Team> teamsInTournament = new ArrayList<>();
		String sqlQuery = "SELECT teamId FROM TeamInTournament " + "WHERE tournamentId = ?";

		Team foundTeam = null;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, tournamentId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				foundTeam = teamDAO.getTeam(rs.getInt(1));
				teamsInTournament.add(foundTeam);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return teamsInTournament;
	}

	@Override
	public List<Tournament> getAllTournaments() throws SQLException {
		String sqlQuery = "SELECT tournamentId, tournamentName, gameName, dateTimeOfEvent, registrationDeadline, maxNoOfTeams, minNoOfTeams "
				+ "FROM Tournament ";

		List<Tournament> listOfTournaments = new LinkedList<>();

		try {
			Connection connection = dbConnection.getConnection();

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				LocalDateTime timeOfEvent = rs.getObject(4, LocalDateTime.class);
				LocalDateTime registrationDeadline = rs.getObject(5, LocalDateTime.class);

				Tournament tournament = new Tournament(rs.getInt(1), rs.getString(2), rs.getString(3), timeOfEvent,
						registrationDeadline, rs.getInt(6), rs.getInt(7));
				listOfTournaments.add(tournament);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return listOfTournaments;
	}

	@Override
	public int getNextTournamentId() throws SQLException {
		String sqlQuery = "SELECT tournamentId FROM Tournament "
				+ "WHERE tournamentId = (SELECT MAX(tournamentId) FROM Tournament)";
		int nextTournamentId = 0;

		try {
			Connection connection = dbConnection.getConnection();

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet rs = statement.executeQuery();
			rs.next();
			nextTournamentId = rs.getInt(1);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return nextTournamentId + 1;
	}

}
