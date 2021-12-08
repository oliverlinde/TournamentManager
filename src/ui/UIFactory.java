package ui;

import javax.swing.JPanel;

public class UIFactory {
	
	public static JPanel createLoginUI() {
		return new LoginUI();
	}
	
	public static JPanel createHomeScreenUI() {
		return new HomeScreen();
	}
	
	public static JPanel createMainMenuUI() {
		return new MainMenuUI();
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
}
