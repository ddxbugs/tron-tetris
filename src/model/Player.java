/*
 * Player.java
 * @author ddxbugs
 */
package model;

/**
 * Persistence player class model 
 */
public class Player {
	/** Player game level difficulty */
	private int myCurrentLevel;
	/** Player highest score */
	private int myHighestScore;
	/** Player end game initials */
	private char[] myInitials;
	/**
	 * protected class constructor
	 */
	public Player() {
		// TODO Auto-generated constructor stub
		myCurrentLevel = 0;
		myHighestScore = 0;
		myInitials = new char[3];
	}
	
	/**
	 * Returns Player current game level
	 * @return Player level 0-99
	 */
	protected int getLevel() {
		return myCurrentLevel;
	}
	/** 
	 * Increment the Player level
	 * Increases game speed difficulty
	 */
	protected void levelUp() {
		myCurrentLevel++;
	}
	
	/**
	 * Return the highest score in saved game
	 * @return The highest score earned
	 */
	protected int getHighestScore() {
		return myHighestScore;
	}
	
	/**
	 * Return the three letter initials
	 * @return The player post game initials
	 */
	protected String getInitials() {
		return myInitials.toString().toUpperCase();
	}
}
