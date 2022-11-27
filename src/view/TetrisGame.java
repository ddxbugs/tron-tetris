/**
 * 
 */
package view;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import model.BoardModel;
import res.ColorPalette;

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
	
	
	
	/** Game graphics environment */
	private static GraphicsEnvironment myGraphicsEnv;
	
	/** Tetris Board swing timer */
	private static Timer myTimer;
	
	/** Layered pane for game overlays */
	private static JLayeredPane myLayeredPane;
	
	/** Dynamic changing background */
	private static Background myBackground;
	
	/** Tetris board view model */
	private BoardModel myBoardModel;
	/** Tetris board container view */
	private BoardView myBoardView;

	
	/**
	 * @throws HeadlessException
	 */
	public TetrisGame(final GraphicsEnvironment theGraphicsEnv) 
			throws HeadlessException {
		
		super("Disney's Tron: Legacy");
		
		myGraphicsEnv = theGraphicsEnv;
		
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
		myLayeredPane = new JLayeredPane();
		
		myBackground = new Background();
//		myBoardModel = new BoardModel();
//		myBoardView = new BoardView();
		
		// TODO init menu option
		// TODO init preview window
		// TODO init windowfocuslistener
		// TODO init keyboardlistener
	}
	
	private void setUp() {
		
		myBackground.setSize(myGraphicsEnv.getMaximumWindowBounds().getSize());
		
		myLayeredPane.add(myBackground, -1);
//		myLayeredPane.add(myBoardView, 0);
//		myLayeredPane.add(myPreviewPanel, 1);
//		myLayeredPane.add(myScorePanel, 2);
		
//		add(myGameOptions);
		add(myLayeredPane);
		
		// TODO add windowfocuslistener event handler
		// TODO add keyboardlistener event handler
		// TODO add propertychangerlisteners event handler
	}
	
	
	
}
