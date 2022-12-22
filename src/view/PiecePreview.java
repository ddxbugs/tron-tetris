/*
 * PiecePreview.java
 * @author ddxbugs 
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controller.GraphicsController;
import model.Mino;
import res.ColorPalette;

/**
 * PiecePreview class displays next tetromino on board
 */
public class PiecePreview extends JPanel implements ActionListener, PropertyChangeListener {
	
	/**	Default serial version id */
	private static final long serialVersionUID = 1L;

//	private PiecePreviewModel myModel;
	
	private Mino[] myNextTetromino;
	/**
	 * Preview panel class displays next tetromino during game
	 */
	public PiecePreview() {
		// TODO Auto-generated constructor stub
		super();
		
//		myModel = new PiecePreviewModel();
		myNextTetromino = null;
		
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
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		if (myNextTetromino != null)
			GraphicsController.drawBlocks(g2d, myNextTetromino, getHeight(), getWidth());
	}

	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		// TODO Auto-generated method stub
		if (theActionEvent.getSource() instanceof Mino[]) {
			final Mino[] nextTetromino = (Mino[]) theActionEvent.getSource();
			myNextTetromino = nextTetromino;
		}
		repaint();
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		// TODO change border, font, color on player level property change event 
	}
}
