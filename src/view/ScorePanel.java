/*
 * ScorePanel.java
 * @author ddxbugs 
 */
package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;

/**
 *	Display the current game score
 */
public class ScorePanel extends JPanel {
	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Player myPlayer;
	private JLabel myScore;
	private JLabel myLevel;
	private JLabel myLines;
	
	protected ScorePanel() {
		super();
		
		myPlayer = new Player();
		myScore = new JLabel();
		myLevel = new JLabel();
		myLines = new JLabel();
		
		myScore.setSize(100, 100);
		myScore.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		setSize(300, 300);
	}
	
	private void update() {
		// update score label
		// check player level++ and update max_score
		// update level label
		// update lines cleared label
	}
	
	private void reset() {
		// TODO reset the lines cleared label
		// TODO reset the score label
		// TODO reset the level label
		
		// TODO close pointer
		myPlayer = null;
	}
}
