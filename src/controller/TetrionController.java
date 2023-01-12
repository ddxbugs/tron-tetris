/*
 *	@author ddxbugs 
 */
package controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.Preview;
import view.ScoreView;
import view.TetrionView;

/**
 *	1-Player TetrionGrid view model controller class
 */
public class TetrionController {
	// TODO refactor name
	private static final String STRING = "string";
	
	private static Timer myActionTimer;
	/** Current TetrionGrid board view */
	private TetrionView view;
	/** Next Tetromino preview panel view */
	private Preview preview;
	/** Current game score tracker */
	private ScoreView score;
	
	private ChangeEvent changeEvent;
	private ChangeListener changeListener;
	
	/** 
	 * Primary public class constructor 
	 */
	public TetrionController(final TetrionView View, final Preview Preview, final ScoreView Score) {
		view = View;	// tetris view panel
		preview = Preview;	// tetromino preview panel
		score = Score;	// score level lines view label
		
		changeEvent = new ChangeEvent(view);
		
		// view update preview and score property  
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
		// TODO update player score view jlabel, upon level fire property change event
//		int currentScore = score.getScore();
//		score.firePropertyChange(STRING, value);
	}
}
