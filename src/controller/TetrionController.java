/*
 *	@author ddxbugs 
 */
package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import model.Player;
import view.PiecePreview;
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
	/** Next Tetromino preview window */
	private PiecePreview preview;
	/** Current game score tracker */
	private ScoreView score;
	/** Persistent player game model */;
	private Player player;
	
	/** 
	 * Primary class constructor 
	 */
	public TetrionController(final TetrionView View, final PiecePreview Preview, final ScoreView Score) {
		view = View;	// tetris view panel
		preview = Preview;	// tetromino preview panel
		score = Score;	// score level lines view label
		player = null;	//	persistent player model
	
		// TODO implement action event listener methods: timer, next piece, update score
		// TODO implement property change event listener methods: update border and text effects
	}
	
	/** 
	 * Default public constructor 
	 */
	public TetrionController(final int theWidth, final int theHeight) {
		view = new TetrionView();	// tetris view panel
		preview = new PiecePreview();	// tetromino preview panel
		score = new ScoreView();	// score level lines
		player = new Player();	// default player model
		
		setUpComponents();
	}
	
	/**
	 * Set view component properties
	 */
	private void setUpComponents() {
		view.setSize(300, 600);
		preview.setSize(200, 200);	// small window
		score.setSize(400, 100);	// transparent row line
		
		view.addPropertyChangeListener(STRING, preview);
		view.addPropertyChangeListener(STRING, score);
	}

	private void updateScore() {
		// TODO update player score view jlabel
	}
}
