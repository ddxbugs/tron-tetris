/*
 * ScoreView.java
 * @author ddxbugs 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import res.ColorPalette;

/**
 *	Display the current game score
 */
public class ScoreView extends JPanel implements ActionListener, PropertyChangeListener {
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
	private JLabel myScore;
	private JLabel myLevel;
	private JLabel myLines;
	
	public ScoreView() {
		super();
		
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

	private void reset() {
		// TODO reset the lines cleared label
		// TODO reset the score label
		// TODO reset the level label
		// TODO close pointers
	}

	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		// TODO action event dispatch threading  
		
	}

	@Override
	public void propertyChange(final PropertyChangeEvent theEvent) {
		// TODO score view component property change event 
		
	}

}
