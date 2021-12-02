package controller;

import java.time.LocalDate;
import java.util.List;

import model.Tournament;

public class TournamentController implements TournamentControllerIF {
	private DbConnectionIF dbConnection;
	private Tournament tournament;
	private TournamentDAOIF tournamentDAO;
	private TeamControllerIF teamController;
	private BracketControllerIF bracketController;
	private MatchControllerIF matchController;
	private TournamentRuleControllerIF tournamentRuleController;
	private GenerateBracketStrategyIF generateBracketStrategy;
	
	public TournamentController() {
		bracketController = new BracketController();
		tournamentRuleController = new TournamentRuleController();
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
	public void setRegistrationDeadline(LocalDate registrationDeadline) {
		tournament.setRegistrationDeadline(registrationDeadline);
	}

	@Override
	public LocalDate getRegistrationDeadline() {
		return tournament.getRegistrationDeadline();
	}

	@Override
	public void setDateTimeOfEvent(LocalDate dateTimeOfEvent) {
		tournament.setDateTimeOfEvent(dateTimeOfEvent);
	}

	@Override
	public LocalDate getDateTimeOfEvent() {
		return tournament.getDateTimeOfEvent();
	}

	@Override
	public void setMaxNoOfTeams(int maxNoOfTeams) {
		tournament.setMaxNoOfTeam(maxNoOfTeams);
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
	}

	@Override
	public List<TournamentRule> getTournamentRule() {
		return tournament.getTournamentRule();
	}

	@Override
	public void setTournamentRule(TournamentRule tournamentRule) {
		tournament.setTournamentRule(tournamentRule);
		generateBracketStrategy = tournament.getTournamentRule().getFormat();
	}

	@Override
	public int calculatePoints(TournamentRule tournamentRule) {
		return 0;
	}

	@Override
	public void generateNextBracket() {
		generateBracketStrategy.proceedToNextRound(tournament.getTournamentRule().getFormat());
		
	}

}
