package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreatePersonUI extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField personNameTextField;
	private JTextField emailTextField;
	private JTextField roleTextField;
	private JPanel rolePnl;
	private JRadioButton isAdminRdoBtn;
	private JRadioButton isNotAdminRdoBtn;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	public CreatePersonUI() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel createPersonLbl = new JLabel("Opret person");
		createPersonLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(createPersonLbl);

		panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);

		JLabel adminLbl = new JLabel("Administrator");
		panel_4.add(adminLbl);

		isAdminRdoBtn = new JRadioButton("Ja");
		isAdminRdoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(isAdminRdoBtn);

		isNotAdminRdoBtn = new JRadioButton("Nej");
		isNotAdminRdoBtn.setSelected(true);
		panel_4.add(isNotAdminRdoBtn);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		JLabel personNameLbl = new JLabel("Navn");
		panel_3.add(personNameLbl);

		personNameTextField = new JTextField();
		panel_3.add(personNameTextField);
		personNameTextField.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);

		JLabel emailLbl = new JLabel("Email");
		panel_5.add(emailLbl);

		emailTextField = new JTextField();
		panel_5.add(emailTextField);
		emailTextField.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);

		JLabel birthdateLbl = new JLabel("F\u00F8dselsdato");
		panel_6.add(birthdateLbl);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1639004400000L), null, null, Calendar.DAY_OF_YEAR));
		panel_6.add(spinner);
		
				rolePnl = new JPanel();
				panel_1.add(rolePnl);
				
						JLabel roleLbl = new JLabel("Besk\u00E6ftigelse i GGW");
						rolePnl.add(roleLbl);
						
								roleTextField = new JTextField();
								rolePnl.add(roleTextField);
								roleTextField.setColumns(10);
								roleTextField.setEnabled(false);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);

		JButton createPersonBtn = new JButton("Opret ny person");
		panel_2.add(createPersonBtn);

		createActions();

	}

	private void createActions() {
		isAdminRdoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isNotAdminRdoBtn.setSelected(false);
				roleTextField.setEnabled(true);
			}
		});

		isNotAdminRdoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roleTextField.setEnabled(false);
				roleTextField.setText("");
				isAdminRdoBtn.setSelected(false);
			}
		});
	}

}
