/*
 * Returns the total result of the current bracket round 
 * to the specific team, and adds the points given through 
 * the dependency injection bracket strategy, which is 
 * either single or double elimination strategy, 
 * or points strategy. 
 * 
 * Still not implemented.
 */

package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BracketRoundResult {
	private Map<Team, Integer> pointsToTeam;
	
	public BracketRoundResult(List<Team> teams) {
		pointsToTeam = new HashMap<>();
		for (Team team : teams) {
			pointsToTeam.put(team, 0);
		}
	}
	
	public BracketRoundResult(Map<Team, Integer> pointsToTeam) {
		this.pointsToTeam = pointsToTeam;
	}
	
	/*
	 * Add points through a Map to a specific team.
	 * 
	 * Not implemented. 
	 */
	public void addPointsToTeam(Team team, int points) {
		int totalPoints = pointsToTeam.get(team) + points;
		pointsToTeam.put(team, totalPoints);
	}

}
