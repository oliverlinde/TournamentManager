package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import model.Bracket;
import model.BracketRound;
import model.Match;
import model.MatchRoundResult;
import model.Team;

public class BracketDAO implements BracketDAOIF {
	private DbConnectionIF dbConnection;

	public BracketDAO(DbConnectionIF dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public List<Bracket> getBracketsFromTournament(int tournamentId) throws SQLException {
		BracketRoundDAOIF bracketRoundDAO = DAOFactory.createBracketRoundDAO();
		List<Bracket> listOFBrackets = new ArrayList<>();

		String sqlQuery = "SELECT bracketId FROM Bracket WHERE tournamentId = ?";

		try {
			Connection connection = dbConnection.getConnection();

			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			statement.setInt(1, tournamentId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				listOFBrackets
						.add(new Bracket(tournamentId, bracketRoundDAO.getBracketRoundsFromBracket(rs.getInt(1))));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOFBrackets;
	}

	@Override
	public int createBracket(int tournamentId, Bracket bracket) throws SQLException {

		int bracketRoundCreated = 0;
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);

		try {

			for (int idx = 0; idx < bracket.getBracketRounds().size(); idx++) {
				BracketRound bracketRound = bracket.getBracketRounds().get(idx);

				String insertIntoBracketRoundSQL = "INSERT INTO BracketRound " + " VALUES (?)";
				PreparedStatement insertIntoBracketRound = connection.prepareStatement(insertIntoBracketRoundSQL,
						PreparedStatement.RETURN_GENERATED_KEYS);
				insertIntoBracketRound.setInt(1, bracket.getBracketId());

				System.out.println("BracketRound created");
				bracketRoundCreated = insertIntoBracketRound.executeUpdate();

				if (bracketRoundCreated == 0) {
					throw new SQLException("BracketRound not created");
				}

				ResultSet bracketRoundIds = insertIntoBracketRound.getGeneratedKeys();
				if (bracketRoundIds.next()) {
					int bracketRoundId = bracketRoundIds.getInt(1);

					for (int idx2 = 0; idx2 < bracketRound.getMatches().size(); idx2++) {
						Match match = bracketRound.getMatches().get(idx2);

						String sqlQuery = "INSERT INTO Match  " + "VALUES (?)";
						PreparedStatement statement = connection.prepareStatement(sqlQuery,
								PreparedStatement.RETURN_GENERATED_KEYS);

						statement.setInt(1, bracketRoundId);

						int matchCreated = statement.executeUpdate();
						System.out.println("Match created");

						if (matchCreated == 0) {
							throw new SQLException("Match not created");
						}
						ResultSet matchIds = statement.getGeneratedKeys();

						if (matchIds.next()) {
							int matchId = matchIds.getInt(1);

							for (int idx3 = 0; idx3 < match.getListOfMatchRounds().size(); idx3++) {
								MatchRoundResult matchRoundResult = match.getListOfMatchRounds().get(idx3);
								for (Team team : match.getListOfTeams()) {
									String insertToMatchRoundResult = "INSERT INTO MatchRoundResult (matchRoundResultId, matchId, teamId) VALUES (?, ?, ?)";
									PreparedStatement insertMatchRoundResult = connection
											.prepareStatement(insertToMatchRoundResult);
									insertMatchRoundResult.setInt(1, matchRoundResult.getMatchRoundResultId());
									insertMatchRoundResult.setInt(2, matchId);
									insertMatchRoundResult.setInt(3, team.getTeamId());

									if(insertMatchRoundResult.executeUpdate() == 0) {
										throw new SQLException("MatchRoundResult not created");
									}

									System.out.println("MatchRoundResult created");
								}
							}
						}
						connection.commit();
						System.out.println("Match created");
					}
				}
			}

			connection.commit();
			System.out.println("Bracket created");

		} catch (

		SQLException e) {
			connection.rollback();
			e.printStackTrace();
			throw new SQLException("Bracket not created " + bracket.getBracketId());
		} finally {
			connection.setAutoCommit(true);
		}
		return bracketRoundCreated;
	}
}
