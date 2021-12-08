package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MainMenuUI extends JPanel {
	
	private JMenuItem activeTournamentsMenuItem;
	private JMenuItem createTournamentMenuItem;
	private JMenuItem createTournamentRuleMenuItem;
	private JMenuItem teamsMenuItem;
	private JMenuItem personMenuItem;
	private JPanel mainPnl;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MainMenuUI() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel menuBarPnl = new JPanel();
		add(menuBarPnl, BorderLayout.NORTH);
		menuBarPnl.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBarPnl.add(menuBar);
		
		JMenu filesMenu = new JMenu("Filer");
		menuBar.add(filesMenu);
		
		JMenu helpMenu = new JMenu("Hj\u00E6lp");
		menuBar.add(helpMenu);
		
		JPanel menuPnl = new JPanel();
		menuPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(menuPnl, BorderLayout.WEST);
		menuPnl.setLayout(new BoxLayout(menuPnl, BoxLayout.Y_AXIS));
		
		activeTournamentsMenuItem = new JMenuItem("Aktive turneringer");
		;
		menuPnl.add(activeTournamentsMenuItem);
		
		createTournamentMenuItem = new JMenuItem("Opret turnering");
		menuPnl.add(createTournamentMenuItem);
		
		createTournamentRuleMenuItem = new JMenuItem("Opret turneringsregel");
		menuPnl.add(createTournamentRuleMenuItem);
		
		teamsMenuItem = new JMenuItem("Hold");
		menuPnl.add(teamsMenuItem);
		
		personMenuItem = new JMenuItem("Person");
		menuPnl.add(personMenuItem);
		
		JPanel panel_2 = new JPanel();
		menuPnl.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel personNamePnl = new JPanel();
		panel_2.add(personNamePnl, BorderLayout.SOUTH);
		
		JPanel personPicPnl = new JPanel();
		panel_2.add(personPicPnl, BorderLayout.CENTER);
		
		mainPnl = new JPanel();
		add(mainPnl, BorderLayout.CENTER);

		createActions();

	}
	
	
	private void createActions() {
		activeTournamentsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		createTournamentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		createTournamentRuleMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		teamsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPnl.add(UIFactory.createTeamMenuUI());
			}
		});
		
		personMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}

}
