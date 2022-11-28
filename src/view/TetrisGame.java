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
import javax.swing.Timer;

import model.TetrionViewModel;

/**
 *	Tetris Frame
 */
public class TetrisGame extends JFrame {
	
	// TODO add MIDI and OST sound
	
	/** */
	private static final long serialVersionUID = 1L;
	
	/** */
	private static final int TIME_DELAY = 1000;
	
	/** Full screen configuration settings and variables */
	private static final int BLOCK_SIZE = 1;
	/** The block size scale */
	private static final int SCALE = 1;
	/** Magic number two */
	private static final int TWO = 2;
	
	/** String file path to game image files */
	private static final String ICON = "src/res/icon.jpg";
	private static final String GRID = "src/res/background.jpg";
	private static final String DISC = "src/res/cyan_disc.png";
	private static final String BOARD = "src/res/board.png";
	
	private static int myWidth;
	private static int myHeight;
	
	/** Game graphics environment */
	private static GraphicsEnvironment myGraphicsEnv;
	
	/** Tetris Board swing timer */
	private static Timer myTimer;
	
	/** Layered pane for game overlays */
	private static JLayeredPane myLayeredPane;
	
	private static Dimension myDimension;
	
	/** Dynamic changing background */
	private static Tetrion myTetrion;
	/** Configuration settings menu option */
	private static ConfigView myConfig;
	
	/** Next Tetromino preview window */
	private PiecePreview myPreview;
	/** Current game score tracker */
	private ScoreView myScore;
	/** Tetris board container view */
	private TetrionView myTetrionView;

	
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
		myWidth = (int) myDimension.getWidth();
		myHeight = (int) myDimension.getHeight();
		
		setMaximumSize(myDimension);
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
		setSize(myDimension);
		setVisible(true);
	}
	
	/** 
	 * Initialize JComponent and event handlers
	 */
	private void initialize() {
		myLayeredPane = new JLayeredPane();
		
		myPreview = new PiecePreview();
		myScore = new ScoreView();
//		myConfig = new ConfigView();
		myTetrion = new Tetrion();
	
		myTetrionView = new TetrionView(myWidth, myHeight);

		// TODO initialize window focus listener, keyboard listener, mouse listener
	}
	
	private void setUp() {
		// TODO remove hard coded values
//		myConfig.setSize(getMaximumSize());
		myTetrion.setSize(getMaximumSize());
		myTetrionView.setSize(300, 600);
		myPreview.setSize(200, 200);
		myScore.setSize(400, 100);
		
//		myLayeredPane.add(myConfig, JLayeredPane.MODAL_LAYER);
		myLayeredPane.add(myTetrion, JLayeredPane.DEFAULT_LAYER);
		myLayeredPane.add(myTetrionView, JLayeredPane.POPUP_LAYER);
		myLayeredPane.add(myPreview, JLayeredPane.POPUP_LAYER);
		myLayeredPane.add(myScore, JLayeredPane.POPUP_LAYER);
		
		add(myLayeredPane);
		
		// TODO add window focus, keyboard, mouse, property change event handler
	}
	
	
	
}
