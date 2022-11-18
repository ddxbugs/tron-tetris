/**
 * 
 */
package controller;

import javax.swing.SwingUtilities;

/**
 * Main driver for tron-tetris
 * @author ddxbugs
 * @version 0.1.0
 */
public class TetrisMain {
	// private constructor prevents instantiation and throws exception
	private TetrisMain() {
		throw new IllegalStateException();
	}

	/**
	 * @param args
	 */
	public static void main(String... args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
//				final TetrisGame game = new TetrisGame();
//				game.start();
				System.out.println("args: " + args);	// TODO debug, remove
			}
		});
	}

}
