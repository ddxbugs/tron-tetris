/*
 * TetrisGame.java
 * @author ddxbugs 
 */
package view;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import model.TetrionViewModel;
import res.MagicNumber;

/**
 * @author User
 *
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
	private static Tetrion myBackground;
	/** Tetris piece preview window */
	private static PiecePreview myPreviewPanel;
	
	/** Tetris board view model */
	private TetrionViewModel myBoardModel;
	/** Tetris board container view */
	private TetrionView myBoardView;

	
	/**
	 * @throws HeadlessException
	 */
	public TetrisGame(final GraphicsEnvironment theGraphicsEnv) 
			throws HeadlessException {
		
		super("");
		
		final ImageIcon icon = new ImageIcon(ICON);
		setIconImage(icon.getImage());
		
		myGraphicsEnv = theGraphicsEnv;
		// Game display and board dimension
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
		
		myBackground = new Tetrion();
		myPreviewPanel = new PiecePreview();
		
//		myBoardModel = new TetrionViewModel();
		myBoardView = new TetrionView();
		
		// TODO init menu option
		// TODO init preview window
		// TODO init windowfocuslistener
		// TODO init keyboardlistener
	}
	
	private void setUp() {
		
		myBackground.setSize(getMaximumSize());
		myPreviewPanel.setSize(200, 200);
		myBoardView.setSize(300, 600);
		
		myLayeredPane.add(myBackground, JLayeredPane.DEFAULT_LAYER);
		myLayeredPane.add(myBoardView, JLayeredPane.POPUP_LAYER);
		myLayeredPane.add(myPreviewPanel, JLayeredPane.POPUP_LAYER);
//		myLayeredPane.add(myScorePanel);
		
//		add(myGameOptions);
		add(myLayeredPane);
		
		// TODO add windowfocuslistener event handler
		// TODO add keyboardlistener event handler
		// TODO add propertychangerlisteners event handler
	}
	
	
	
}
