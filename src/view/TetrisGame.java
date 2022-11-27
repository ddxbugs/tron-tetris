/**
 * 
 */
package view;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
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
	
	/** Dynamic changing background wallpaper */ // TODO implements with JLayeredPane
	private static Background myBackground;
	/** Tetris board container view */
	private static BoardView myBoardView;
	/** Tetris board view model */
	private BoardModel myBoardModel;
	/** Tetris Board swing timer */
	private static Timer myTimer;
	
	/**
	 * @throws HeadlessException
	 */
	public TetrisGame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Disney's Tron: Legacy Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
//		setLocationRelativeTo(null);
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
		myBackground = new Background();
//		myBoardModel = new BoardModel();	// TODO implement scale for board size
		myBoardView = new BoardView(); // TODO need class field or getter for tetris board model	
		// TODO init menu option
		// TODO init preview window
		// TODO init windowfocuslistener
		// TODO init keyboardlistener
	}
	
	private void setUp() {
		setBackgroundImage(ICON);
		setBackgroundImage(BOARD);
		setBackgroundImage(GRID);
		
		myBoardView.setSize(getPreferredSize());
		add(myBackground);
		add(myBoardView);
//		add(myBoardView);
		// TODO add windowfocuslistener
		// TODO add keyboardlistener
		// TODO add propertychangerlisteners
	}
	
	private void setBackgroundImage(final String theFilePath) {
		Path path = Paths.get(theFilePath);
		try {
			BufferedImage img = ImageIO.read(path.toFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
