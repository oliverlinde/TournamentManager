package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

import controller.PersonController;
import controller.TeamController;
import dao.DAOFactory;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class CreateTeamUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField searchPersonTextField;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public CreateTeamUI() {
		new TeamController(DAOFactory.createTeamDAO());
		new PersonController(DAOFactory.createPersonDAO());
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane);
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12, BorderLayout.SOUTH);
		
		JButton addPersonBtn = new JButton("Tilf\u00F8j person");
		panel_12.add(addPersonBtn);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.SOUTH);
		
		searchPersonTextField = new JTextField();
		panel_6.add(searchPersonTextField);
		searchPersonTextField.setColumns(10);
		
		JButton searchPersonBtn = new JButton("S\u00F8g");
		panel_6.add(searchPersonBtn);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("OBS! Du er selv altid en del af holdet");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		panel_7.add(lblNewLabel);
		
		JButton createTeamBtn = new JButton("Opret hold");
		panel_7.add(createTeamBtn);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.NORTH);
		
		JLabel teamNameLbl = new JLabel("Holdnavn");
		panel_9.add(teamNameLbl);
		
		textField = new JTextField();
		panel_9.add(textField);
		textField.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_10.add(scrollPane_1);
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11, BorderLayout.SOUTH);
		
		JButton removePersonBtn = new JButton("Fjern person");
		panel_11.add(removePersonBtn);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		
		JLabel createTeamLbl = new JLabel("Opret hold");
		createTeamLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(createTeamLbl);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);

	}

}
