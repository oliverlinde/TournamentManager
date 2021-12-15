package test;

import java.sql.SQLException;
import java.time.LocalDateTime;

import controller.TeamController;
import controller.TeamControllerIF;
import controller.TournamentController;
import controller.TournamentControllerIF;
import controller.TournamentRuleController;
import controller.TournamentRuleControllerIF;
import dao.DAOFactory;
import dao.TournamentRuleDAOIF;

public class DBTest {

	public static void main(String[] args) throws SQLException {
		TournamentControllerIF tournamentController = new TournamentController(DAOFactory.createTournamentDAO());
		TournamentRuleControllerIF tournamentRuleController = new TournamentRuleController(DAOFactory.createTournamentRuleDAO());
		TeamControllerIF teamController = new TeamController(DAOFactory.createTeamDAO());
		TournamentRuleDAOIF tournamentRuleDAO = DAOFactory.createTournamentRuleDAO();
		
		tournamentController.createTournament();
		tournamentController.setTournamentName("New Test");
		tournamentController.setGameName("New Test");
		tournamentController.setTournamentRule(tournamentRuleDAO.getTournamentRule(1));
		tournamentController.setMaxNoOfTeams(16);
		tournamentController.setDateTimeOfEvent(LocalDateTime.now());
		tournamentController.setRegistrationDeadline(LocalDateTime.now());
		tournamentController.confirmTournament();
		int index = tournamentController.getAllTournaments().size()-1;
		
		tournamentController.getTournamentById(tournamentController.getAllTournaments().get(index).getTournamentId());
		
		tournamentController.addTeamToTournament(teamController.getTeam(1));
		tournamentController.addTeamToTournament(teamController.getTeam(2));

		tournamentController.initializeTournament();
		tournamentController.saveTournamentToDatabase();
		
		
	}
}
