package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;

public class LoginUI extends JPanel {
	
	//private PersonControllerIF personController;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idTextField;
	private JButton loginBtn;
	private JPanel loginPanel;

	/**
	 * Create the panel.
	 */
	public LoginUI() {
		
		loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		loginPanel.add(panel_2);
		
		JLabel loginLbl = new JLabel("Login");
		loginLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(loginLbl);
		
		JPanel panel_3 = new JPanel();
		loginPanel.add(panel_3);
		
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
	}
	
	//public boolean isLoggedIn() {
		//boolean passed = false;
		//if(true/*personController.getPerson(idTextField.getText());*/){
			
			//passed = true;
	//	}
		
	//	return passed;
	//}
	
//	private void createActions() {
//		loginBtn.addActionListener(this);
//			
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		loginPanel.setVisible(false);
//		
//	}

	private void createLoginPanel() {
		
	}
	
	
}
