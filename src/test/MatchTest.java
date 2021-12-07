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
		teams.add(new Team(1)); //Winning team
		teams.add(new Team(2)); //Losing team
		
		List<MatchRoundResult> matchRoundResults = new LinkedList<>();
		
		Match match = new Match(matchRoundResults, teams);
		
		int expectedWinningTeamId = teams.get(0).getTeamId();
		//Act
		
		//Team with id = 1 wins
		matchRoundResults.add(new MatchRoundResult(teams.get(0), teams.get(1)));
		//Team with id = 2 wins
		matchRoundResults.add(new MatchRoundResult(teams.get(1), teams.get(0)));
		//Team with id = 1 wins
		matchRoundResults.add(new MatchRoundResult(teams.get(0), teams.get(1)));
		
		//Assert
		assertEquals(expectedWinningTeamId, match.getWinner().getTeamId());
	}
	
	@Test
	void matchGetCorrectLoserTest() {
		
		//Arrange
		List<Team> teams = new LinkedList<>();
		teams.add(new Team(1)); //Winning team
		teams.add(new Team(2)); //Losing team
		
		List<MatchRoundResult> matchRoundResults = new LinkedList<>();
		
		Match match = new Match(matchRoundResults, teams);
		
		int expectedLosingTeamId = teams.get(1).getTeamId();
		
		//Act
		
		//Team with id = 2 loses
		matchRoundResults.add(new MatchRoundResult(teams.get(0), teams.get(1)));
		//Team with id = 1 loses
		matchRoundResults.add(new MatchRoundResult(teams.get(1), teams.get(0)));
		//Team with id = 2 loses
		matchRoundResults.add(new MatchRoundResult(teams.get(0), teams.get(1)));
		
		//Assert
		assertEquals(expectedLosingTeamId, match.getLoser().getTeamId());
	}
	

}
