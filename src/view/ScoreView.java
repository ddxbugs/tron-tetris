/*
 * ScoreView.java
 * @author ddxbugs 
 */
package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.ScoreViewModel;
import res.ColorPalette;

/**
 *	Display the current game score
 */
public class ScoreView extends JPanel implements PropertyChangeListener {
	
	private static final int ROW = 2;
	private static final int COL = 3;
	private static final int VGAP = 0;
	private static final int HGAP = 5;
	
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
		
//		setSize(200, 50);	// transparent row line
		
		myModel = new ScoreViewModel();	// score view model 
		
		myScoreLabel = new JLabel(SCORE, SwingConstants.RIGHT);	// score jlabel
		myLevelLabel = new JLabel(LEVEL, SwingConstants.RIGHT);	// level jlabel
		myLinesLabel = new JLabel(LINES, SwingConstants.RIGHT);	// line jlabel
		
		// TODO fix hard coded values
		myCurrentScore = new JLabel("103,204", SwingConstants.RIGHT);	// current score
		myCurrentLevel = new JLabel("24", SwingConstants.RIGHT);	// current level
		myCurrentLines = new JLabel("101", SwingConstants.RIGHT);	// current lines
		
		setLocation(850, 100);	// top right quadrant
		setLayout(new GridLayout(ROW, COL, VGAP, HGAP));
		
		// set font style
		myScoreLabel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_14));
		myLevelLabel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_14));
		myLinesLabel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_14));
		// set current value font style
		myCurrentScore.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_12));
		myCurrentLevel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_12));
		myCurrentLines.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_12));
		
		// set text foreground colors
		myScoreLabel.setForeground(ColorPalette.PANE.getColor());
		myLevelLabel.setForeground(ColorPalette.FAR_AWAY_SKY.getColor());
		myLinesLabel.setForeground(ColorPalette.VOLUME_CONTROL.getColor());
		
		// set foreground colors
		myCurrentScore.setForeground(ColorPalette.PANE.getColor());
		myCurrentLevel.setForeground(ColorPalette.FAR_AWAY_SKY.getColor());
		myCurrentLines.setForeground(ColorPalette.VOLUME_CONTROL.getColor());
		
		// add view component property change event listener
		myScoreLabel.addPropertyChangeListener(this);
		myLevelLabel.addPropertyChangeListener(this);
		myLinesLabel.addPropertyChangeListener(this);
		
		// add current value label property change listener
		myCurrentScore.addPropertyChangeListener(this);
		myCurrentLevel.addPropertyChangeListener(this);
		myCurrentLines.addPropertyChangeListener(this);
		
		// transparent hover effect
		setOpaque(false);
		
		// add to view panel
		add(myScoreLabel);
		add(myLevelLabel);
		add(myLinesLabel);
		add(myCurrentScore);
		add(myCurrentLevel);
		add(myCurrentLines);
	}
	/**
	 * Update score view component jlabel property on property change event
	 */
	@Override
	public void propertyChange(final PropertyChangeEvent theEvent) {
		final String propertyName = theEvent.getPropertyName();
		final Object object = theEvent.getSource();
		
		if (theEvent != null && object instanceof JLabel) {
			
			if ("color".equals(propertyName)) {
				
				// Super Tetris Mode On Fire
				myScoreLabel.setForeground(ColorPalette.ORANGE_TRON_LEGACY.getColor());
				myLevelLabel.setForeground(ColorPalette.SWEET_YELLOW.getColor());
				myLinesLabel.setForeground(ColorPalette.SIX_SOUND_CHOICES.getColor());
				
				myScoreLabel.setFont(new Font(OUTLINE, Font.TRUETYPE_FONT, FONT_PT_16));
				myLevelLabel.setFont(new Font(OUTLINE, Font.TRUETYPE_FONT, FONT_PT_14));
				myLinesLabel.setFont(new Font(OUTLINE, Font.TRUETYPE_FONT, FONT_PT_14));
				
			} else if ("label".equals(propertyName)) {
				
				// Update label String values
				final String[] value = (String[]) theEvent.getNewValue();	// TODO Hard code values remove
				myCurrentScore.setText(value[0]);
				myCurrentLevel.setText(value[1]);
				myCurrentLines.setText(value[2]);
			}
			
		}
		
		
	}
}
