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
	
	/** CrNNtn-regular font family name */
	private static final String REGULAR = "CRRNTN-Regular";
	/** CrNNtn font family name */
	private static final String OUTLINE = "CRRNTN-Outline";
	/**
	 * Score view component text label
	 */
	private static final String SCORE = "SCORE";
	private static final String LEVEL = "LEVEL";
	private static final String LINES = "LINES";
	
	/** Score label font pt size */
	private static final int FONT_PT_16 = 16;
	private static final int FONT_PT_14 = 14;
	private static final int FONT_PT_12 = 12;

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** The score label */
	private JLabel myScoreLabel;
	/** The level label */
	private JLabel myLevelLabel;
	/** The line label */
	private JLabel myLinesLabel;
	/** The current score label */
	private JLabel myCurrentScore;
	/** The current level */
	private JLabel myCurrentLevel;
	/** The current lines completed */
	private JLabel myCurrentLines;
	/**
	 * Score view label component default constructor class
	 */
	public ScoreView() {
		super();
		
		myScoreLabel = new JLabel(SCORE);
		myLevelLabel = new JLabel(LEVEL);
		myLinesLabel = new JLabel(LINES);
		
		myCurrentScore = new JLabel();
		myCurrentLevel = new JLabel();
		myCurrentLines = new JLabel();
		
		setLocation(800, 100);
		
		// set font style
		myScoreLabel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_14));
		myLevelLabel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_12));
		myLinesLabel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_12));
		
		// set text foreground colors
		myScoreLabel.setForeground(ColorPalette.PANE.getColor());
		myLevelLabel.setForeground(ColorPalette.FAR_AWAY_SKY.getColor());
		myLinesLabel.setForeground(ColorPalette.VOLUME_CONTROL.getColor());
		
		// add view component property change event 
		myScoreLabel.addPropertyChangeListener(this);
		myLevelLabel.addPropertyChangeListener(this);
		myLinesLabel.addPropertyChangeListener(this);
		
		// transparent hover effect
		setOpaque(false);
		
		// add to view panel
		add(myScoreLabel);
		add(myLevelLabel);
		add(myLinesLabel);
	}
	
	private void updateScore(final String theUpdatedScore) {
		myCurrentScore.setText(theUpdatedScore);
	}
	
	private void updateLevel(final String theNewLevel) {
		myCurrentLevel.setText(theNewLevel);
	}
	
	private void updateLines(final String theLinesCompleted) {
		myCurrentLines.setText(theLinesCompleted);
	}
	/**
	 * 
	 */
	@Override
	public void actionPerformed(final ActionEvent theActionEvent) {
		// TODO action event dispatch threading  
		final String cmd = theActionEvent.getActionCommand();
		final Object obj = theActionEvent.getSource();
		final int id = theActionEvent.getID();
		if (obj != null && obj instanceof JLabel ) {
			System.out.println(cmd);
			System.out.println(obj.toString());
			System.out.println(id);
			switch (cmd) {
			// TODO SCORE
			// TODO LEVEL
			// TODO LINES
			default: break;
			}
		}
	}

	@Override
	public void propertyChange(final PropertyChangeEvent theEvent) {
		// TODO score view component property change event 
		myScoreLabel.setForeground(ColorPalette.ORANGE_TRON_LEGACY.getColor());
		myLevelLabel.setForeground(ColorPalette.SWEET_YELLOW.getColor());
		myLinesLabel.setForeground(ColorPalette.SIX_SOUND_CHOICES.getColor());
		
		myScoreLabel.setFont(new Font(OUTLINE, Font.TRUETYPE_FONT, FONT_PT_16));
		myLevelLabel.setFont(new Font(OUTLINE, Font.TRUETYPE_FONT, FONT_PT_14));
		myLinesLabel.setFont(new Font(OUTLINE, Font.TRUETYPE_FONT, FONT_PT_14));
	}
}
