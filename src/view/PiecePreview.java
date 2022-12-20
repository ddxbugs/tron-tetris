/*
 * PiecePreview.java
 * @author ddxbugs 
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import model.PiecePreviewModel;
import model.Tetromino;
import res.ColorPalette;

/**
 * PiecePreview class displays next tetromino on board
 */
public class PiecePreview extends JPanel implements ActionListener {
	
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

	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		// TODO Auto-generated method stub
		if (theActionEvent.getSource() instanceof Tetromino) {
			repaint();
		}
		
	}
}
