/*
 * TetrisGame.java
 * @author ddxbugs 
 */
package view;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import model.TetrionViewModel;

/**
 *	Tetris Frame
 */
public class TetrisGame extends JFrame implements ActionListener {
	
	// TODO add MIDI and OST sound
	
	/** */
	private static final long serialVersionUID = 1L;
	
	/** String file path to game image files */
	private static final String ICON = "src/res/icon.jpg";
	
	private static final int M = 1000;
	
	private static int width;
	private static int height;
	private static int delay;
	
	/** Game graphics environment */
	private static GraphicsEnvironment myGraphicsEnv;
	
	/** Set the speed of the piece movement logic */
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
		width = (int) myDimension.getWidth();
		height = (int) myDimension.getHeight();
		delay = M;
		
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
		
		myTimer = new Timer (delay, this);
		
		myLayeredPane = new JLayeredPane(); // layered pane
		
		myConfig = new ConfigView();	// game options menu
		myTetrion = new Tetrion();	// the background
		
		myTetrionView = new TetrionView(width, height);	// the 1-Player game board
		
		myPreview = new PiecePreview();	// next piece 
		myScore = new ScoreView();	// score level lines
		
		// TODO initialize window focus listener, keyboard listener, mouse listener
		
	}
	
	private void setUp() {
		// TODO remove hard coded values
		myConfig.setSize(500, 500);	// medium window
		myTetrion.setSize(getMaximumSize());	// full screen w h
		myTetrionView.setSize(300, 600);	// half dimension
		myPreview.setSize(200, 200);	// small window
		myScore.setSize(400, 100);	// transparent row line
		
		// add components to layered pane
		myLayeredPane.add(myConfig, JLayeredPane.MODAL_LAYER);
		myLayeredPane.add(myTetrion, JLayeredPane.DEFAULT_LAYER);
		myLayeredPane.add(myTetrionView, JLayeredPane.POPUP_LAYER);
		myLayeredPane.add(myPreview, JLayeredPane.POPUP_LAYER);
		myLayeredPane.add(myScore, JLayeredPane.POPUP_LAYER);
		
		// add layered pane to this frame
		add(myLayeredPane);
		
		// TODO add window focus, keyboard, mouse, property change event handler
	}

	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		// TODO Auto-generated method stub
		myTetrionView.dispatchEvent(theActionEvent);
	}
	
	
}
