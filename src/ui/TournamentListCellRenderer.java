package ui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Tournament;

public class TournamentListCellRenderer extends JLabel implements ListCellRenderer<Tournament> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TournamentListCellRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Tournament> list, Tournament tournament, int index,
			boolean isSelected, boolean cellHasFocus) {

		String tournamentName = "";
		
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
