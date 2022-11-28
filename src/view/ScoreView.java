/*
 * ScoreView.java
 * @author ddxbugs 
 */
package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Player;
import res.ColorPalette;

/**
 *	Display the current game score
 */
public class ScoreView extends JPanel {
	// TODO decompose literal string
	/** CrNNtn-regular font family name */
	private static final String REGULAR = "CRRNTN-Regular";
	/** CrNNtn font family name */
	private static final String OUTLINE = "CRRNTN-Outline";
	/** Score text font size */
	private static final int FONT_PT_14 = 14;
	private static final int FONT_PT_12 = 12;

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Player myPlayer;
	private JLabel myScore;
	private JLabel myLevel;
	private JLabel myLines;
	
	protected ScoreView() {
		super();
		
		myPlayer = new Player();
		myScore = new JLabel("SCORE");
		myLevel = new JLabel("LEVEL");
		myLines = new JLabel("LINES");
		
		setLocation(800, 100);
		setBackground(Color.RED);	
		
		myScore.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_14));
		myLevel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_12));
		myLines.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_12));
		
		myScore.setForeground(ColorPalette.PANE.getColor());
		myLevel.setForeground(ColorPalette.FAR_AWAY_SKY.getColor());
		myLines.setForeground(ColorPalette.VOLUME_CONTROL.getColor());

		setOpaque(false);
		
		add(myScore);
		add(myLevel);
		add(myLines);
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
