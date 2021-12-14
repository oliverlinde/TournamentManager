package test;

import java.sql.SQLException;

import controller.TeamController;
import controller.TeamControllerIF;
import controller.TournamentController;
import controller.TournamentControllerIF;
import controller.TournamentRuleController;
import controller.TournamentRuleControllerIF;
import dao.DAOFactory;
import dao.TeamDAOIF;
import dao.TournamentRuleDAOIF;
import model.Team;

public class DBTest {

	public static void main(String[] args) throws SQLException {
		TournamentControllerIF tournamentController = new TournamentController(DAOFactory.createTournamentDAO());
		TournamentRuleControllerIF tournamentRuleController = new TournamentRuleController(DAOFactory.createTournamentRuleDAO());
		TeamControllerIF teamController = new TeamController(DAOFactory.createTeamDAO());
		TeamDAOIF teamDAO = DAOFactory.createTeamDAO();
		TournamentRuleDAOIF tournamentRuleDAO = DAOFactory.createTournamentRuleDAO();
		
		tournamentController.createTournament();
		tournamentController.setTournamentName("New Test");
		tournamentController.setGameName("New Test");
		tournamentController.setTournamentRule(tournamentRuleDAO.getTournamentRule(3));
		tournamentController.setMaxNoOfTeams(16);
		tournamentController.getTournament().setTournamentId(13);
		
		tournamentController.addTeamToTournament(teamController.getTeam(1));
		tournamentController.addTeamToTournament(teamController.getTeam(2));
		tournamentController.addTeamToTournament(teamController.getTeam(3));
		tournamentController.addTeamToTournament(teamController.getTeam(4));
		
		tournamentController.initializeTournament();
		tournamentController.saveToDatabase();
	}
}
