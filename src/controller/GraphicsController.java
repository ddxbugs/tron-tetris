/*
 * GraphicsController.java
 * @author ddxbugs 
 */
package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import model.Mino;
import res.ColorPalette;

/**
 *	Graphics controller utility class 
 */
public class GraphicsController {
	/**
	 * private utility class default constructor
	 */
	private GraphicsController() {
		// prevent instantiation
		throw new IllegalStateException();
	}
	
	/**
	 * Color and fill the individual blocks in the game board 
	 * @param theG2D Returns corresponding piece color for the block
	 */
	public static void drawBlocks(final Graphics2D theG2D, 
									final Mino[] theFrozenBlocks,
									final int theBlockWidth,
									final int theRowWidth) {
		
		int x = 0, y = 0;	// starting x, y position 
		int incrementX = theBlockWidth;	// block rectangle width scaled 1/10
		int incrementY = theBlockWidth; // block rectangle height scaled 1/10
		int width = theRowWidth; // Tetrion board width default 300px
		
		for (Mino block : theFrozenBlocks) {
			
			if (block == null) block = Mino.EMPTY;	// TODO error block null initialized, but make block final
			
			switch(block) {
			
			case EMPTY:
				theG2D.setColor(ColorPalette.MEANWHILE.getColor());
			case I: 
				theG2D.setColor(ColorPalette.BASESTAR.getColor()); 
				break;
			case J: 
				theG2D.setColor(ColorPalette.PANE.getColor()); 
				break;
			case L: theG2D.setColor(ColorPalette.SWEET_YELLOW.getColor()); 
				break;
			case O: 
				theG2D.setColor(ColorPalette.FAR_AWAY_SKY.getColor()); 
				break;
			case S: 
				theG2D.setColor(ColorPalette.DEAD_BABY.getColor()); 
				break;
			case T: 
				theG2D.setColor(ColorPalette.TRON_BLUE.getColor()); 
				break;
			case Z: 
				theG2D.setColor(ColorPalette.ORANGE_TRON_LEGACY.getColor()); 
				break;
			default: 
				theG2D.setColor(Color.RED);	// Debug, remove me
				break;
			}
			
			final Rectangle2D r = new Rectangle(x, y, x + incrementX, y + incrementY);
			
			theG2D.fill(r);
			theG2D.setBackground(ColorPalette.PANE.getColor());
			theG2D.draw(r);
			
			// increment column counter, resets x % width 
			x += incrementX;
			if (x % width == 0) {
				x = 0;	
				y += incrementY;
			}
		}
		
		theG2D.dispose();
	}

}
