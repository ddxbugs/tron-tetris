/*
 * Player.java
 * @author ddxbugs
 */
package model;

/**
 * Persistence player class model 
 */
public class Player {
	// TODO String pattern regex 0-9azAZ!@#$%^&*() and duplicates
	/** Max three character initial */
	private int INITIALS_ARR_SIZE = 3;
	/** Player game level difficulty */
	private int myCurrentLevel;
	/** Player highest score */
	private int myHighestScore;
	/** Player total lines */
	private int myLines;
	/** Player end game initials */
	private char[] myInitials;
	/**
	 * protected player default class constructor
	 */
	public Player() {
		myCurrentLevel = 0;
		myHighestScore = 0;
		myLines = 0;
		myInitials = new char[INITIALS_ARR_SIZE];
	}
	/**
	 * Returns Player current game level
	 * @return Player level 0-999
	 */
	public int getLevel() {
		return myCurrentLevel;
	}
	/** 
	 * Increment the Player level
	 */
	public void levelUp() {
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
	 * Set player high score
	 * @param theHighestScore The highest score
	 */
	protected void setHighestScore(final int theHighestScore) {
		myHighestScore = theHighestScore;
	}
	/**
	 * Return the number of lines completed
	 * @return The number of lines completed
	 */
	protected int getLines() {
		return myLines;
	}
	/**
	 * Return the three letter initials
	 * @return The player post game initials
	 */
	protected String getInitials() {
		return myInitials.toString().toUpperCase();
	}
	/**
	 * Save persistent player initials
	 * @param theInitials Player initials
	 */
	protected void setInitials(final char[] theInitials) {
		char[] initials = new char[INITIALS_ARR_SIZE];
		for (int i = 0; i < initials.length; i++) {
			initials[i] = theInitials[i];
		}
	}
	
}
