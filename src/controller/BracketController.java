package controller;

import java.sql.SQLException;
import java.util.List;
import dao.BracketDAOIF;
import dao.DAOFactory;
import dao.DbConnection;
import model.Bracket;
import model.BracketRound;
import model.Match;
import model.Team;

public class BracketController implements BracketControllerIF {
	private BracketRoundControllerIF bracketRoundController;
	private BracketDAOIF bracketDAO;
	private Bracket bracket;

	public BracketController() {
		this.bracketDAO = DAOFactory.createBracketDAO(new DbConnection());
	}
	
	@Override
	public List<Team> getTeams() {
		return bracketDAO.getTeams();
	}

	@Override
	public void givePointsToTeam(Team team, int pointsToWin) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Bracket generateBracket(BracketRound bracketRound) {
		return new Bracket(getNextBracketId(), bracketRound);
	}
	

	public void createBracket(List<Team> listOfTeams) {
		//this.bracket = new Bracket(listOfTeams);

	}

	@Override
	public List<BracketRound> getBracketRound() {
		List<BracketRound> listOfBracketRounds = null;
		try {
			listOfBracketRounds = bracketDAO.getBracketRounds();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOfBracketRounds;
	}

	
	@Override
	public List<Match> getAllMatches(){
		return bracketRoundController.getAllMatches();
	}
	
	
	public void addBracketRound(BracketRound bracketRound) {
		bracket.addBracketRound(bracketRound);
		bracketRoundController.saveBracketRoundToDatabase(bracket.getBracketId(), bracketRound);
	}
	
	@Override
	public int getNextBracketId() {
		int nextId = 0;
		try {
			nextId = bracketDAO.getNextBracketId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nextId;
	}


		
//	private void saveToDatabase(int tournamentId) throws SQLException {
//		try {
//			bracketDAO.createBracket(tournamentId, bracket);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
