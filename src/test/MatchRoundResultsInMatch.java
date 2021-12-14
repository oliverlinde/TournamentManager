package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.MatchController;
import controller.MatchControllerIF;
import model.Match;
import model.Team;

class MatchRoundResultsInMatch {

	static MatchControllerIF matchController;

	@Test
	void test() {
		//Arrange
		matchController = new MatchController();

		List<Team> teams = new LinkedList<>();
		Team team1 = new Team(1, "Test team 1");
		teams.add(team1);
		teams.add(new Team(2, "Test team 2"));
		teams.add(new Team(3, "Test team 3"));
		teams.add(new Team(4, "Test team 4"));
		teams.add(new Team(5, "Test team 5")); 
		teams.add(new Team(6, "Test team 6"));
		teams.add(new Team(7, "Test team 7"));
		teams.add(new Team(8, "Test team 8")); 

		// Act
		List<Match> listOfMatches = matchController.generateMatches(3, teams);
//		listOfMatches.forEach((Match) -> Match.getListOfMatchRounds().get(0).setWinner(Match.getListOfTeams().get(0)));
//		listOfMatches.forEach((Match) -> Match.getListOfMatchRounds().get(1).setWinner(Match.getListOfTeams().get(1)));
		
		//assertEquals(team1.getTeamId(), listOfMatches.get(0).getListOfTeams().get(0).getTeamId());
	}

}
