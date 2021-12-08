package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class CreateTournamentUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public CreateTournamentUI() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		
		JLabel createTournamentLbl = new JLabel("Opret turnering");
		createTournamentLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(createTournamentLbl);

	}

}
