/**
 * 
 */
package controller;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;

import view.TetrisGame;

/**
 * Main driver for tron-tetris
 * @author ddxbugs
 * @version 0.1.0
 */
public class TetrisMain {
	/** Borderless screen min width and height */
	private static final int MIN_H = 300, MIN_W = 300;
	/** Full screen dimension */
	private static final Dimension FULL_SCREEN_SIZE = 
			Toolkit.getDefaultToolkit().getScreenSize();
	// TODO multiplayer mode
	private static final GraphicsDevice MONITOR_DISPLAY = 
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	// private constructor prevents instantiation and throws exception
	private TetrisMain() {
		System.err.println("error:" + IllegalStateException.class);
		throw new IllegalStateException();
	}

	/**
	 * @param args
	 */
	public static void main(String... args) {
		System.out.println("args: " + args);	// TODO debug, remove
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TetrisGame game = new TetrisGame();
				try {
					MONITOR_DISPLAY.setFullScreenWindow(game);
//					game.setSize(FULL_SCREEN_SIZE);
				} finally {
					MONITOR_DISPLAY.setFullScreenWindow(null);
//					game.setMinimumSize(new Dimension(MIN_H, MIN_W));
				}
				
			}
			
		});
	}

}
