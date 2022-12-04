/*
 * KeyboardListener.java
 * @author ddxbugs 
 */
package model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *	Listener for keyboard
 */
public class KeyboardListener implements KeyListener {
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
	 * 
	 */
	public KeyboardListener() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
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
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
