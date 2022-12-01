/*
 * PiecePreview.java
 * @author ddxbugs 
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import model.PiecePreviewModel;
import res.ColorPalette;

/**
 * PiecePreview class displays next tetromino on board
 */
public class PiecePreview extends JPanel {
	
	private PiecePreviewModel myModel;
	/**
	 * Preview panel class displays next tetromino during game
	 */
	public PiecePreview() {
		// TODO Auto-generated constructor stub
		super();
		
		myModel = new PiecePreviewModel();
		
		setLocation(900, 300);
		setBackground(ColorPalette.MEANWHILE.getColor());
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
//		setVisible(true);
		
	}
	
	@Override
	public void paintComponent(final Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
		// select tetromino 
		// fill and draw the rects
	}
}
