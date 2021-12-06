/*
 * @enum for the current format being played in the 
 * current tournament. 
 * 
 * Should not be able to be changed at any point through the 
 * different matches of the tournament, but be bound to the
 * specific created instance of a tournament. 
 */

package model;

public enum Format {
	SingleElimination,
	DoubleElimination,
	PointsSystem

}
