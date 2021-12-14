package ui;

import java.awt.Component;
import java.time.format.DateTimeFormatter;
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


		String tournamentId = String.valueOf(tournament.getTournamentId());
		String tournamentName = tournament.getTournamentName();
		String gameName = tournament.getGameName();
		String registrationDeadline = tournament.getRegistrationDeadline().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
		String timeOfEvent = tournament.getDateTimeOfEvent().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
		String maxNoOfTeams = String.valueOf(tournament.getMaxNoOfTeams());
		String minNoOfTeams = String.valueOf(tournament.getMinNoOfTeams());
		
//		setText(tournamentId);
//		setText(tournamentName);
//		setText(gameName);
//		setText(registrationDeadline);
//		setText(timeOfEvent);
//		setText(maxNoOfTeams);
//		setText(minNoOfTeams);
		
		String rerturnString = tournamentId + " | " + tournamentName + " " + gameName + " | " + registrationDeadline + " | " + timeOfEvent + " | " + maxNoOfTeams + " | " + minNoOfTeams;
		setText(rerturnString);
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
