/**
 * 
 */
package controller;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.TetrisGame;

/**
 * Main driver for tron-tetris
 * @author ddxbugs
 * @version 0.1.0
 */
public class TetrisMain {
	/** Borderless screen min width and height */
	private static final int MIN_H = 300, MIN_W = 300;
	/** Borderless screen min dimension */
	private static final Dimension MIN_SCREEN_SIZE = new Dimension(MIN_W, MIN_H);
	/** Full screen dimension */
	private static final Dimension FULL_SCREEN_SIZE = 
			Toolkit.getDefaultToolkit().getScreenSize();
	// TODO multiplayer mode
	private static final GraphicsDevice MONITOR_DISPLAY = 
			GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	
	// private constructor prevents instantiation throws exception
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
					
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");					
					game.setPreferredSize(FULL_SCREEN_SIZE);
					game.setMinimumSize(MIN_SCREEN_SIZE);
					MONITOR_DISPLAY.setFullScreenWindow(game);
					
				} catch (final UnsupportedLookAndFeelException e) {
					System.err.println("UnsupportedLookAndFeelException:" + e);
					e.printStackTrace();
				} catch (final ClassNotFoundException e) {
					System.err.println("ClassFoundException:" + e);
					e.printStackTrace();
				} catch (final InstantiationException e) {
					System.err.println("InstantiationException:" + e);
					e.printStackTrace();
				} catch (final IllegalAccessException e) {
					System.err.println("IllegalAccessException:" + e);
					e.printStackTrace();
				} finally {
					MONITOR_DISPLAY.setFullScreenWindow(null);
				}
				game.start();
			}
			
		});
	}

}
