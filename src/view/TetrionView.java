/*
 * TetrionView.java
 * @author ddxbugs 
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

import controller.GraphicsController;
import controller.PlayerController;
import model.Mino;
import model.TetrionViewModel;
import res.ColorPalette;

/**
 * The view model class displays the current board
 */
public class TetrionView extends JPanel implements ActionListener {
	
	/** Default serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** Set Mino block scale to screen dimension */
	private static final int SCALE = 0;
	/** Magic number 1 second delay */
	private static final int THOUSAND = 1000;
	
	/** Set the speed of the piece movement logic */
	private static Timer myTimer;
	/** Game timer move sequence delay */
	private static int delay;
	
	/** View model represent current game board piece position and logic */
	private TetrionViewModel myModel;
	
	/**
	 * TetrionView UI class displays current game board or "playfield"  
	 */
	protected TetrionView(final int theWidth, final int theHeight) {
		delay = THOUSAND;
//		myModel = new TetrionViewModel(theWidth, theHeight);	// TODO remove, hard code vals
		myModel = new TetrionViewModel(10, 20);
		myTimer = new Timer (delay, this);
		
		setFocusable(true);	// KeyListener
		setLocation(500, 75);
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
		setBackground(ColorPalette.MEANWHILE.getColor());
		
		addKeyListener(new PlayerController(this));
//		addFocusListener();	// TODO window focus music, pause listener
		
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
		GraphicsController.drawBlocks(g2D, myModel.getFrozenBlocks(), 0, 0, 0, 0);
	}
	
	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
//		System.out.println("TetrionView ActionEvent: " + theActionEvent);
		myModel.down();
//		repaint();
//		System.out.println(myModel.toString());
	}
}
