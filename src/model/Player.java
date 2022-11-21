/**
 * 
 */
package model;

/**
 * @author User
 *
 */
final class Player {
	/** Player game level difficulty */
	private int myLevel;
	/**
	 * 
	 */
	protected Player() {
		// TODO Auto-generated constructor stub
		myLevel = 0;
	}
	
	/**
	 * Returns Player current game level
	 * @return Player level 0-99
	 */
	protected int getLevel() {
		return myLevel;
	}
	/** 
	 * Increment the Player level
	 * Increases game speed difficulty
	 */
	protected void levelUp() {
		myLevel++;
	}
}
