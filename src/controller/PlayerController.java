/*
 *	PlayerController.java
 *	@author ddxbugs 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Player;
import view.TetrionView;

/**
 *	Player configuration view model controller
 */
public class PlayerController implements KeyListener {
	/** TetrionView component string action commands */ 
	private static final String SELECT = "SELECT";
	private static final String DROP = "DROP";
	private static final String ROTATE = "ROTATE";
	private static final String EXIT = "EXIT";
	private static final String CONFIRM = "CONFIRM";
	private static final String CANCEL = "CANCEL";
	private static final String UP = "UP";
	private static final String LEFT = "LEFT";
	private static final String DOWN = "DOWN";
	private static final String RIGHT = "RIGHT";

	// default keyboard game controller settings
	private static final int SPACE = KeyEvent.VK_SPACE;
	private static final int ESC = KeyEvent.VK_ESCAPE;
	private static final int ENTER = KeyEvent.VK_ENTER;
	private static final int W = KeyEvent.VK_W;
	private static final int A = KeyEvent.VK_A;
	private static final int S = KeyEvent.VK_S;
	private static final int D = KeyEvent.VK_D;
	/**
	 * The current player
	 */
	private Player myPlayer;
	
	/**
	 * Default public player constructor api
	 */
	public PlayerController(final Player thePlayer) {
		super();
		myPlayer = thePlayer;
	}
	
	/**
	 * Private constructor
	 */
	private PlayerController() {
		throw new IllegalStateException();
	}
	
	/**
	 * Handle TetrionView component key pressed action events
	 */
	@Override
	public void keyPressed(KeyEvent theKeyEvent) {
		
	}

	@Override
	public void keyTyped(final KeyEvent theKeyEvent) {
		// TODO Auto-generated method stub
		if (theKeyEvent.getComponent() instanceof TetrionView) {
					
					final int key = Character.toUpperCase(theKeyEvent.getKeyChar());	// Register lower case character values
					final TetrionView view = (TetrionView) theKeyEvent.getComponent();	// View component listener
					
					switch(key) {
					case SPACE : 
						view.actionPerformed(new ActionEvent(view, key, DROP));	// drop
						break;
					case ENTER : 
						view.actionPerformed(new ActionEvent(view, key, SELECT));	// select, confirm
						break;
					case ESC : 
						view.actionPerformed(new ActionEvent(view, key, EXIT));	// escape, quit
						break;
					case W: 
						view.actionPerformed(new ActionEvent(view, key, ROTATE));	// rotate
						break;
					case A : 
						view.actionPerformed(new ActionEvent(view, key, LEFT));	// left
						break;
					case S : 
						// TODO drop manuever
						view.actionPerformed(new ActionEvent(view, key, DOWN));	// down or hold drop
						break;
					case D : 
						view.actionPerformed(new ActionEvent(view, key, RIGHT));	// right
						break;
					}
				}
				
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
