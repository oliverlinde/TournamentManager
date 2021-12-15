package controller;
import java.sql.SQLException;
import dao.BracketDAOIF;
import model.Bracket;
import model.BracketRound;


public class BracketController implements BracketControllerIF {
	private BracketRoundControllerIF bracketRoundController;
	private BracketDAOIF bracketDAO;
	private Bracket bracket;

	public BracketController(BracketDAOIF bracketDAO) {
		this.bracketDAO = bracketDAO;
	}
	
	public boolean saveBracketToDataBase(int tournamentId) {
		boolean passed = false;
		try {
			bracketDAO.createBracket(tournamentId, bracket);
			passed = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passed;
	}
	
	@Override
	public Bracket generateBracket(BracketRound bracketRound) {
		return new Bracket(bracketRound);
	}
	
	public void addBracketRound(BracketRound bracketRound) {
		bracket.addBracketRound(bracketRound);
		bracketRoundController.saveBracketRoundToDatabase(bracket.getBracketId(), bracketRound);
	}

}
