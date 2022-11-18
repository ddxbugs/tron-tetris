/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * @author User
 *
 */
public class TetrisGame extends JFrame {
	/** */
	private static final long serialVersionUID = 1L;
	/** */
	private static final int DEFAULT_WIDTH = 800;
	/** */
	private static final int DEFAULT_HEIGHT = 600;
	/** */
	private static final int TIME_DELAY = 1000;
	
	/** Full screen configuration settings and variables */
	private static final int BLOCK_SIZE = 1;
	private static final int SCALE = 1;
	/** Full screen dimension */
	private static final Dimension FULL_SCREEN_SIZE = 
			Toolkit.getDefaultToolkit().getScreenSize();
	// TODO multiplayer mode
	private static final GraphicsDevice MONITOR_DISPLAY = 
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	

	/**
	 * @throws HeadlessException
	 */
	public TetrisGame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Disney's Tron: Legacy Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		setResizable(false);
		setLocationRelativeTo(null);
		
		pack();
		setVisible(true);
	}

	/** 
	 * Invokes new Runnable configuration
	 */
	public void start() {
//		init();	
	}
	
}
