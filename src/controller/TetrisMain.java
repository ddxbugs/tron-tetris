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
	private static final String NIMBUS_LAF = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	/** CrNNtn-regular font relative file path */
	private static final String PATH_REGULAR_TTF = "src/res/regular.ttf";
	/** CrNNtn-outline font relative file path */
	private static final String PATH_OUTLINE_TTF = "src/res/outline.ttf";
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
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				TetrisGame game = new TetrisGame(GRAPHICS_ENVIRONMENT);
				GraphicsDevice device = GRAPHICS_ENVIRONMENT.getDefaultScreenDevice();
				int status = 1;
				try {	
					Path pathRegularTTF = Paths.get(PATH_REGULAR_TTF);	// get path to tron regular font file
					Path pathOutlineTTF = Paths.get(PATH_OUTLINE_TTF);	// get path to tron outline font file
					GRAPHICS_ENVIRONMENT.registerFont(Font.createFont(Font.TRUETYPE_FONT, pathRegularTTF.toFile()));	// set font look and feel
					GRAPHICS_ENVIRONMENT.registerFont(Font.createFont(Font.TRUETYPE_FONT, pathOutlineTTF.toFile()));	// set font look and feel
					UIManager.setLookAndFeel(NIMBUS_LAF);	// set ui look and feel
//					game.setPreferredSize(FULL_SCREEN_SIZE);
//					game.setMinimumSize(MIN_SCREEN_SIZE);
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
					status = 0;
				}
				
				if (status == 1) {
					System.err.println("error code system status");
					System.exit(status);	// error code
				}
				game.start();	// run the program
			}	
		});
		
		
	}

}
