/*
 * GraphicsController.java
 * @author ddxbugs 
 */
package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.Timer;

import model.ColorPalette;
import model.Mino;
import model.PreviewModel;
import model.ScoreViewModel;
import model.TetrionViewModel;
import view.Preview;
import view.ScoreView;
import view.TetrionView;

/**
 *	Game graphics model view controller class 
 */
public class GraphicsController {
	// TODO refactor placeholder name
	private static final String STRING = "STRING";
	
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
									final int theModelScale,
									final int theViewScale) {
		
		
		int startX = 0, startY = 0;	// starting x, y position 
		int incrementX = theModelScale;	// block rectangle width scaled 1/10
		int incrementY = theModelScale; // block rectangle height scaled 1/10
		int width = theViewScale; // TetrionGrid board width default 300px
		
		for (Mino block : theFrozenBlocks) {
			
			if (block == null) block = Mino.EMPTY;	// TODO error block null initialized, but make block final
			
			switch(block) {
			
			case EMPTY:
				theG2D.setColor(ColorPalette.DEAD_BABY.getColor());
				break;
			case I: 
				theG2D.setColor(ColorPalette.ANNOYING_WITH.getColor()); 
				break;
			case J: 
				theG2D.setColor(ColorPalette.NOW_EVEN_MORE.getColor()); 
				break;
			case L: theG2D.setColor(ColorPalette.SWEET_YELLOW.getColor()); 
				break;
			case O: 
				theG2D.setColor(ColorPalette.FAR_AWAY_SKY.getColor()); 
				break;
			case S: 
				theG2D.setColor(ColorPalette.WIPE_OUT.getColor()); 
				break;
			case T: 
				theG2D.setColor(ColorPalette.VOLUME_CONTROL.getColor()); 
				break;
			case Z: 
				theG2D.setColor(ColorPalette.ORANGE_TRON_LEGACY.getColor()); 
				break;
			default: 
				theG2D.setColor(Color.RED);	// Debug, remove me
				break;
			}
			
			final Rectangle2D r2D = new Rectangle(startX, startY, startX + incrementX, startY + incrementY);
			final Color fill = theG2D.getColor();
			
			theG2D.fill(r2D);
			theG2D.setColor(ColorPalette.MEANWHILE.getColor());	// create the outline
			theG2D.draw(r2D);
			theG2D.setColor(fill);
			
			// increment column counter, resets x % width 
			startX += incrementX;
			if (startX % width == 0) {
				startX = 0;	
				startY += incrementY;
			}
		}
		
//		theG2D.dispose();
	}

}
