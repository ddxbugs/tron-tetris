/*
 * TetrionView.java
 * @author ddxbugs 
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import model.Mino;
import res.ColorPalette;

/**
 * The view model class displays the current board
 */
public class TetrionView extends JPanel {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Mino[] myBoard;
	
	/**
	 * Board view model constructor
	 */
	protected TetrionView() {
		// load the image
		setLocation(500, 75);
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, ColorPalette.PANE.getColor(), ColorPalette.CYAN_TRON_LEGACY.getColor()));
		setBackground(ColorPalette.MEANWHILE.getColor());
	}
	/**
	 * Draws the Tetris TetrionViewModel
	 */
	@Override
	public void paintComponent(final Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2D = (Graphics2D) theGraphics;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawBlocks(g2D);
	}
	
	/**
	 * Colorizes the individual blocks in the game board 
	 * @param theGraphics2D Returns corresponding piece color for the block
	 */
	private void drawBlocks(final Graphics2D theGraphics2D) {
		int x = 0, y = 0, w = 8, h = 15;	// TODO w,h hard coded
		
//		for (final Mino block : myBoard) {
//			switch(block) {
//			case I: 
//				theGraphics2D.setColor(ColorPalette.BASESTAR.getColor()); 
//				break;
//			case J: 
//				theGraphics2D.setColor(ColorPalette.PANE.getColor()); 
//				break;
//			case L: theGraphics2D.setColor(ColorPalette.SWEET_YELLOW.getColor()); 
//				break;
//			case O: 
//				theGraphics2D.setColor(ColorPalette.FAR_AWAY_SKY.getColor()); 
//				break;
//			case S: 
//				theGraphics2D.setColor(ColorPalette.MEANWHILE.getColor()); 
//				break;
//			case T: 
//				theGraphics2D.setColor(ColorPalette.TRON_BLUE.getColor()); 
//				break;
//			case Z: 
//				theGraphics2D.setColor(ColorPalette.WIPE_OUT.getColor()); 
//				break;
//			default: 
//				theGraphics2D.setColor(Color.RED);	// Debug, remove me
//				break;
//			}
//			final Rectangle2D r = new Rectangle(x, y, w, h);
//			theGraphics2D.fill(r);
//			theGraphics2D.draw(r);
//			x += w;
//			// reset column counter, increment next row counter
//			if (x % w == 0) {
//				x = 0;	
//				y += h;
//			}
//		}
		
	}
}
