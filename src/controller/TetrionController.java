/*
 *	@author ddxbugs 
 */
package controller;

import model.Player;
import model.TetrionViewModel;
import view.Preview;
import view.ScoreView;
import view.TetrionView;

/**
 *	1-Player Tetrion view model controller class
 */
public class TetrionController {
	// TODO refactor name
	private static final String STRING = "string";
	
	/** Current Tetrion board */
	private TetrionView view;
	private TetrionViewModel model;
	
	/** Next Tetromino preview window */
	private Preview preview;
	/** Current game score tracker */
	private ScoreView score;
	/** Persistent player game model */;
	private Player player;
	
	/** 
	 * Primary public class constructor 
	 */
	public TetrionController(final TetrionView View, final Preview Preview, final ScoreView Score) {
		view = View;	// tetris view panel
		preview = Preview;	// tetromino preview panel
		score = Score;	// score level lines view label
		player = null;	//	persistent player model
		
		// TODO add listener 
		view.addPropertyChangeListener(STRING, preview);
		view.addPropertyChangeListener(STRING, score);
	
		// TODO implement action event listener methods: timer, next piece, update score
		// TODO implement property change event listener methods: update border and text effects
	}
	
	/** 
	 * Private constructor prevent instantiation 
	 */
	private TetrionController() {
		throw new IllegalArgumentException();
	}

	private void updateScore() {
		// TODO update player score view jlabel
		int level = player.getLevel();
		player.levelUp();
		
		int currentScore = 0;
		score.firePropertyChange(STRING, currentScore, currentScore);
		
	}
}
