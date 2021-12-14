package ui;

import model.Tournament;
import javax.swing.JPanel;

import java.awt.BorderLayout;
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

public class HomeScreen extends JPanel {
	private TournamentControllerIF tournamentController;
	private JList<Tournament> listOfTeams;
	private JScrollPane scrollPane;
	private JButton showTournamentBtn;
	private JPanel panel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HomeScreen() {
		new TeamController();
		tournamentController = new TournamentController(DAOFactory.createTournamentDAO());
		generateTournamentListView();
		
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		panel_4.setLayout(new BorderLayout(0, 0));
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
		
		showTournamentBtn = new JButton("Vis turneringsforl\u00F8b");

		panel_3.add(showTournamentBtn);
		
		createActions();

	}
	
	private void generateTournamentListView() {
		DefaultListModel<Tournament> listModel = new DefaultListModel<>();
		
		
		for (Tournament tournament : tournamentController.getAllTournaments()) {
			listModel.addElement(tournament);
			
		}
		listOfTeams = new JList<>(listModel);
		listOfTeams.setCellRenderer(new TournamentListCellRenderer());
		scrollPane = new JScrollPane(listOfTeams);
	}
	
	private void createActions() {
		showTournamentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel parentPanel = (JPanel) panel.getParent();
				parentPanel.remove(panel);
				parentPanel.add(UIFactory.createTournamentProgressionUI(listOfTeams.getSelectedValue()));
				parentPanel.updateUI();
			}
		});
	}
	
	public JButton getShowTournamentBtn() {
		return showTournamentBtn;
	}

}
