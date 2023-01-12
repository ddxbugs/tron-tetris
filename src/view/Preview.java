/*
 * Preview.java
 * @author ddxbugs 
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controller.GraphicsController;
import model.ColorPalette;
import model.PreviewModel;
import model.Tetromino;

/**
 * Preview class displays next tetromino on board
 */
public class Preview extends JPanel implements ActionListener, PropertyChangeListener {
	
	/**	Default serial version id */
	private static final long serialVersionUID = 1L;

	private PreviewModel myModel;
	private Tetromino myNextTetromino;
	
	/**
	 * Preview panel class displays next tetromino during game
	 */
	public Preview() {
		// TODO Auto-generated constructor stub
		super();
		
//		myModel = new PreviewModel();
		myModel = new PreviewModel();
		myNextTetromino = null;
		
//		setSize(200, 200);	// small window
		setLocation(900, 300);
		setBackground(ColorPalette.MEANWHILE.getColor());
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
		
		
//		setVisible(true);
		
	}
	/**
	 * 
	 */
	@Override
	public void paintComponent(final Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		if (myNextTetromino != null) {
			System.out.println(myNextTetromino.toString());
		}
		
			GraphicsController.drawBlocks(g2d, myModel.getPreviewBlocks(), getWidth() / myModel.getWidth(), getHeight());
	}

	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		// TODO add next tetromino object to preview component
		if (theActionEvent.getSource() instanceof Tetromino) {
			final Tetromino nextTetromino = (Tetromino) theActionEvent.getSource();
			myNextTetromino = nextTetromino;
		}
//		repaint();
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

		// TODO change border, font, color on player level property change event 
//		repaint();
	}
}
