package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Team;

class TeamTest {

	private Team team;
	private List<Team> teams;
	
	@Test
	void testTeamName() {
		//Arrange
		team = new Team(1);
		
		//Act
		team.setTeamName("Mortens hold");
			
		//Assert
		assertEquals(team.getTeamName(), "Mortens hold");
	}
	
	
	
		

}
