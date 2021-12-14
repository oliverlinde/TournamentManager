package test;

import model.Match;
import model.MatchRoundResult;
import model.Team;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;


class MatchTest {

	// Testing match in best of 3 rounds, resulting in correct winner.
	@Test
	void matchGetCorrectWinnerTest() {
		
		//Arrange
		List<Team> teams = new LinkedList<>();
		teams.add(new Team(1, "Test team 1")); //Winning team
		teams.add(new Team(2, "Test team 2")); //Losing team
		
		List<MatchRoundResult> matchRoundResults = new LinkedList<>();
		
		Match match = new Match(1, matchRoundResults, teams);

		//Team with id = 1 wins
		MatchRoundResult matchRoundResult1 = new MatchRoundResult(1, teams.get(0), teams.get(1), false);
		//Team with id = 2 wins
		MatchRoundResult matchRoundResult2 = new MatchRoundResult(2, teams.get(1), teams.get(0), false);
		//Team with id = 1 wins
		MatchRoundResult matchRoundResult3 = new MatchRoundResult(3, teams.get(0), teams.get(1), false);
		
		int expectedWinningTeamId = teams.get(0).getTeamId();

		//Act
		teams.add(new Team(1, "Test team 1")); //Winning team
		teams.add(new Team(2, "Test team 2")); //Losing team
		matchRoundResults.add(matchRoundResult1);
		matchRoundResults.add(matchRoundResult2);
		matchRoundResults.add(matchRoundResult3);
		
		//Assert
		assertEquals(expectedWinningTeamId, match.getWinner().getTeamId());
	}
	
	@Test
	void matchGetCorrectLoserTest() {
		
		//Arrange
		List<Team> teams = new LinkedList<>();
		teams.add(new Team(1, "Test team 1")); //Winning team
		teams.add(new Team(2, "Test team 2")); //Losing team
		
		
		List<MatchRoundResult> matchRoundResults = new LinkedList<>();
		
		Match match = new Match(1, matchRoundResults, teams);

		//Team with id = 2 loses
		MatchRoundResult matchRoundResult1 = new MatchRoundResult(1, teams.get(0), teams.get(1), false);
		//Team with id = 1 loses
		MatchRoundResult matchRoundResult2 = new MatchRoundResult(2, teams.get(1), teams.get(0), false);
		//Team with id = 2 loses
		MatchRoundResult matchRoundResult3 = new MatchRoundResult(3, teams.get(0), teams.get(1), false);	
		
		int expectedLosingTeamId = teams.get(1).getTeamId();
		
		//Act
		teams.add(new Team(1, "Test team 1")); //Winning team
		teams.add(new Team(2, "Test team 2")); //Losing team
		matchRoundResults.add(matchRoundResult1);
		matchRoundResults.add(matchRoundResult2);
		matchRoundResults.add(matchRoundResult3);
		

	
		//Assert
		assertEquals(expectedLosingTeamId, match.getLoser().getTeamId());
	}
	

}
