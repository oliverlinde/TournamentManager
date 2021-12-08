package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import dao.DAOFactory;
import dao.DbConnection;
import dao.DbConnectionIF;
import dao.TournamentDAOIF;
import dao.TournamentRuleDAOIF;
import model.Format;
import model.Team;
import model.Tournament;
import model.TournamentRule;

public class TournamentController implements TournamentControllerIF {
	private Tournament tournament;
	private TournamentDAOIF tournamentDAO;
	private TeamControllerIF teamController;
	private BracketControllerIF bracketController;
	private MatchControllerIF matchController;
	private TournamentRuleControllerIF tournamentRuleController;
	private GenerateBracketStrategyIF generateBracketStrategy;

	public TournamentController() {
		tournamentDAO = DAOFactory.createTournamentDAO(new DbConnection());
		// bracketController = new BracketController(dbConnection);
		// tournamentRuleController = new TournamentRuleController(dbConnection);
	}

	@Override
	public Tournament createTournament() {
		tournament = new Tournament();
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

	// Save the tournament object to database
	@Override
	public boolean confirmTournament() {
		return false;
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
		tournament.setTournamentRule(tournamentRule);
		String format = tournament.getTournamentRule().getFormat().toString();

		switch (format) {
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
	public void generateNextBracket(int noOfRounds) {
		bracketController.createBracketRound(tournament.getAllTeams(), generateBracketStrategy, noOfRounds);
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

}
