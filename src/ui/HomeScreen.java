package ui;

import model.Team;
import model.Tournament;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import controller.TeamController;
import controller.TournamentController;
import controller.TournamentControllerIF;
import dao.DAOFactory;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class HomeScreen extends JPanel {
	private TournamentControllerIF tournamentController;
	private JList<Tournament> listOfTournaments;
	private JScrollPane scrollPane;
	private JButton showTournamentBtn;
	private JPanel panel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton initialize32;
	private JButton initialize16;
	private JButton initialize8;

	/**
	 * Create the panel.
	 */
	public HomeScreen() {
		new TeamController(DAOFactory.createTeamDAO());
		tournamentController = new TournamentController(DAOFactory.createTournamentDAO());
		generateTournamentListView();
		
		setLayout(new BorderLayout(0, 0));
		panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.setPreferredSize(new Dimension(1200, 500));
		add(panel);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.NORTH);
		
		JLabel activeTournamentsLbl = new JLabel("Aktive turneringer");
		activeTournamentsLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(activeTournamentsLbl);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		initialize8 = new JButton("Initialis\u00E9r 8");

		panel_1.add(initialize8);
		
		initialize16 = new JButton("Initialis\u00E9r 16");

		panel_1.add(initialize16);
		
		initialize32 = new JButton("Initialis\u00E9r 32");
		
		panel_1.add(initialize32);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton editTournamentBtn = new JButton("Redig\u00E9r turnering");
		panel_2.add(editTournamentBtn);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		showTournamentBtn = new JButton("Vis turneringsforl\u00F8b");

		panel_3.add(showTournamentBtn);
		
		JPanel panel_6 = new JPanel();
		add(panel_6, BorderLayout.WEST);
		
		createActions();

	}
	
	private void generateTournamentListView() {
		DefaultListModel<Tournament> listModel = new DefaultListModel<>();
		
		
		for (Tournament tournament : tournamentController.getAllTournaments()) {
			listModel.addElement(tournament);
			
		}
		listOfTournaments = new JList<>(listModel);
		listOfTournaments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOfTournaments.setCellRenderer(new TournamentListCellRenderer());
		scrollPane = new JScrollPane(listOfTournaments);
	}
	
	private void createActions() {
		showTournamentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel parentPanel = (JPanel) panel.getParent();
				parentPanel.remove(panel);
				parentPanel.add(UIFactory.createTournamentProgressionUI(listOfTournaments.getSelectedValue()));
				parentPanel.updateUI();
			}
		});
		initialize32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listOfTournaments.isSelectionEmpty()) {
					tournamentController.getTournamentById(listOfTournaments.getSelectedValue().getTournamentId());
					for(int i = 1; i <= 32; i++)
					tournamentController.addTeamToTournament(new Team(i, "Team " + i));
					tournamentController.initializeTournament();
					tournamentController.saveTournamentToDatabase();
					showTournamentBtn.doClick();
				}
			}
		});
		initialize16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listOfTournaments.isSelectionEmpty()) {
					tournamentController.getTournamentById(listOfTournaments.getSelectedValue().getTournamentId());
					for(int i = 1; i <= 16; i++)
					tournamentController.addTeamToTournament(new Team(i, "Team " + i));
					tournamentController.initializeTournament();
					tournamentController.saveTournamentToDatabase();
					showTournamentBtn.doClick();
				}
			}
		});
		initialize8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listOfTournaments.isSelectionEmpty()) {
					tournamentController.getTournamentById(listOfTournaments.getSelectedValue().getTournamentId());
					for(int i = 1; i <= 8; i++)
					tournamentController.addTeamToTournament(new Team(i, "Team " + i));
					tournamentController.initializeTournament();
					tournamentController.saveTournamentToDatabase();
					showTournamentBtn.doClick();
				}
			}
		});
	}

}
