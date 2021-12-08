package ui;

import model.Team;
import model.Tournament;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import controller.TeamController;
import controller.TeamControllerIF;
import controller.TournamentController;
import controller.TournamentControllerIF;
import dao.DAOFactory;
import dao.DbConnection;
import dao.TournamentDAOIF;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.sql.SQLException;

public class HomeScreen extends JPanel {
	private TeamControllerIF teamController;
	private TournamentControllerIF tournamentController;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HomeScreen() {
		teamController = new TeamController();
		tournamentController = new TournamentController();
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		DefaultListModel<Tournament> listModel = new DefaultListModel<>();
		
		
		for (Tournament tournament : tournamentController.getAllTournaments()) {
			listModel.addElement(tournament);
		}
		
		
		JList<Tournament> listOfTeams = new JList<>(listModel);
		listOfTeams.setCellRenderer(new TournamentListCellRenderer());

		JScrollPane scrollPane = new JScrollPane(listOfTeams);
		panel_4.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.NORTH);
		
		JLabel activeTournamentsLbl = new JLabel("Aktive turneringer");
		activeTournamentsLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(activeTournamentsLbl);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton editTournamentBtn = new JButton("Redig\u00E9r turnering");
		panel_2.add(editTournamentBtn);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JButton showTournamentBtn = new JButton("Vis turneringsforl\u00F8b");
		panel_3.add(showTournamentBtn);

	}

}
