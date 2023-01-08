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
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.GraphicsController;
import controller.PlayerController;
import model.ColorPalette;
import model.Player;
import model.TetrionViewModel;

/**
 * The view model class displays the current board
 */
public class TetrionView extends JPanel implements ActionListener, PropertyChangeListener, ChangeListener {
	
	/** Default serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	// TODO refactor string placeholder for property change value
	private static final String STRING = "STRING";
	
	/** Magic number millisecond delay */
	private static final int DELAY = 1000;
	
	/** Action command string constants */
	private static final String SELECT = "SELECT";
	private static final String DROP = "DROP";
	private static final String ROTATE = "ROTATE";
	private static final String EXIT = "EXIT";
	private static final String LEFT = "LEFT";
	private static final String DOWN = "DOWN";
	private static final String RIGHT = "RIGHT";
	
	/** Set the speed of the piece movement logic */
	private static Timer myActionTimer;
	/** Game timer move sequence delay */
	private static int delay;
	
	/** View model represent current game board piece position and logic */
	private TetrionViewModel myModel;
	
	/**
	 * TetrionView UI class displays current game board or "playfield"  
	 */
	public TetrionView() {
		
		// control timer
		delay = DELAY;
		myActionTimer = new Timer (delay, this);
		
		myModel = new TetrionViewModel();
		myModel.addChangeListener(this);
		
//		setSize(300, 600);	// full height
		setFocusable(true);	// KeyListener
		setLocation(500, 75);
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
		setBackground(ColorPalette.MEANWHILE.getColor());
		
		addKeyListener(new PlayerController(new Player()));	// dispatch user keyboard input action event thread 		
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
		if (theActionEvent.getSource() instanceof Timer) { 

			myModel.down();	// timer delay dependent 
			
			System.out.println(myModel.toString());
			
		} else if (theActionEvent.getSource() instanceof TetrionView) {
			
			String cmd = theActionEvent.getActionCommand().toUpperCase();	// The key cmd pressed
			
			if (myActionTimer.isRunning()) {
				
				switch(cmd) {
				
				case SELECT : myActionTimer.stop(); break;
				case EXIT : myModel.gameOver(); break;
				case LEFT : myModel.left(); break;
				case RIGHT : myModel.right(); break;
				case DOWN : myModel.down(); break;
				case ROTATE : myModel.rotate(); break;
				case DROP : myModel.drop(); break;
				
				}
				
			} else {
				
				switch(cmd) {

				case SELECT : myModel.newGame(); break;
				case EXIT : myActionTimer.restart(); break;
				
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
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
//		repaint();
		System.out.println(e.getSource());
		System.out.println(e.getClass());
	}
}
