package ui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Team;

public class TeamListCellRenderer extends JLabel implements ListCellRenderer<Team> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public TeamListCellRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Team> list, Team team, int index,
			boolean isSelected, boolean cellHasFocus) {

		String teamId = String.valueOf(team.getTeamId());
		String teamName = team.getTeamName();
		setText(teamId);
		setText(teamName);
		
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		return this;
	}
}
