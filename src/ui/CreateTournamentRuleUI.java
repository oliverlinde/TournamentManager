package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class CreateTournamentRuleUI extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CreateTournamentRuleUI() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		
		JLabel createTournamentRuleLbl = new JLabel("Turneringsregler");
		createTournamentRuleLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(createTournamentRuleLbl);

	}

}
