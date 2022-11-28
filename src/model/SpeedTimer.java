/**
 * 
 */
package model;

import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * @author User
 *
 */
public class SpeedTimer extends Timer {
	private static int lockDelay;
	
	/**
	 * @param delay
	 * @param listener
	 */
	public SpeedTimer(int delay, ActionListener listener) {
		super(delay, listener);
		// TODO Auto-generated constructor stub
	}

}
