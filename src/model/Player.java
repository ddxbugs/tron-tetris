/*
 * Player.java
 * @author ddxbugs
 */
package model;

import java.util.Objects;

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
		myCurrentLevel = 0;	// default level
		myHighestScore = 0;	// default score
		myLines = 0;	// default lines
		myInitials = new char[INITIALS_ARR_SIZE];	// initialize new char array
	}
	/**
	 * Persistent player primary class constructor
	 * @param theInitials The player initials
	 */
	public Player(final String theInitials) {
		// TODO fetch persistent player accessor method score level data  
		myInitials = theInitials.substring(0, INITIALS_ARR_SIZE)
						.toUpperCase()
						.toCharArray();
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
		return myInitials != null ? myInitials.toString().toUpperCase() : "";
	}
	/**
	 * Save persistent player initials
	 * @param theInitials Player initials
	 */
	protected void setInitials(final char[] theInitials) {
		if (myInitials != null) {
			for (int i = 0; i < myInitials.length; i++) {
				myInitials[i] = Character.toUpperCase(theInitials[i]);	// upper case initials 
			}
		}
		
	}
	
}
