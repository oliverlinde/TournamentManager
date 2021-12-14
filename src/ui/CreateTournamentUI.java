package ui;

import javax.swing.JPanel;

import controller.TournamentController;
import controller.TournamentControllerIF;
import controller.TournamentRuleController;
import controller.TournamentRuleControllerIF;
import dao.DAOFactory;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import java.util.Date;
import java.util.List;
import model.TournamentRule;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateTournamentUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TournamentControllerIF tournamentController;
	private JTextField tournamentNameField;
	private JTextField gameNameField;
	private JComboBox<String> tournamentRuleComboBox;
	private List<TournamentRule> listOfTournamentRules;
	private JSpinner registrationDateSpinner;
	private JSpinner dateOfEventSpinner;
	private JButton btnNewButton;
	private JSpinner maxTeamsSpinner;
	private JSpinner minTeamsSpinner;
	private Date registrationDate;
	private Date dateOfEvent;
	private TournamentRule tournamentRule;

	/**
	 * Create the panel.
	 */
	public CreateTournamentUI() {
		tournamentController = new TournamentController(DAOFactory.createTournamentDAO());

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);

		JLabel lblNewLabel = new JLabel("Navn p\u00E5 turneringen");
		panel_7.add(lblNewLabel);

		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);

		tournamentNameField = new JTextField();

		panel_8.add(tournamentNameField);
		tournamentNameField.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);

		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);

		JLabel lblNewLabel_1 = new JLabel("Spil som skal spilles");
		panel_9.add(lblNewLabel_1);

		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);

		gameNameField = new JTextField();

		panel_10.add(gameNameField);
		gameNameField.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);

		JLabel lblNewLabel_2 = new JLabel("Turneringsregel");
		panel_11.add(lblNewLabel_2);

		JPanel panel_12 = new JPanel();
		panel_3.add(panel_12);

		tournamentRuleComboBox = new JComboBox<String>();

		createTournamentRuleList();

		panel_12.add(tournamentRuleComboBox);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);

		JPanel panel_13 = new JPanel();
		panel_4.add(panel_13);

		JLabel lblNewLabel_3 = new JLabel("Dato for sidste tilmelding");
		panel_13.add(lblNewLabel_3);

		JPanel panel_14 = new JPanel();
		panel_4.add(panel_14);
		
		

		registrationDate = new Date();
		SpinnerModel registrationDateModel = new SpinnerDateModel(registrationDate, null, null, 0);
		registrationDateSpinner = new JSpinner(registrationDateModel);
		JSpinner.DateEditor dateEditorRegistrationSpinner = new JSpinner.DateEditor(registrationDateSpinner, "yyyy-MM-dd HH:mm");
		registrationDateSpinner.setEditor(dateEditorRegistrationSpinner);

		panel_14.add(registrationDateSpinner);

		JPanel panel_15 = new JPanel();
		panel.add(panel_15);

		JPanel panel_17 = new JPanel();
		panel_15.add(panel_17);

		JLabel lblNewLabel_4 = new JLabel("Dato for afvikling af turnering");
		panel_17.add(lblNewLabel_4);

		JPanel panel_18 = new JPanel();
		panel_15.add(panel_18);
		
		
		dateOfEvent = new Date();
		SpinnerModel eventDateModel = new SpinnerDateModel(dateOfEvent, null, null, 0);
		dateOfEventSpinner = new JSpinner(eventDateModel);
		JSpinner.DateEditor dateEditorEventSpinner = new JSpinner.DateEditor(dateOfEventSpinner, "yyyy-MM-dd HH:mm");
		dateOfEventSpinner.setEditor(dateEditorEventSpinner);
		

		
		
		panel_18.add(dateOfEventSpinner);

		JPanel panel_16 = new JPanel();
		panel.add(panel_16);

		JPanel panel_19 = new JPanel();
		panel_16.add(panel_19);

		JLabel lblNewLabel_5 = new JLabel("Max antal deltagende hold");
		panel_19.add(lblNewLabel_5);

		JPanel panel_20 = new JPanel();
		panel_16.add(panel_20);

		maxTeamsSpinner = new JSpinner();
		maxTeamsSpinner.setModel(new SpinnerNumberModel(0, 0, null, 4));
		panel_20.add(maxTeamsSpinner);

		JPanel panel_21 = new JPanel();
		panel.add(panel_21);

		JPanel panel_22 = new JPanel();
		panel_21.add(panel_22);

		JLabel lblNewLabel_6 = new JLabel("Minimum antal deltagende hold");
		panel_22.add(lblNewLabel_6);

		JPanel panel_23 = new JPanel();
		panel_21.add(panel_23);

		minTeamsSpinner = new JSpinner();
		minTeamsSpinner.setModel(new SpinnerNumberModel(0, 0, null, 4));
		panel_23.add(minTeamsSpinner);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);

		JLabel createTournamentLbl = new JLabel("Opret turnering");
		createTournamentLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(createTournamentLbl);

		JPanel panel_5 = new JPanel();
		add(panel_5, BorderLayout.SOUTH);

		btnNewButton = new JButton("Opret turnering");

		panel_5.add(btnNewButton);
		reset();
		createActions();
	}

	private void createTournamentRuleList() {
		TournamentRuleControllerIF tournamentRuleController = new TournamentRuleController(DAOFactory.createTournamentRuleDAO());
		listOfTournamentRules = tournamentRuleController.getAllTournamentRule();
		for (TournamentRule tournamentRule : listOfTournamentRules) {
			tournamentRuleComboBox.addItem(tournamentRule.getDescription());
		}
	}

	private void createActions() {
		gameNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				tournamentController.setGame(gameNameField.getText());
			}
		});

		tournamentNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				tournamentController.setName(tournamentNameField.getText());
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tournamentRule = null;
				int i = 0;
				while (tournamentRule == null) {
					if (listOfTournamentRules.get(i).getDescription()
							.equals(tournamentRuleComboBox.getSelectedItem())) {
						tournamentRule = listOfTournamentRules.get(i);
					}
					i++;
				}
				tournamentController.setTournamentRule(tournamentRule);
				LocalDateTime registrationDeadline = Instant.ofEpochMilli(registrationDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
				LocalDateTime dateTimeOfEvent = Instant.ofEpochMilli(dateOfEvent.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
				tournamentController.setRegistrationDeadline(registrationDeadline);
				tournamentController.setDateTimeOfEvent(dateTimeOfEvent);
				tournamentController.setMaxNoOfTeams(Integer.parseInt(maxTeamsSpinner.getValue().toString()));
				tournamentController.setMinNoOfTeams(Integer.parseInt(minTeamsSpinner.getValue().toString()));
				tournamentController.confirmTournament();
				reset();
			}
		});
		
		registrationDateSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				registrationDate = (Date) dateOfEventSpinner.getValue();
				
			}
		});
		
		
		dateOfEventSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				dateOfEvent = (Date) dateOfEventSpinner.getValue();
			}
		});

	}

	private void reset() {
		tournamentController.createTournament();
		tournamentNameField.setText("");
		gameNameField.setText("");
		registrationDateSpinner.setValue(new Date());
		dateOfEventSpinner.setValue(new Date());
		maxTeamsSpinner.setValue(0);
		minTeamsSpinner.setValue(0);

	}

}
