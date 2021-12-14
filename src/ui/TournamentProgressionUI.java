package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import controller.TournamentController;
import controller.TournamentControllerIF;
import dao.DAOFactory;
import model.Bracket;
import model.BracketRound;
import model.Match;
import model.Tournament;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;

public class TournamentProgressionUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane round1ScrollPane;
	private JScrollPane round2ScrollPane;
	private Tournament tournament;
	private JList<Match> matches;
	private JPanel round1Pnl;

	/**
	 * Create the panel.
	 */
	public TournamentProgressionUI(Tournament tournament) {
		this.tournament = tournament;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		panel_6.setMinimumSize(new Dimension(600, 200));
		
		round1Pnl = new JPanel();
		panel_6.add(round1Pnl);
		round1Pnl.setLayout(new BoxLayout(round1Pnl, BoxLayout.X_AXIS));
				
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JLabel round1Lbl = new JLabel("Runde 1");
		panel_7.add(round1Lbl);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_8.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		round2ScrollPane = new JScrollPane();
		panel_3.add(round2ScrollPane);
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.NORTH);
		
		JLabel round2Lbl = new JLabel("Runde 2");
		panel_9.add(round2Lbl);
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_10.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JScrollPane round3ScrollPane = new JScrollPane();
		panel_4.add(round3ScrollPane);
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11, BorderLayout.NORTH);
		
		JLabel round3Lbl = new JLabel("Runde 3");
		panel_11.add(round3Lbl);
		
		JPanel panel_12 = new JPanel();
		panel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_12.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		JScrollPane round4ScrollPane = new JScrollPane();
		panel_5.add(round4ScrollPane);
		
		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13, BorderLayout.NORTH);
		
		JLabel round4Lbl = new JLabel("Runde 4");
		panel_13.add(round4Lbl);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1, BorderLayout.NORTH);
		
		JButton backBtn = new JButton("Tilbage");
		panel_1.add(backBtn);
		
		generateTournamentVisuals();

	}
	
	private void generateTournamentVisuals() {
		DefaultListModel<Match> listModel = new DefaultListModel<>();
		TournamentControllerIF tournamentController = new TournamentController(DAOFactory.createTournamentDAO());
		Tournament fullTournament = tournamentController.getTournamentById(tournament.getId());
		
		for (Bracket bracket : fullTournament.getBrackets()) {
			for (BracketRound bracketRound : bracket.getBracketRounds()) {
				for (Match match : bracketRound.getMatches()) {
					listModel.addElement(match);
					
				}
			}	
		}
		
		matches = new JList<>(listModel);
		matches.setCellRenderer(new MatchListCellRenderer());
		round1ScrollPane = new JScrollPane(matches);
		round1Pnl.add(round1ScrollPane);

	}

}
