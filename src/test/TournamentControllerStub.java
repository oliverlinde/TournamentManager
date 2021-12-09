package test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import controller.BracketController;
import controller.BracketControllerIF;
import controller.DoubleEliminationStrategy;
import controller.GenerateBracketStrategyIF;
import controller.MatchController;
import controller.MatchControllerIF;
import controller.PointSystemStrategy;
import controller.SingleEliminationStrategy;
import controller.TeamControllerIF;
import controller.TournamentControllerIF;
import controller.TournamentRuleController;
import controller.TournamentRuleControllerIF;
import dao.DbConnectionIF;
import dao.TournamentDAOIF;
import model.Bracket;
import model.Format;
import model.Match;
import model.Team;
import model.Tournament;
import model.TournamentRule;

public class TournamentControllerStub implements TournamentControllerIF {
	private DbConnectionIF dbConnection;
	private Tournament tournament;
	private TournamentDAOIF tournamentDAO;
	private TeamControllerIF teamController;
	private BracketControllerIF bracketController;
	private MatchControllerIF matchController;
	private TournamentRuleControllerStub tournamentRuleController;
	private GenerateBracketStrategyIF generateBracketStrategy;

	public TournamentControllerStub() {
		bracketController = new BracketController(dbConnection);
		tournamentRuleController = new TournamentRuleControllerStub(dbConnection);
		matchController = new MatchController();
	}

	@Override
	public Tournament createTournament() {
		try {
			tournament = new Tournament(tournamentDAO.getNextTournamentId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setName("Test Tournament");
		setGame("CS:GO");
		setRegistrationDeadline(LocalDateTime.now());
		setDateTimeOfEvent(LocalDateTime.now());
		setMaxNoOfTeams(16);
		setTournamentRule(tournamentRuleController.getTournamentRule());
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
	public int calculatePoints(TournamentRule tournamentRule) {
		return 0;
	}

	@Override
	public void generateNextBracket(int noOfRounds) {
		if(bracketController.getBracket() == null) {
			setBracket();
		}
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
	
	public List<Match> getMatches() {
		return bracketController.getAllMatches();
	}
	
	public Bracket getBracket() {
		return bracketController.getBracket();
	}
	
	public void setBracket() {
		bracketController.createBracket(getAllTeams());
	}

	@Override
	public List<Tournament> getAllTournaments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TournamentRule> getAllTournamentRules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeFormat(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMinNoOfTeams(int minNoOfTeams) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMinNoOfTeams() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNextTournamentId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tournament getTournamentById(int tournamentId) {
		// TODO Auto-generated method stub
		return null;
	}

}