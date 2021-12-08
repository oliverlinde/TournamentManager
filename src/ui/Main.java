package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.PersonController;
import controller.PersonControllerIF;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frmTurneringsmanager;
	private JFrame loginUI;
	private JPanel loginPanel;
	private static Main window;
	private JMenuItem activeTournamentsMenuItem;
	private JMenuItem createTournamentMenuItem;
	private JMenuItem createTournamentRuleMenuItem;
	private JMenuItem teamsMenuItem;
	private JMenuItem personMenuItem;
	private JPanel mainPnl;
	private JPanel updatedPanel;
	private JButton loginBtn;
	private JTextField idTextField;

	private enum Frame {
		loginFrame, mainFrame
	};

	private enum UIPanel {
		mainPanel, createTournamentPanel, createTournamentRulePanel, teamsMenuPanel, personMenuPanel
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Main();
					window.loginUI.setVisible(true);
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
		updateUIFrame(Frame.loginFrame);

//		updateUIPanel(UIPanel.loginUI);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		loginUI = new JFrame();
		loginUI.setTitle("Turneringsmanager");
		loginUI.setBounds(100, 100, 721, 425);
		loginUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createLoginUIFrame();

//		frmTurneringsmanager = new JFrame();
//
//		frmTurneringsmanager.setTitle("Turneringsmanager");
//		frmTurneringsmanager.setBounds(100, 100, 721, 425);
//		frmTurneringsmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		updateUIPanel(UIPanel.loginUI);

	}

	private void createLoginUIFrame() {
		loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginUI.getContentPane().add(loginPanel);

		JPanel panel_2 = new JPanel();
		loginPanel.add(panel_2);

		JLabel loginLbl = new JLabel("Login");
		loginLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(loginLbl);

		JPanel panel_3 = new JPanel();
		loginPanel.add(panel_3);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));

		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);

		JLabel idLbl = new JLabel("Intast Id");
		panel_7.add(idLbl);
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);

		idTextField = new JTextField();
		panel_5.add(idTextField);
		idTextField.setColumns(20);

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);

		loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!idTextField.getText().isEmpty()) {
					if (loginVerified(idTextField)) {
						window.loginUI.dispose();
						updateUIFrame(Frame.mainFrame);
					} else {
						JOptionPane.showMessageDialog(loginUI, "Id " + idTextField.getText() + " findes ikke", "Ugyldigt id", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(loginUI, "Indtast id", "Ugyldigt input", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		panel_6.add(loginBtn);

	}

	private boolean loginVerified(JTextField loginCridentials) {
		PersonControllerIF personController = new PersonController();
		return personController.verifyPerson(Integer.parseInt(loginCridentials.getText()));
	}

	private void createMainMenuUIFrame() {
		JPanel mainMenuUI = new JPanel();
		mainMenuUI.setLayout(new BorderLayout(0, 0));

		JPanel menuBarPnl = new JPanel();
		mainMenuUI.add(menuBarPnl, BorderLayout.NORTH);
		menuBarPnl.setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		menuBarPnl.add(menuBar);

		JMenu filesMenu = new JMenu("Filer");
		menuBar.add(filesMenu);

		JMenu helpMenu = new JMenu("Hj\u00E6lp");
		menuBar.add(helpMenu);

		JPanel menuPnl = new JPanel();
		menuPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainMenuUI.add(menuPnl, BorderLayout.WEST);
		menuPnl.setLayout(new BoxLayout(menuPnl, BoxLayout.Y_AXIS));

		activeTournamentsMenuItem = new JMenuItem("Aktive turneringer");
		menuPnl.add(activeTournamentsMenuItem);

		createTournamentMenuItem = new JMenuItem("Opret turnering");
		menuPnl.add(createTournamentMenuItem);

		createTournamentRuleMenuItem = new JMenuItem("Opret turneringsregel");
		menuPnl.add(createTournamentRuleMenuItem);

		teamsMenuItem = new JMenuItem("Hold menu");
		menuPnl.add(teamsMenuItem);

		personMenuItem = new JMenuItem("Person");
		menuPnl.add(personMenuItem);

		JPanel panel_2 = new JPanel();
		menuPnl.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel personNamePnl = new JPanel();
		panel_2.add(personNamePnl, BorderLayout.SOUTH);

		JPanel personPicPnl = new JPanel();
		panel_2.add(personPicPnl, BorderLayout.CENTER);

		mainPnl = new JPanel();
		mainMenuUI.add(mainPnl, BorderLayout.CENTER);

		frmTurneringsmanager.add(mainMenuUI);
		createActions();
		updateUIPanel(UIPanel.mainPanel);

	}

	private void updateUIPanel(UIPanel uiPanel) {
		if (uiPanel.equals(UIPanel.mainPanel)) {
			if (updatedPanel == null) {
				updatedPanel = UIFactory.createHomeScreenUI();
				mainPnl.add(updatedPanel);
			} else {
				mainPnl.remove(updatedPanel);
				updatedPanel = UIFactory.createHomeScreenUI();
				mainPnl.add(updatedPanel);
				mainPnl.updateUI();
			}
		} else if (uiPanel.equals(UIPanel.teamsMenuPanel)) {
			mainPnl.remove(updatedPanel);
			updatedPanel = UIFactory.createTeamMenuUI();
			mainPnl.add(updatedPanel);
			mainPnl.updateUI();
		} else if (uiPanel.equals(UIPanel.createTournamentPanel)) {
			mainPnl.remove(updatedPanel);
			updatedPanel = UIFactory.createCreateTournamentUI();
			mainPnl.add(updatedPanel);
			mainPnl.updateUI();
		} else if (uiPanel.equals(UIPanel.createTournamentRulePanel)) {
			mainPnl.remove(updatedPanel);
			updatedPanel = UIFactory.createTournamentRuleUI();
			mainPnl.add(updatedPanel);
			mainPnl.updateUI();
		} else if (uiPanel.equals(UIPanel.personMenuPanel)) {
			mainPnl.remove(updatedPanel);
			updatedPanel = UIFactory.createPersonMenuUI();
			mainPnl.add(updatedPanel);
			mainPnl.updateUI();
		}
	}

	private void updateUIFrame(Frame frame) {

		if (frame.equals(Frame.mainFrame)) {
			frmTurneringsmanager = new JFrame();
			frmTurneringsmanager.setTitle("Turneringsmanager");
			frmTurneringsmanager.setBounds(100, 100, 721, 425);
			frmTurneringsmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.frmTurneringsmanager.setVisible(true);
			createMainMenuUIFrame();
		} else {
			createLoginUIFrame();

		}
	}

	private void createActions() {
		activeTournamentsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUIPanel(UIPanel.mainPanel);
			}
		});

		createTournamentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUIPanel(UIPanel.createTournamentPanel);
			}
		});

		createTournamentRuleMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUIPanel(UIPanel.createTournamentRulePanel);
			}
		});

		teamsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUIPanel(UIPanel.teamsMenuPanel);
			}
		});

		personMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUIPanel(UIPanel.personMenuPanel);
			}
		});

	}

}
