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
	 * @param theGraphics2D Returns corresponding piece color for the block
	 */
	public static void drawBlocks(final Graphics2D theGraphics2D, final Mino[] theFrozenBlocks,
								final int theX, final int theY, final int theWidth, final int theHeight) {
		int x = theX, y = theY;	// starting x, y position 
		int width = theWidth;	// block rectangle width 
		int heigth = theHeight; // block rectangle height 
		
		for (Mino block : theFrozenBlocks) {
			
			if (block == null) block = Mino.EMPTY;	// TODO error block null initialized, but make block final
			
			switch(block) {
			
			case EMPTY:
				theGraphics2D.setColor(ColorPalette.MEANWHILE.getColor());
			case I: 
				theGraphics2D.setColor(ColorPalette.BASESTAR.getColor()); 
				break;
			case J: 
				theGraphics2D.setColor(ColorPalette.PANE.getColor()); 
				break;
			case L: theGraphics2D.setColor(ColorPalette.SWEET_YELLOW.getColor()); 
				break;
			case O: 
				theGraphics2D.setColor(ColorPalette.FAR_AWAY_SKY.getColor()); 
				break;
			case S: 
				theGraphics2D.setColor(ColorPalette.DEAD_BABY.getColor()); 
				break;
			case T: 
				theGraphics2D.setColor(ColorPalette.TRON_BLUE.getColor()); 
				break;
			case Z: 
				theGraphics2D.setColor(ColorPalette.WIPE_OUT.getColor()); 
				break;
			default: 
				theGraphics2D.setColor(Color.RED);	// Debug, remove me
				break;
			}
			
			final Rectangle2D r = new Rectangle(width, y, width, heigth);
			theGraphics2D.fill(r);
			theGraphics2D.draw(r);
			x += width;
			// reset column counter, increment next row counter
			if (x % width == 0) {
				x = 0;	
				y += heigth;
			}
		}
	}

}
