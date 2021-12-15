package controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import dao.DAOFactory;
import dao.TournamentDAOIF;
import model.Format;
import model.Team;
import model.Tournament;
import model.TournamentRule;

public class TournamentController implements TournamentControllerIF {
	private Tournament tournament;
	private TournamentDAOIF tournamentDAO;
	private TournamentRuleControllerIF tournamentRuleController;
	private GenerateBracketStrategyIF generateBracketStrategy;
	public TournamentController(TournamentDAOIF tournamentDAO) {
		this.tournamentDAO = tournamentDAO;

	}

	@Override
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	@Override
	public Tournament createTournament() {
		tournament = new Tournament();
		return tournament;
	}

	@Override
	public void setTournamentName(String tournamentName) {
		tournament.setTournamentName(tournamentName);
	}

	@Override
	public String getTournamentName() {
		return tournament.getTournamentName();
	}

	@Override
	public void setGameName(String gameName) {
		tournament.setGameName(gameName);
	}

	@Override
	public String getGameName() {
		return tournament.getGameName();
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

	// Save the Tournament object to database with the primitive data
	@Override
	public boolean confirmTournament() {
		boolean passed = false;
		try {
			int rowsAffected = tournamentDAO.createTournament(tournament);
			if (rowsAffected == 1) {
				passed = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passed;
	}

	// Save the generated Tournament to the database with all information
	@Override
	public boolean saveTournamentToDatabase() {
		boolean passed = false;
		try {
			tournamentDAO.updateTournament(tournament);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passed;
	}

	@Override
	public TournamentRule getTournamentRule() {
		return tournament.getTournamentRule();
	}

	@Override
	public void setTournamentRule(TournamentRule tournamentRule) {
		tournament.setTournamentRule(tournamentRule);
	}

	@Override
	public void setGenerateBracketStrategy() {
		switch (tournament.getTournamentRule().getFormat().toString()) {
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
			e.printStackTrace();
		}
		return listOfTournament;
	}

	@Override
	public List<TournamentRule> getAllTournamentRules() {
		tournamentRuleController = new TournamentRuleController(DAOFactory.createTournamentRuleDAO());
		return tournamentRuleController.getAllTournamentRule();
	}

	@Override
	public Tournament getTournamentById(int tournamentId) {
		try {
			tournament = tournamentDAO.getTournament(tournamentId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tournament;

	}

	@Override
	public void initializeTournament() {
		setGenerateBracketStrategy();
		tournament.addBracket(generateBracketStrategy.initializeTournament(tournament));
	}

	@Override
	public Tournament getTournament() {
		return tournament;
	}

	@Override
	public GenerateBracketStrategyIF getStrategy() {
		return generateBracketStrategy;
	}

}
