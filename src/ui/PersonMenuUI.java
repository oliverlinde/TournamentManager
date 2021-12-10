package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class PersonMenuUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public PersonMenuUI() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		
		JLabel personMenuLbl = new JLabel("Person menu");
		personMenuLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(personMenuLbl);

	}

}
