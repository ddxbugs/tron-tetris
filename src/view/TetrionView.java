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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import controller.GraphicsController;
import controller.PlayerController;
import model.TetrionViewModel;
import res.ColorPalette;

/**
 * The view model class displays the current board
 */
public class TetrionView extends JPanel implements ActionListener, PropertyChangeListener {
	
	/** Default serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** Magic number millisecond delay */
	private static final int DELAY = 5000;
	// TODO refactor string placeholder
	private static final String STRING = "string";
	/** Action command string constants */
	private static final String SELECT = "select";
	private static final String DROP = "drop";
	private static final String ROTATE = "rotate";
	private static final String EXIT = "exit";
	private static final String LEFT = "left";
	private static final String DOWN = "down";
	private static final String RIGHT = "right";
	
	/** Set the speed of the piece movement logic */
	private static Timer myTimer;
	/** Game timer move sequence delay */
	private static int delay;
	
	/** View model represent current game board piece position and logic */
	private TetrionViewModel myModel;
	
	/**
	 * TetrionView UI class displays current game board or "playfield"  
	 */
	public TetrionView() {
		delay = DELAY;
		myModel = new TetrionViewModel();
		
		myTimer = new Timer (delay, this);
		
//		setSize(300, 600);	// full height
		setFocusable(true);	// KeyListener
		setLocation(500, 75);
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
		setBackground(ColorPalette.MEANWHILE.getColor());
		
		addKeyListener(new PlayerController());	// dispatch user keyboard input action event thread 
		addPropertyChangeListener(this);	// change this view components property graphics
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
		// TODO algorithm optimize static draw blocks
		GraphicsController.drawBlocks(g2D, 
										myModel.getFrozenBlocks(),
										getWidth() / myModel.getWidth(),
										getWidth());
	}
	/**
	 * Timer action event dispatch threads perform game graphic mechanics   
	 */
	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		
		// case timer new game start running
		if (theActionEvent.getSource() instanceof Timer 
				&& myTimer.isRunning()) {
			
			myModel.down();	// timer delay dependent 
			
			System.out.println(myModel.toString());
			
		} else if (theActionEvent.getSource() instanceof TetrionView) {
			
			String cmd = theActionEvent.getActionCommand();	// The key cmd pressed
			
			if (myTimer.isRunning()) {
				// TODO Fix key listener logics
				// switch case game on resume
				switch(cmd) {
				case SELECT : myTimer.stop(); break;
				case EXIT : myTimer.stop(); break; 
				case LEFT : myModel.left(); break;
				case RIGHT : myModel.right(); break;
				case DOWN : myModel.down(); break;
				case ROTATE : myModel.rotate(); break;
				case DROP : myModel.drop(); break;
				
				}
				
			} else {
				// TODO Fix key listener logic
				// switch case game on pause
				switch (cmd) {
				case EXIT : myModel.newGame(); break;
				case SELECT : myTimer.restart(); break;
				
				}
			}
		}
		
		repaint();	// repaint game display
	}
	/**
	 * Property change view component graphic ui effects
	 */
	@Override
	public void propertyChange(final PropertyChangeEvent theEvent) {
		// TODO update border size (PvP) style color effects
		final String property = theEvent.getPropertyName();
		switch (property) {
		case STRING : 
			setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, 
				ColorPalette.ORANGE_TRON_LEGACY.getColor(), ColorPalette.SWEET_YELLOW.getColor())); 
			break;
		default : 
			break;	
		}
		
	}
}
