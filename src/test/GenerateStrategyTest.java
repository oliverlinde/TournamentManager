package test;

import org.junit.jupiter.api.Test;

import controller.SingleEliminationStrategy;
import controller.TournamentController;
import controller.TournamentControllerIF;
import dao.DAOFactory;
import model.Format;
import model.NoOfRounds;
import model.Tournament;
import model.TournamentRule;


class GenerateStrategyTest {
	TournamentControllerIF tournamentController;
	
	@Test
	void test() {
		//Arrange
		tournamentController = new TournamentController(DAOFactory.createTournamentDAO());
		TournamentRule tournamentRule = new TournamentRule(1, "", 1, 2, 3, NoOfRounds.BestOfThree, Format.SingleElimination);
		
		//Act
		Tournament tournament = new Tournament();
		tournamentController.setTournament(tournament);
		tournamentController.setTournamentRule(tournamentRule);
		tournamentController.setGenerateBracketStrategy();
		
		
		
		//Assert
		assert(tournamentController.getStrategy() instanceof SingleEliminationStrategy);
			
			
		}
}
