package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.TeamController;
import controller.TeamControllerIF;
import controller.TournamentController;
import controller.TournamentControllerIF;
import controller.TournamentRuleController;
import controller.TournamentRuleControllerIF;
import dao.DAOFactory;
import model.Match;

public class SaveTournamentToDBTest {
	private TournamentControllerIF tournamentController;
	private TeamControllerIF teamController;
	private TournamentRuleControllerIF tournamentRuleController;

	public SaveTournamentToDBTest() {
		// Arrange
		tournamentController = new TournamentController(DAOFactory.createTournamentDAO());
		teamController = new TeamController(DAOFactory.createTeamDAO());
		tournamentRuleController = new TournamentRuleController(DAOFactory.createTournamentRuleDAO());

		tournamentController.createTournament();
		// Act
		tournamentController.setTournamentName("Test tournament");
		tournamentController.setGameName("League of legends");
		LocalDate localDate = LocalDate.of(2022, 02, 12);
		LocalTime localTime = LocalTime.of(12, 00);
		tournamentController.setRegistrationDeadline(LocalDateTime.of(localDate, localTime));
		LocalDate localDate1 = LocalDate.of(2022, 03, 12);
		LocalTime localTime1 = LocalTime.of(12, 00);
		tournamentController.setDateTimeOfEvent(LocalDateTime.of(localDate1, localTime1));
		tournamentController.setMaxNoOfTeams(16);
		tournamentController.setMinNoOfTeams(8);
		tournamentController.setTournamentRule(tournamentRuleController.getAllTournamentRule().get(1));

	}

	@Test
	void teamsNotExceedingMaxTest() {
		// Act
		int noOfTeamsToParticipate = 17;
		for (int i = 1; i < noOfTeamsToParticipate + 1; i++) {
			tournamentController.addTeamToTournament(teamController.getTeam(i));
		}

		// Assert
		assertNotEquals(17, tournamentController.getAllTeams().size());
	}

	@Test
	void testMaxNoOfTeamsEqualsMaxNoOfTeams() {
		// Act
		int noOfTeamsToParticipate = 17;
		for (int i = 1; i < noOfTeamsToParticipate + 1; i++) {
			tournamentController.addTeamToTournament(teamController.getTeam(i));
		}

		// Assert
		assertEquals(16, tournamentController.getAllTeams().size());
	}

	@Test
	void confirmTournamentSaveToDatabase() {
		// Act
		tournamentController.confirmTournament();

		// Assert

		int index = tournamentController.getAllTournaments().size() - 1;

		assertEquals(tournamentController.getTournament().getTournamentName(),
				(tournamentController
						.getTournamentById(tournamentController.getAllTournaments().get(index).getTournamentId())
						.getTournamentName()));
		assertEquals(tournamentController.getTournament().getGameName(),
				(tournamentController
						.getTournamentById(tournamentController.getAllTournaments().get(index).getTournamentId())
						.getGameName()));
		assertEquals(tournamentController.getTournament().getDateTimeOfEvent(),
				(tournamentController
						.getTournamentById(tournamentController.getAllTournaments().get(index).getTournamentId())
						.getDateTimeOfEvent()));
		assertEquals(tournamentController.getTournament().getRegistrationDeadline(),
				(tournamentController
						.getTournamentById(tournamentController.getAllTournaments().get(index).getTournamentId())
						.getRegistrationDeadline()));
		assertEquals(tournamentController.getTournament().getMaxNoOfTeams(),
				(tournamentController
						.getTournamentById(tournamentController.getAllTournaments().get(index).getTournamentId())
						.getMaxNoOfTeams()));
	}

	@Test
	void generateTournamentSaveToDatabase() {
		// Act - Save tournament to Database and retrieve from Database
		tournamentController.confirmTournament();
		int index = tournamentController.getAllTournaments().size() - 1;
		tournamentController.getTournamentById(tournamentController.getAllTournaments().get(index).getTournamentId());

		// Act - Add list of teams
		int noOfTeamsToParticipate = 8;
		for (int i = 1; i < noOfTeamsToParticipate + 1; i++) {
			tournamentController.addTeamToTournament(teamController.getTeam(i));
		}

		// Act - initialize tournament
		tournamentController.initializeTournament();
		List<Match> listOfMatches = tournamentController.getTournament().getBrackets().get(0).getBracketRounds().get(0).getMatches();
		
		// Act
		tournamentController.saveTournamentToDatabase();
		
		//Assert
		int noOfMatchRounds = 0;
		for(Match match : listOfMatches) {
			noOfMatchRounds += match.getRoundResults().size();
		}
		assertEquals(1, tournamentController.getTournament().getBrackets().size());
		assertEquals(1, tournamentController.getTournament().getBrackets().get(0).getBracketRounds().size());
		assertEquals(4, tournamentController.getTournament().getBrackets().get(0).getBracketRounds().get(0).getMatches().size());
		assertEquals(12, noOfMatchRounds);
	}

}
