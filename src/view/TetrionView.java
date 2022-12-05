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
	
	/** Magic number scale */
	private static final int SCALE = 10;
	
	/** Magic number millisecond delay */
	private static final int DELAY = 1000;
	
	/** Set the speed of the piece movement logic */
	private static Timer myTimer;
	/** Game timer move sequence delay */
	private static int delay;
	
	/** View model represent current game board piece position and logic */
	private TetrionViewModel myModel;
	
	/**
	 * TetrionView UI class displays current game board or "playfield"  
	 */
	protected TetrionView() {
		delay = DELAY;
//		myModel = new TetrionViewModel(theWidth, theHeight);	// TODO remove, hard code vals
		myModel = new TetrionViewModel(SCALE);
		myTimer = new Timer (delay, this);
		setFocusable(true);	// KeyListener
		setLocation(500, 75);
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
		setBackground(ColorPalette.MEANWHILE.getColor());
		
		addKeyListener(new PlayerController());
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
		
		// TODO algorithm draw only changed blocks
		GraphicsController.drawBlocks(g2D, 
										myModel.getFrozenBlocks(), SCALE,
										getWidth(), getHeight());
	}
	
	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		if (theActionEvent.getSource() instanceof Timer 
				&& myTimer.isRunning()) {
			myModel.down();
			System.out.println(theActionEvent);
			System.out.println(myModel.toString());
			
		} else if (theActionEvent.getSource() instanceof TetrionView) {
			
			String cmd = theActionEvent.getActionCommand();
			// switch case new game status
			switch (cmd) {
			case "exit" : myModel.newGame(); break;
			case "select" : myTimer.restart(); break;
			case "left": myModel.left(); break;
			case "right": myModel.right(); break;
			case "down": myModel.down(); break;
			case "rotate": myModel.rotate(); break;
			case "drop": myModel.drop(); break;
			
			}
			System.out.println(cmd);
		}
		
		repaint();
	}
}
