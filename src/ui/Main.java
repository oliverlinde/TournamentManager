package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	private JFrame frmTurneringsmanager;
	private JPanel loginUI;

	private enum UIPanel {
		loginUI, mainMenuUI
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmTurneringsmanager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		updateUI(UIPanel.mainMenuUI);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTurneringsmanager = new JFrame();

		frmTurneringsmanager.setTitle("Turneringsmanager");
		frmTurneringsmanager.setBounds(100, 100, 721, 425);
		frmTurneringsmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void createActions() {
		
		
	}

	private void updateUI(UIPanel ui) {
		switch (ui) {

		case mainMenuUI: {
			frmTurneringsmanager.getContentPane().add(UIFactory.createMainMenuUI());
		}

		default: {
			loginUI = UIFactory.createLoginUI();
			createActions();
			frmTurneringsmanager.getContentPane().add(loginUI);
		}
		}
	}
	

}
