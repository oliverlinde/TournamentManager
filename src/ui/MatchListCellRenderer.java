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
	
	public MatchListCellRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Match> list, Match match, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		JTextArea row = new JTextArea();
		
		String matchId = String.valueOf(match.getMatchId());
		String team1Id = String.valueOf(match.getListOfTeams().get(0).getTeamId());
		String team1Name = match.getListOfTeams().get(0).getTeamName();
		String team2Id = String.valueOf(match.getListOfTeams().get(1).getTeamId());
		String team2Name = match.getListOfTeams().get(1).getTeamName();
//		String round1Winner = match.getListOfMatchRounds().get(0).getWinner().getTeamName();
//		String round2Winner = match.getListOfMatchRounds().get(1).getWinner().getTeamName();
//		String round3Winner = match.getListOfMatchRounds().get(2).getWinner().getTeamName();
		
		String rerturnString = "Match id: " + matchId + " | Hold id: " + team1Id +  " | Holdnavn: " + team1Name + "\n" +
				"Match id: " + matchId + " | Hold id: " + team2Id + " | Holdnavn: " + team2Name + "\n";
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
