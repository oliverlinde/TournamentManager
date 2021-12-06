package controller;

import model.Format;

public interface GenerateBracketStrategyIF {

	public void proceedToNextRound(Format format);
	public int calculatePoints();
}
