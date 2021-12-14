package ui;

import javax.swing.JPanel;

import model.Tournament;

public class UIFactory {
	
	public static JPanel createLoginUI() {
		return new LoginUI();
	}
	
	public static JPanel createHomeScreenUI() {
		return new HomeScreen();
	}
	
	public static JPanel createTeamMenuUI() {
		return new TeamsMenuUI();
	}
	
	public static JPanel createCreateTournamentUI() {
		return new CreateTournamentUI();
	}
	
	public static JPanel createTournamentRuleUI() {
		return new CreateTournamentRuleUI();
	}
	
	public static JPanel createPersonMenuUI() {
		return new PersonMenuUI();
	}
	
	public static JPanel createCreateTeamMenuUI() {
		return new CreateTeamUI();
	}
	
	public static JPanel createCreatePersonMenuUI() {
		return new CreatePersonUI();
	}
	
	public static JPanel createTournamentProgressionUI(Tournament tournament) {
		return new TournamentProgressionUI(tournament);
	}
}
