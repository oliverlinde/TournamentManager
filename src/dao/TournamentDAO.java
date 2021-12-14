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
import model.BracketRound;
import model.Match;
import model.MatchRoundResult;
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

		int tournamentCreated = 0;
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);

		try {

			String insertTournamentSQL = "INSERT INTO Tournament VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insertTournamentStatement = connection.prepareStatement(insertTournamentSQL,
					PreparedStatement.RETURN_GENERATED_KEYS);

			insertTournamentStatement.setInt(1, tournament.getTournamentRule().getTournamentRuleId());
			insertTournamentStatement.setString(2, tournament.getTournamentName());
			insertTournamentStatement.setString(3, tournament.getGameName());
			insertTournamentStatement.setObject(4, tournament.getDateTimeOfEvent());
			insertTournamentStatement.setObject(5, tournament.getRegistrationDeadline());
			insertTournamentStatement.setInt(6, tournament.getMaxNoOfTeams());
			insertTournamentStatement.setInt(7, tournament.getMinNoOfTeams());

			tournamentCreated = insertTournamentStatement.executeUpdate();

			connection.commit();

			if (tournamentCreated == 0) {
				throw new SQLException("Tournament not created");
			}
		} catch (SQLException e) {
			throw new SQLException("Tournament not created");
		} finally {
			connection.setAutoCommit(true);

		}

		System.out.println("Tournament created");
		return tournamentCreated;
	}


	@Override
	public int updateTournament(Tournament tournament) throws SQLException {

		int tournamentCreated = 0;
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);

		try {
			for (int id = 0; id < tournament.getBrackets().size(); id++) {
				Bracket bracket = tournament.getBrackets().get(id);

				String insertIntoBracketSQL = "INSERT INTO Bracket " + "VALUES (?)";
				PreparedStatement insertIntoBracket = connection.prepareStatement(insertIntoBracketSQL,
						PreparedStatement.RETURN_GENERATED_KEYS);

				insertIntoBracket.setInt(1, tournament.getTournamentId());
				int bracketCreated = insertIntoBracket.executeUpdate();

				if (bracketCreated == 0) {
					throw new SQLException("Bracket not created, ID not obtained");
				}
				System.out.println("Bracket created");

				ResultSet bracketIds = insertIntoBracket.getGeneratedKeys();
				if (bracketIds.next()) {
					int bracketId = bracketIds.getInt(1);

					for (int idx = 0; idx < bracket.getBracketRounds().size(); idx++) {
						BracketRound bracketRound = bracket.getBracketRounds().get(idx);

						String insertIntoBracketRoundSQL = "INSERT INTO BracketRound " + "VALUES (?)";
						PreparedStatement insertIntoBracketRound = connection
								.prepareStatement(insertIntoBracketRoundSQL, PreparedStatement.RETURN_GENERATED_KEYS);
						insertIntoBracketRound.setInt(1, bracketId);

						if(insertIntoBracketRound.executeUpdate() == 0) {
							throw new SQLException("Bracketround not created");
						}
						System.out.println("BracketRound created");

						ResultSet bracketRoundIds = insertIntoBracketRound.getGeneratedKeys();
						if (bracketRoundIds.next()) {
							int bracketRoundId = bracketRoundIds.getInt(1);

							for (int idx2 = 0; idx2 < bracketRound.getMatches().size(); idx2++) {
								Match match = bracketRound.getMatches().get(idx2);

								String sqlQuery = "INSERT INTO Match " + "VALUES (?)";
								PreparedStatement statement = connection.prepareStatement(sqlQuery,
										PreparedStatement.RETURN_GENERATED_KEYS);

								statement.setInt(1, bracketRoundId);

								if (statement.executeUpdate() == 0) {
									throw new SQLException("Match not created; id not obtained");
								}
								System.out.println("Match created");
								ResultSet matchIds = statement.getGeneratedKeys();

								if (matchIds.next()) {
									int matchId = matchIds.getInt(1);

									for (int idx3 = 0; idx3 < match.getListOfMatchRounds().size(); idx3++) {
										MatchRoundResult matchRoundResult = match.getListOfMatchRounds().get(idx3);
										for (Team team : match.getListOfTeams()) {
											String insertToMatchRoundResult = "INSERT INTO MatchRoundResult (matchId, teamId) VALUES (?, ?)";
											PreparedStatement insertMatchRoundResult = connection
													.prepareStatement(insertToMatchRoundResult);
											insertMatchRoundResult.setInt(1, matchId);
											insertMatchRoundResult.setInt(2, team.getTeamId());

											if(insertMatchRoundResult.executeUpdate() == 0) {
												throw new SQLException("MatchRoundResult not created");
											}
											System.out.println("MatchRoundResult created");
										}
									}
								}
							}
						}
					}
				}
				connection.commit();
			}

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new SQLException("Tournament not created " + tournament.getTournamentId());
		} finally {
			connection.setAutoCommit(true);
		}

		System.out.println(tournamentCreated);
		return tournamentCreated;
	}

	@Override
	public Tournament getTournament(int tournamentId) throws SQLException {
		TournamentRuleDAOIF tournamentRuleDAO = DAOFactory.createTournamentRuleDAO();
		BracketDAOIF bracketDAO = DAOFactory.createBracketDAO();
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
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO();

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
