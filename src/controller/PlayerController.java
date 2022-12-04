/*
 *	PlayerController.java
 *	@author ddxbugs 
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.TetrionView;

/**
 *	Player configuration view model controller
 */
public class PlayerController implements KeyListener {
	
	// default game controller settings
	private static final int UP = KeyEvent.VK_UP;
	private static final int DOWN = KeyEvent.VK_DOWN;
	private static final int LEFT = KeyEvent.VK_LEFT;
	private static final int RIGHT = KeyEvent.VK_RIGHT;
	private static final int SPACE = KeyEvent.VK_SPACE;
	private static final int ESC = KeyEvent.VK_ESCAPE;
	private static final int W = KeyEvent.VK_W;
	private static final int A = KeyEvent.VK_A;
	private static final int S = KeyEvent.VK_S;
	private static final int D = KeyEvent.VK_D;
	
	/**
	 * Player configuration and settings view model controller
	 */
	public PlayerController(final TetrionView theTetrionView) {
		super();
		theTetrionView.addKeyListener(this);
	}
	
	/**
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getComponent());
		
		System.out.println(e.getKeyChar());
		final int key = e.getKeyChar();
		
		switch(key) {
		case UP : break;
		case SPACE : break;
		case DOWN : break;
		case LEFT : break;
		case RIGHT : break;
		case ESC : break;
		case W : break;
		case A : break;
		case S : break;
		case D : break;
		case default: break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
