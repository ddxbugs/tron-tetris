/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

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
