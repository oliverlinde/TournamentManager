package ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class TeamsMenuUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public TeamsMenuUI() {

		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_9.add(panel_12, BorderLayout.NORTH);
		
		JLabel pendingTournamentsLbl = new JLabel("Tilmeldte turneringer");
		panel_12.add(pendingTournamentsLbl);
		
		JPanel panel_13 = new JPanel();
		panel_9.add(panel_13, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_13.add(scrollPane);
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16, BorderLayout.NORTH);
		
		JLabel teamMebersLbl = new JLabel("Holdmedlemmer");
		panel_16.add(teamMebersLbl);
		
		JPanel panel_17 = new JPanel();
		panel_8.add(panel_17, BorderLayout.CENTER);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_17.add(scrollPane_2);
		
		JPanel panel_1 = new JPanel();
		panel_8.add(panel_1, BorderLayout.SOUTH);
		
		JButton addTeamMeberToTeamBtn = new JButton("Tilf\u00F8j nyt medlem");
		panel_1.add(addTeamMeberToTeamBtn);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_11.add(panel_14, BorderLayout.NORTH);
		
		JLabel availableToutnamentsLbl = new JLabel("Aktuelle turneringer");
		panel_14.add(availableToutnamentsLbl);
		
		JPanel panel_15 = new JPanel();
		panel_11.add(panel_15, BorderLayout.CENTER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_15.add(scrollPane_1);
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_10.add(panel_18, BorderLayout.NORTH);
		
		JLabel applyTournamentLbl = new JLabel("Tilmeld turnering");
		panel_18.add(applyTournamentLbl);
		
		JPanel panel_19 = new JPanel();
		panel_10.add(panel_19, BorderLayout.CENTER);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_19.add(scrollPane_3);
		
		JPanel panel_2 = new JPanel();
		panel_10.add(panel_2, BorderLayout.SOUTH);
		
		JButton addTeamMeberBtn = new JButton("Tilf\u00F8j holdmedlem");
		panel_2.add(addTeamMeberBtn);
		
		JButton joinTournamentBtn = new JButton("Tilmeld turnering");
		panel_2.add(joinTournamentBtn);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.NORTH);
		
		JLabel teamLbl = new JLabel("Holdmenu");
		teamLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(teamLbl);

	}

}
