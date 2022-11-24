/*
 * BoardView.java
 * @author ddxbugs 
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import model.Block;
import res.ColorPalette;

/**
 * The view model class displays the current board
 */
public class BoardView extends JPanel {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 8563705674683776847L;
	/** The Tetris board as an array of blocks or rows */
	private Block[] myBoard;
	/**
	 * Default public constructor
	 * @param theBoard the tetris board block array representation
	 */
	public BoardView(final Block[] theBoard) {
		// default private constructor
		myBoard = theBoard;
	}
	
	/**
	 * Draws the Tetris BoardModel
	 */
	@Override
	public void paintComponent(final Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2D = (Graphics2D) theGraphics;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawBlocks(g2D);
	}
	
	private void drawBlocks(final Graphics2D theGraphics2D) {
		for (final Block block : myBoard) {
			
			switch(block) {
			case I: theGraphics2D.setColor(); break;
			case J: theGraphics2D.setColor(); break;
			case L: theGraphics2D.setColor(); break;
			case O: theGraphics2D.setColor(); break;
			case S: theGraphics2D.setColor(); break;
			case T: theGraphics2D.setColor(); break;
			case Z: theGraphics2D.setColor(); break;
			default: break;
			}
			
		}
	}
	
	private void setColor(final Graphics2D theG2D, final Block block) {
		
	}
}
