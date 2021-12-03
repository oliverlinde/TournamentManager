/*
 * @enum for the number of rounds currently being played in the 
 * current round of the bracket. 
 */

package model;

public enum NoOfRounds {
	BestOfOne(1), BestOfThree(3), BestOfFive(5);

	private final int value;

	private NoOfRounds(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
