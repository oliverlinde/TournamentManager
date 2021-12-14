package controller;
import java.sql.SQLException;
import java.util.List;
import dao.BracketDAOIF;
import dao.DAOFactory;
import dao.DbConnection;
import model.Bracket;
import model.BracketRound;
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
	public Bracket generateBracket(BracketRound bracketRound) {
		return new Bracket(getNextBracketId(), bracketRound);
	}

	@Override
	public List<BracketRound> getBracketRound() {
		List<BracketRound> listOfBracketRounds = null;
		try {
			listOfBracketRounds = bracketDAO.getBracketRounds();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfBracketRounds;
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

}
