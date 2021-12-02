package controller;

public class MatchRoundResultController implements MatchRoundResultControllerIF {
	
	private MatchRoundResult matchRoundResult;
	private MatchRoundResultDAOIF matchRoundResultDAO;
	
	public MatchRoundResultController(Datacontext dbConnection) {
		this.matchRoundResultDAO = DAOFactory.createMatchRoundResultDAO(dbConnection);
		matchRoundResult = new MatchRoundResult();
	}

	@Override
	public void setWinner(Team team) {
		matchRoundResult.setWinner(team);
	}

	@Override
	public void setLoser(Team team) {
		matchRoundResult.setLoser(team);
	}

	@Override
	public void setDraw() {
		matchRoundResult.setDraw();
	}

	@Override
	public MatchRoundResult getRoundResult(int matchRoundResultId) {
		return matchRoundResultDAO.getRoundResult(matchRoundResultId);
	}
	
}
