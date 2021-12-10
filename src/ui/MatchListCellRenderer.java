package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
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
		
		final JTextArea row = new JTextArea();
		row.setFont(new Font("Dialog", Font.PLAIN, 11));
		row.setLineWrap(true);
		row.setWrapStyleWord(true);
		row.setPreferredSize(new Dimension(300, 120));
		
		String matchId = String.valueOf(match.getMatchId());
		String team1Id = String.valueOf(match.getListOfTeams().get(0).getTeamId());
		String team1Name = match.getListOfTeams().get(0).getTeamName();
		String team2Id = String.valueOf(match.getListOfTeams().get(1).getTeamId());
		String team2Name = match.getListOfTeams().get(1).getTeamName();
		String round1Winner = match.getListOfMatchRounds().get(0).getWinner().getTeamName();
		String round2Winner = match.getListOfMatchRounds().get(1).getWinner().getTeamName();
		String round3Winner = match.getListOfMatchRounds().get(2).getWinner().getTeamName();
		
		String rerturnString = "Match id: " + matchId + " | Hold id: " + team1Id +  " | Holdnavn: " + team1Name + "\n" +
				"Match id: " + matchId + " | Hold id: " + team2Id + " | Holdnavn: " + team2Name + "\n" +
				"Runde 1 vinder: " + round1Winner + "\n" +
				"Runde 2 vinder: " + round2Winner + "\n" +
				"Runde 3 vinder: " + round3Winner + "\n";
		//setText(rerturnString);
		
		row.setText(rerturnString);
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		return row;
	}

}
