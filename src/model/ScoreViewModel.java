/*
 * @author ddxbugs
 */
package model;

/**
 * Score view model class
 */
public class ScoreViewModel {
	private int myCurrentScore;
	private int myCurrentLevel;
	private int myCurrentLines;
	
	/**
	 * Initial default public view model constructor
	 */
	public ScoreViewModel() {
		myCurrentScore = 0;
		myCurrentLevel = 0;
		myCurrentLines = 0;
	}
	/**
	 * The player current score
	 * @return The current score
	 */
	public int getScore() {
		return myCurrentScore;
	}
	/**
	 * The player current level
	 * @return The current level
	 */
	public int getLevel() {
		return myCurrentLevel;
	}
	/**
	 * The player current lines 
	 * @return The current number of lines completed
	 */
	public int getLines() {
		return myCurrentLines;
	}
}
