/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.BoardModel;

/**
 * @author User
 *
 */
public class TetrisGame extends JFrame {
	/** */
	private static final long serialVersionUID = 1L;
	
	/** */
	private static final int TIME_DELAY = 1000;
	
	/** Full screen configuration settings and variables */
	private static final int BLOCK_SIZE = 1;
	/** The block size scale */
	private static final int SCALE = 1;
	/** String file path to game image files */
	
	private static final String ICON = "src/res/icon.jpg";
	private static final String GRID = "src/res/background.jpg";
	private static final String DISC = "src/res/cyan_disc.png";
	private static final String BOARD = "src/res/board.png";
	
	private static GraphicsEnvironment myGraphicsEnv;
	
	/** Dynamic changing background wallpaper */ // TODO implements with JLayeredPane
	private static Background myBackground;
	/** Tetris Board swing timer */
	private static Timer myTimer;
	
	/** Tetris board view model */
	private BoardModel myBoardModel;
	/** Tetris board container view */
	private BoardView myBoardView;
	
	private Dimension myDimension;
	
	/**
	 * @throws HeadlessException
	 */
	public TetrisGame(final GraphicsEnvironment theGraphicsEnv) 
			throws HeadlessException {
		
		super("Disney's Tron: Legacy Tetris");
		
		myGraphicsEnv = theGraphicsEnv;
		myDimension = new Dimension();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	/** 
	 * Invokes new Runnable configuration
	 */
	public void start() {
		initialize();
		setUp();
		pack();
		setVisible(true);
	}
	
	/** 
	 * Initialize JComponent and event handlers
	 */
	private void initialize() {
		System.out.println(myGraphicsEnv.getLocalGraphicsEnvironment().getMaximumWindowBounds());	// TODO debug, uncomment remove me				
		
		myBackground = new Background();
//		myBoardModel = new BoardModel(0,0);	// TODO implement scale for board size
//		myBoardView = new BoardView(); // TODO need class field or getter for tetris board model
		
		// TODO init menu option
		// TODO init preview window
		// TODO init windowfocuslistener
		// TODO init keyboardlistener
	}
	
	private void setUp() {
		
//		myBoardView.setSize();
		add(myBackground);
//		add(myBoardView);
//		add(myBoardView);
		// TODO add windowfocuslistener
		// TODO add keyboardlistener
		// TODO add propertychangerlisteners
	}
	
	
	
}
