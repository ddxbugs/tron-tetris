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
	private static final int TIME_DELAY = 1000;
	
	/** Full screen configuration settings and variables */
	private static final int BLOCK_SIZE = 1;
	private static final int SCALE = 1;
	

	/**
	 * @throws HeadlessException
	 */
	public TetrisGame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Disney's Tron: Legacy Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setResizable(false);
		setLocationRelativeTo(null);
		
		pack();
		
	}

	/** 
	 * Invokes new Runnable configuration
	 */
	public void start() {
		setVisible(true);
	}
	
}
