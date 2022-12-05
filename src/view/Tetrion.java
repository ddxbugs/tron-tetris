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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import model.Player;
import res.ColorPalette;

/**
 * Background class displays Tron Legacy images
 */
public class Tetrion extends JPanel {
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
	/** */
	private static JLayeredPane myLayeredPane;
	
//	protected Tetrion(TetrionView theTetrionView, PiecePreview thePreview, ScoreView theScore, Player thePlayer) {
//		
//	}
	
	/**
	 * @param layout
	 */
	protected Tetrion() {
		super();
		setBackground(Color.BLACK);
		
		try {
			myImage = ImageIO.read(new File(IMG_FILE_PATH));
			myBackgroundLabel = new JLabel(new ImageIcon(myImage));
			myBackgroundLabel.setBounds(ZERO, ZERO, myImage.getWidth(), myImage.getHeight());
			myBackgroundLabel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED,
					ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
			
		} catch (IOException e) {
			System.err.println("IOException:" + e);
			e.printStackTrace();
		}
		
		myTronLabel = new JLabel(TRON_LEGACY);
		myGameLabel = new JLabel(VERSION_TITLE);
				
		myTronLabel.setSize(myImage.getWidth(), FONT_PT_24 + PAD_Y * TWO);
		myGameLabel.setSize(myImage.getWidth(), FONT_PT_24 + PAD_Y * TWO);
		
		myTronLabel.setFont(new Font(OUTLINE, Font.TRUETYPE_FONT, FONT_PT_24));
		myTronLabel.setForeground(ColorPalette.CYAN_TRON_LEGACY.getColor());
		
		myGameLabel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, FONT_PT_18));
		myGameLabel.setForeground(ColorPalette.SIX_SOUND_CHOICES.getColor());
		
		myLayeredPane = new JLayeredPane();
		myLayeredPane.setPreferredSize(new Dimension(myImage.getWidth(), myImage.getHeight()));
		
		// TODO create menu option bar class
		JPanel panel = new JPanel();	// add the game labels
		panel.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
		panel.setSize(myImage.getWidth(), FONT_PT_24 * TWO);
		panel.setBackground(ColorPalette.MEANWHILE.getColor());
//		panel.setOpaque(false);
		
		panel.add(myTronLabel);
		panel.add(myGameLabel);
		
		myLayeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
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
	
//		System.out.println("background="+myImage.getWidth()+","+myImage.getHeight());
	}
}
