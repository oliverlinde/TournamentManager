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
}
