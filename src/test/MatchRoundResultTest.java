package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.MatchRoundResult;
import model.Team;

class MatchRoundResultTest {
	
	

	@Test
	void teamSetAsWinnerTest() {
		
		//Arrange
		MatchRoundResult matchRoundResult = new MatchRoundResult(1);
		Team team1 = new Team(1, "Test team");

		//Act
		matchRoundResult.setWinner(team1);
		
		//Assert
		assertEquals(1, team1.getTeamId());
		
	}
	
	

}
