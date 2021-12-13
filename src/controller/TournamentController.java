package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import dao.BracketDAOIF;
import dao.BracketRoundDAOIF;
import dao.BracketRoundResultDAO;
import dao.DAOFactory;
import dao.DbConnection;
import dao.DbConnectionIF;
import dao.MatchDAOIF;
import dao.MatchRoundResultDAOIF;
import dao.TournamentDAOIF;
import model.Bracket;
import model.BracketRound;
import model.BracketRoundResult;
import model.Format;
import model.Match;
import model.MatchRoundResult;
import model.Team;
import model.Tournament;
import model.TournamentRule;

public class TournamentController implements TournamentControllerIF {
	private Tournament tournament;
	private TournamentDAOIF tournamentDAO;
	private BracketDAOIF bracketDAO;
	private BracketRoundDAOIF bracketRoundDAO;
	private MatchDAOIF matchDAO;
	private MatchRoundResultDAOIF matchRoundResultDAO;
	private TournamentRuleControllerIF tournamentRuleController;
	private GenerateBracketStrategyIF generateBracketStrategy;
	private DbConnectionIF dbConnection;

	public TournamentController() {
		dbConnection = new DbConnection();
		tournamentDAO = DAOFactory.createTournamentDAO(dbConnection);
		bracketDAO = DAOFactory.createBracketDAO(dbConnection);
		bracketRoundDAO = DAOFactory.createBracketRoundDAO(dbConnection);
		matchDAO = DAOFactory.createMatchDAO(dbConnection);
		matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO(dbConnection);
		new BracketController();
	}

	@Override
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
		setTournamentRule(getTournamentRule());
	}

	@Override
	public Tournament createTournament() {
		tournament = new Tournament(getNextTournamentId());
		return tournament;
	}

	@Override
	public void setName(String name) {
		tournament.setName(name);
	}

	@Override
	public String getName() {
		return tournament.getName();
	}

	@Override
	public void setGame(String game) {
		tournament.setGame(game);
	}

	@Override
	public String getGame() {
		return tournament.getGame();
	}

	@Override
	public void setRegistrationDeadline(LocalDateTime registrationDeadline) {
		tournament.setRegistrationDeadline(registrationDeadline);
	}

	@Override
	public LocalDateTime getRegistrationDeadline() {
		return tournament.getRegistrationDeadline();
	}

	@Override
	public void setDateTimeOfEvent(LocalDateTime dateTimeOfEvent) {
		tournament.setDateTimeOfEvent(dateTimeOfEvent);
	}

	@Override
	public LocalDateTime getDateTimeOfEvent() {
		return tournament.getDateTimeOfEvent();
	}

	@Override
	public void setMaxNoOfTeams(int maxNoOfTeams) {
		tournament.setMaxNoOfTeams(maxNoOfTeams);
	}

	@Override
	public int getMaxNoOfTeams() {
		return tournament.getMaxNoOfTeams();
	}

	@Override
	public void setMinNoOfTeams(int minNoOfTeams) {
		tournament.setMinNoOfTeams(minNoOfTeams);
	}

	@Override
	public int getMinNoOfTeams() {
		return tournament.getMinNoOfTeams();
	}

	// Save the tournament object to database
	@Override
	public boolean confirmTournament() throws SQLException {
		boolean passed = false;
		Connection connection = dbConnection.getConnection();
		connection.setAutoCommit(false);
		try {
			for (Bracket bracket : tournament.getBrackets()) {
				bracketDAO.createBracket(tournament.getId(), bracket);
				for(BracketRound bracketRound : bracket.getBracketRounds()) {
					bracketRoundDAO.createBracketRound(bracket.getBracketId(), bracketRound);
					for(Match match : bracketRound.getMatches()) {
						matchDAO.createMatch(bracketRound.getBracketRoundID(), match);
						for(Team team : match.getListOfTeams()) {
							for(MatchRoundResult matchRoundResult : match.getListOfMatchRounds()) {
								matchRoundResultDAO.createMatchRoundResult(match.getMatchId(), team.getTeamId(), matchRoundResult);
							}
						}
					}
				}
			}
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			connection.setAutoCommit(true);
		}
		return passed;
	}

	@Override
	public boolean cancelTournament() {
		tournament = null;
		return true;
	}

	@Override
	public TournamentRule getTournamentRule() {
		return tournament.getTournamentRule();
	}

	@Override
	public void setTournamentRule(TournamentRule tournamentRule) {

		switch (tournamentRule.getFormat().toString()) {
		case "SingleElimination":
			generateBracketStrategy = new SingleEliminationStrategy();
			break;
		case "DoubleElimination":
			generateBracketStrategy = new DoubleEliminationStrategy();
			break;
		case "PointsSystem":
			generateBracketStrategy = new PointSystemStrategy();
			break;
		default:
			throw new IllegalArgumentException("Format not found");
		}
	}

	@Override
	public void changeFormat(Object object) {
		Format format = null;

		switch (object.toString()) {
		case "DoubleElimination":
			format = Format.DoubleElimination;
			break;
		case "PointsSystem":
			format = Format.PointsSystem;
			break;
		default:
			format = Format.SingleElimination;
			break;
		}

		tournament.getTournamentRule().setFormat(format);
	}

	@Override
	public int calculatePoints(TournamentRule tournamentRule) {
		return 0;
	}

	@Override
	public void generateNextBracketRound(int noOfRounds) {

	}

	@Override
	public void addTeamToTournament(Team team) {
		tournament.addTeam(team);
	}

	@Override
	public List<Team> getAllTeams() {
		return tournament.getAllTeams();
	}

	@Override
	public List<Tournament> getAllTournaments() {
		List<Tournament> listOfTournament = new LinkedList<>();
		try {
			listOfTournament = tournamentDAO.getAllTournaments();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfTournament;
	}

	@Override
	public List<TournamentRule> getAllTournamentRules() {
		tournamentRuleController = new TournamentRuleController();
		return tournamentRuleController.getAllTournamentRule();
	}

	@Override
	public int getNextTournamentId() {
		int nextTournamentId = 0;
		try {
			nextTournamentId = tournamentDAO.getNextTournamentId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nextTournamentId;
	}

	@Override
	public Tournament getTournamentById(int tournamentId) {
		try {
			tournament = tournamentDAO.getTournament(tournamentId);
			setTournamentRule(tournament.getTournamentRule());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tournament;

	}

	@Override
	public void initializeTournament() {
		tournament.addBracket(generateBracketStrategy.initializeTournament(tournament));
	}

	@Override
	public void removeTeamFromTournament(Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tournament getTournament() {
		return tournament;
	}

}
