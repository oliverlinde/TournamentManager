package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import model.Team;
import model.Tournament;

class TournamentTest {
	private Tournament tournament;
	
	public TournamentTest() {
		//Arrange
		tournament = new Tournament(1);
		
		//Act
		tournament.setTournamentName("Test tournament");
		tournament.setGameName("League of legends");
		LocalDate localDate = LocalDate.of(2022, 02, 12);
		LocalTime localTime = LocalTime.of(12, 00);
		tournament.setRegistrationDeadline(LocalDateTime.of(localDate, localTime));
		LocalDate localDate1 = LocalDate.of(2022, 03, 12);
		LocalTime localTime1 = LocalTime.of(12, 00);
		tournament.setDateTimeOfEvent(LocalDateTime.of(localDate1, localTime1));
		tournament.setMaxNoOfTeams(16);
		tournament.setMinNoOfTeams(8);
		
		int noOfTeamsToParticipate = 17;
		
		for (int i = 0; i < noOfTeamsToParticipate; i++) {
			Team team = new Team(i, "Test team " + i);
			tournament.addTeam(team);
			
		}
		
		
	}
	
	@Test
	void dateTimeTest() {
		//Assert
		assertEquals("2022-02-12T12:00", tournament.getRegistrationDeadline().toString());
	}
	@Test
	void gameNameTest() {
		//Assert
		assertEquals("League of legends", tournament.getGameName());
	}
	
	@Test
	void teamsAssignedToTournamentTest() {
		//Assert
		assertEquals(16, tournament.getAllTeams().size());
	}
	
	@Test
	void teamsNotExceedingMaxTest() {
		//Assert
		assertNotEquals(17, tournament.getAllTeams().size());
	}
	
	

}
