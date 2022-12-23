/*
 * Background.java 
 * @author ddxbugs 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import res.ColorPalette;

/**
 * Background class displays Tron Legacy images
 */
public class Tetrion extends JPanel implements PropertyChangeListener {
	/** Default serial version UID */
	private static final long serialVersionUID = 1L;
	
	/** Magic numbers */
	private static final int FONT_PT_24 = 24;
	private static final int FONT_PT_18 = 18;
	private static final int ZERO = 0;
	private static final int TWO  = 2;
	private static final int PAD_X = 10;
	private static final int PAD_Y = 10;
	
	/** Official movie release title */
	private static final String TRON_LEGACY = "Disney's TRON: Legacy";
	/** Game title */
	private static final String VERSION_TITLE = "Super Tetris";
	/** CrNNtn-regular font family name */
	private static final String REGULAR = "CRRNTN-Regular";
	/** CrNNtn font family name */
	private static final String OUTLINE = "CRRNTN-Outline";
	/** Background buffered image relative file path */
	private static final String IMG_FILE_PATH = "src/res/grid.jpg"; 
	/** Background buffered image */
	private static BufferedImage myImage;
	/** Tron Legacy decoration label */
	private static JLabel myTronLabel;
	/** Cyan disc menu button decoration label */
	private static JLabel myGameLabel;
	/** Background image decoration */
	private static JLabel myBackgroundLabel;
	private static JPanel myLabelPanel;
	/** Tetrion background layered pane */
	private static JLayeredPane myLayeredPane;
	
//	protected Tetrion(TetrionView theTetrionView, Preview thePreview, ScoreView theScore, Player thePlayer) {
//		
//	}
	
	/**
	 * Tetrion default view layer constructor class
	 */
	public Tetrion() {
		super();
		
		setBackground(Color.BLACK);
		
		setBackground(IMG_FILE_PATH);	// default background image
		
		myTronLabel = new JLabel(TRON_LEGACY);	// "Disney's TRON: Legacy"
		myGameLabel = new JLabel(VERSION_TITLE);	// "Super Tetris"
				
		myTronLabel.setSize(myImage.getWidth(), FONT_PT_24 + PAD_Y * TWO);
		myGameLabel.setSize(myImage.getWidth(), FONT_PT_24 + PAD_Y * TWO);
		
		myTronLabel.setFont(new Font(OUTLINE, Font.TRUETYPE_FONT, FONT_PT_24));
		myTronLabel.setForeground(ColorPalette.CYAN_TRON_LEGACY.getColor());
		
		myGameLabel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_18));
		myGameLabel.setForeground(ColorPalette.SIX_SOUND_CHOICES.getColor());
		
		myLayeredPane = new JLayeredPane();
		myLayeredPane.setPreferredSize(new Dimension(myImage.getWidth(), myImage.getHeight()));
		
		// TODO create menu option bar class
		myLabelPanel = new JPanel();	
		myLabelPanel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
		myLabelPanel.setSize(myImage.getWidth(), FONT_PT_24 * TWO);
		myLabelPanel.setBackground(ColorPalette.MEANWHILE.getColor());
		
		// add the game labels
		myLabelPanel.add(myTronLabel);
		myLabelPanel.add(myGameLabel);
		
		myLayeredPane.add(myLabelPanel, JLayeredPane.PALETTE_LAYER);
		myLayeredPane.add(myBackgroundLabel, JLayeredPane.DEFAULT_LAYER);

		add(myLayeredPane);
		
	}
	
	/**
	 * Draw/re-draw background image wallpaper
	 */
	@Override
	public void paintComponents(Graphics theGraphics) {
		super.paintComponents(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
		if (myImage != null)
			g2d.drawImage(myImage, myImage.getWidth(), myImage.getHeight(), this);
	}
	/**
	 * Set Tetrion component ui graphic effects on score level update
	 */
	@Override
	public void propertyChange(final PropertyChangeEvent theEvent) {
		// TODO update background/text image icon label properties
		final String propertyName = theEvent.getPropertyName();
		final Object source = theEvent.getSource();
		
		if (theEvent != null) {
			if (source instanceof File && "image".equals(propertyName)) {
				setBackground( (String) theEvent.getNewValue());	// TODO Fix me
			} else if (source instanceof JLabel && "label".equals(propertyName)) {
				// TODO display menu options/pause game
				myTronLabel.setForeground(ColorPalette.PANE.getColor());
				myGameLabel.setForeground(ColorPalette.FAR_AWAY_SKY.getColor());
			} 
		}
		repaint();
	}
	/**
	 * Dynamically set the Tetrion background image
	 * @param theFilePath The image file path
	 */
	private void setBackground(final String theFilePath) {
		try {
			myImage = ImageIO.read(new File(theFilePath));
			myBackgroundLabel = new JLabel(new ImageIcon(myImage));
			myBackgroundLabel.setBounds(ZERO, ZERO, myImage.getWidth(), myImage.getHeight());
			myBackgroundLabel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED,
					ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
			
		} catch (IOException e) {
			System.err.println("IOException:" + e);
			e.printStackTrace();
		}
	}
}
