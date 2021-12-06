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

import java.util.Map;

public class BracketRoundResult {
	private Map<Team, Integer> pointsToTeam;
	
	/*
	 * Add points through a Map to a specific team.
	 * 
	 * Not implemented. 
	 */
	public void addPointsToTeam(Team team, int points) {
		
	}

}
