/*
 * ScoreView.java
 * @author ddxbugs 
 */
package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ScoreViewModel;
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
	
	/** The persistent score view model */
	private ScoreViewModel myModel;
	
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
		
		myModel = new ScoreViewModel();	// score view model 
		
		myScoreLabel = new JLabel(SCORE);	// score jlabel
		myLevelLabel = new JLabel(LEVEL);	// level jlabel
		myLinesLabel = new JLabel(LINES);	// line jlabel
		
		myCurrentScore = new JLabel();	// current score
		myCurrentLevel = new JLabel();	// current level
		myCurrentLines = new JLabel();	// current lines
		
		setLocation(800, 100);	// top right quadrant
		
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
	/**
	 * Update the String score label
	 * @param theUpdatedScore The current score
	 */
	private void updateScore(final String theUpdatedScore) {
		myCurrentScore.setText(theUpdatedScore);
	}
	/**
	 * Update the String level label
	 * @param theNewLevel The new level
	 */
	private void updateLevel(final String theNewLevel) {
		myCurrentLevel.setText(theNewLevel);
	}
	/**
	 * Update the String line label
	 * @param theLinesCompleted The lines completed
	 */
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
