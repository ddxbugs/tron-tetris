/*
 * TetrisMain.java
 * @author ddxbugs 
 */
package controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	/** UIManager Nimbus Look and Feel setting*/
	private static final String NIMBUS = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	/** TR2N font file path */
	private static final String TR2N = "src/res/CrrNtoutline.ttf";
	/** Borderless screen min dimension */
	private static final Dimension MIN_SCREEN_SIZE = new Dimension(MIN_W, MIN_H);
	/** Full screen dimension */
	private static final Dimension FULL_SCREEN_SIZE = 
			Toolkit.getDefaultToolkit().getScreenSize();
	/** The graphics environment */
	private static final GraphicsEnvironment GRAPHICS_ENVIRONMENT = 
			GraphicsEnvironment.getLocalGraphicsEnvironment();
	
	// private constructor prevents instantiation throws exception
	private TetrisMain() {
		System.err.println("error:" + IllegalStateException.class);
		throw new IllegalStateException();
	}

	/**
	 * @param args
	 */
	public static void main(String... args) {
//		System.out.println("args: " + args);	// TODO debug, remove
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				TetrisGame game = new TetrisGame(GRAPHICS_ENVIRONMENT);
				GraphicsDevice device = GRAPHICS_ENVIRONMENT.getDefaultScreenDevice();
				try {	
					Path path = Paths.get(TR2N);	// get path to font tff file
					GRAPHICS_ENVIRONMENT.registerFont(Font.createFont(Font.TRUETYPE_FONT, path.toFile()));	// set font look and feel
					UIManager.setLookAndFeel(NIMBUS);	// set ui look and feel
					game.setPreferredSize(FULL_SCREEN_SIZE);
					game.setMinimumSize(MIN_SCREEN_SIZE);
					device.setFullScreenWindow(game);	// attempt to set game to full screen mode
				} catch (final FontFormatException e) {
					System.err.println("FontFormatException:" + e);
					e.printStackTrace();
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
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("IOException:" + e);
					e.printStackTrace();
				} finally {
					device.setFullScreenWindow(null);
				}
				
				game.start();
			}
			
		});
	}

}
