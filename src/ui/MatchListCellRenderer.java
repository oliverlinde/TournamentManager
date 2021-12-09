package ui;

import java.awt.Component;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Match;


public class MatchListCellRenderer extends JLabel implements ListCellRenderer<Match>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Match> list, Match match, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		String matchId = String.valueOf(match.getMatchId());
		String team1Id = String.valueOf(match.getListOfTeams().get(0).getTeamId());
		String team1Name = match.getListOfTeams().get(0).getTeamName();
		String team2Id = String.valueOf(match.getListOfTeams().get(0).getTeamId());
		String team2Name = match.getListOfTeams().get(0).getTeamName();
		
		
//		setText(tournamentId);
//		setText(tournamentName);
//		setText(gameName);
//		setText(registrationDeadline);
//		setText(timeOfEvent);
//		setText(maxNoOfTeams);
//		setText(minNoOfTeams);
		
		String rerturnString = matchId + " | " + team1Id +  " | " + team1Name + "\n" +
				matchId + " | " + team2Id + " " + team2Name ;
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
