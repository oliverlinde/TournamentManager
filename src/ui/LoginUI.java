package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JPanel {
	
	//private PersonControllerIF personController;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idTextField;
	private JButton loginBtn;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public LoginUI() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel loginLbl = new JLabel("Login");
		loginLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(loginLbl);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7);
		
		JLabel idLbl = new JLabel("Intast Id");
		panel_7.add(idLbl);
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		idTextField = new JTextField();
		panel_5.add(idTextField);
		idTextField.setColumns(20);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		
		loginBtn = new JButton("Login");
		panel_6.add(loginBtn);

		createActions();
	}
	
	//public boolean isLoggedIn() {
		//boolean passed = false;
		//if(true/*personController.getPerson(idTextField.getText());*/){
			
			//passed = true;
	//	}
		
	//	return passed;
	//}
	
	private void createActions() {
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.getTopLevelAncestor();
				panel.setVisible(false);
			}
		});
	}
	
	
}
