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

import controller.GraphicsController;
import controller.PlayerController;
import model.TetrionViewModel;
import res.ColorPalette;

/**
 * The view model class displays the current board
 */
public class TetrionView extends JPanel implements ActionListener {
	
	/** Default serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** Magic number millisecond delay */
	private static final int DELAY = 5000;
	
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
	/** Next Tetromino preview window */
	private PiecePreview myPreview;
	/** Current game score tracker */
	private ScoreView myScore;
	
	/**
	 * TetrionView UI class displays current game board or "playfield"  
	 */
	protected TetrionView() {
		delay = DELAY;
		myModel = new TetrionViewModel();
		myPreview = new PiecePreview();
		myScore = new ScoreView();	// score level lines
		myTimer = new Timer (delay, this);
		
		setFocusable(true);	// KeyListener
		setLocation(500, 75);
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
		setBackground(ColorPalette.MEANWHILE.getColor());
		
		myPreview.setSize(200, 200);	// small window
		myScore.setSize(400, 100);	// transparent row line
		
		addKeyListener(new PlayerController());
		
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
	
	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		
		if (theActionEvent.getSource() instanceof Timer 
				&& myTimer.isRunning()) {
			
			myModel.down();
			
//			System.out.println(myModel.toString());
			
		} else if (theActionEvent.getSource() instanceof TetrionView) {
			
			String cmd = theActionEvent.getActionCommand();
			
			if (myTimer.isRunning()) {
				
				// switch case game on resume
				switch(cmd) {
				case SELECT : myTimer.stop(); break;
				case EXIT : myTimer.stop(); break; // TODO show options config
				case LEFT : myModel.left(); break;
				case RIGHT : myModel.right(); break;
				case DOWN : myModel.down(); break;
				case ROTATE : myModel.rotate(); break;
				case DROP : myModel.drop(); break;
				
				}
				
			} else {
				
				// switch case game on pause
				switch (cmd) {
				case EXIT : myModel.newGame(); break;
				case SELECT : myTimer.restart(); break;
				
				}
			}
		}
		
		repaint();
	}
}
