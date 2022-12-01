/*
 * TetrionView.java
 * @author ddxbugs 
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

import model.TetrionViewModel;
import res.ColorPalette;

/**
 * The view model class displays the current board
 */
public class TetrionView extends JPanel implements ActionListener {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Set Mino block scale to screen dimension
	 */
	private static final double SCALE = 0.0;
	
	private static final int DELAY = 0;
	/**
	 * Tetrion board view model represent current game board piece position and logic
	 */
	private TetrionViewModel myModel;
	/**
	 * Set the speed of the piece movement logic
	 */
	private Timer myTimer;
	/**
	 * TetrionView UI class displays current game board or "playfield"  
	 */
	protected TetrionView(final int theWidth, final int theHeight) {
		myModel = new TetrionViewModel(theWidth, theHeight);
		myTimer = new Timer(DELAY, this);
		
		setLocation(500, 75);
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
		setBackground(ColorPalette.MEANWHILE.getColor());
		
		
	}
	/**
	 * Draw each individual Tetromino Mino blocks on the playfield
	 */
	@Override
	public void paintComponent(final Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2D = (Graphics2D) theGraphics;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawBlocks(g2D);
	}
	
	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		myModel.down();
		repaint();
	}
	
	/**
	 * Colorizes the individual blocks in the game board 
	 * @param theGraphics2D Returns corresponding piece color for the block
	 */
	private void drawBlocks(final Graphics2D theGraphics2D) {
		int x = 0, y = 0;
		int w, h;	// TODO get board width height
		System.out.println("drawBlocks()");
		
		
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
