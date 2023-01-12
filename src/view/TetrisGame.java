/*
 * TetrisGame.java
 * @author ddxbugs 
 */
package view;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import controller.MenuController;
import controller.TetrionController;

/**
 *	Tetris Frame
 */
public class TetrisGame extends JFrame {
	
	// TODO add MIDI and OST sound
	
	/** Default serial version uid */
	private static final long serialVersionUID = 1L;
	
	/** String file path to game image files */
	private static final String ICON = "src/res/icon.jpg";

	/** Display window width height dimension */
	private static int width;
	private static int height;
	
	/** Game graphics environment */
	private static GraphicsEnvironment myGraphicsEnv;
	
	/** Layered pane for game overlays */
	private static JLayeredPane myLayeredPane;
	
	/** Game graphics display dimension */
	private static Dimension myDimension;
	
	/** Dynamic changing background */
	private static TetrionGrid myGrid;
	/** Configuration settings menu option */
	private static MenuView myMenuOption;
	
	private static MenuController myMenuController;
	
	/** Tetris board container view */
	private TetrionView myTetrion;
	private Preview myPreview;
	private ScoreView myScore;
	
	/** TetrionGrid model view controlller class */
	private TetrionController myTetrionController;
	
	/**
	 * @throws HeadlessException
	 */
	public TetrisGame(final GraphicsEnvironment theGraphicsEnv) 
			throws HeadlessException {
		super("");
		
		// set window icon decoration
		final ImageIcon icon = new ImageIcon(ICON);
		setIconImage(icon.getImage());
		
		// Game graphics display for dimension width height settings
		myGraphicsEnv = theGraphicsEnv;
		myDimension = myGraphicsEnv.getMaximumWindowBounds().getSize();
		width = (int) myDimension.getWidth();
		height = (int) myDimension.getHeight();
		
		// JFrame property values
		setMaximumSize(myDimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	/** 
	 * Invokes new Runnable configuration
	 */
	public void start() {
		initialize();	// initialize model view components
		setUpComponents();	// set up model view component properties
		pack();	// pack frame components
		setSize(myDimension);	// set default window dimension size
		setVisible(true);	// display gui
	}
	
	/** 
	 * Initialize JComponent and event handlers
	 */
	private void initialize() {
		
		myLayeredPane = new JLayeredPane(); // layered pane
		
		// TetrionGrid View Components
		myGrid = new TetrionGrid();	// the background
		myTetrion = new TetrionView();	// the 1-Player game board 
		myPreview = new Preview();	// next tetris view component  
		myScore = new ScoreView();		// currrent score view component
		
		// Tetrion model view controller
		myTetrionController = new TetrionController(myTetrion, 
												myPreview, 
												myScore);
	}
	/**
	 * Set up view component properties
	 */
	private void setUpComponents() {
		
		myGrid.setSize(getMaximumSize());	// full screen w h
		myTetrion.setSize(300, 600);	// half dimension
		myPreview.setSize(150, 150);	// small square
		myScore.setSize(300, 50);	// medium text label 
				
		// add components to layered pane
//		myLayeredPane.add(myMenuOption, JLayeredPane.MODAL_LAYER);
		myLayeredPane.add(myGrid, JLayeredPane.DEFAULT_LAYER);
		myLayeredPane.add(myTetrion, JLayeredPane.POPUP_LAYER);
		myLayeredPane.add(myPreview, JLayeredPane.POPUP_LAYER);
		myLayeredPane.add(myScore, JLayeredPane.POPUP_LAYER);
		
		// add layered pane to this frame
		add(myLayeredPane);
	}	
}
