/*
 * Background.java 
 * @author ddxbugs 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import res.ColorPalette;

/**
 * Background class displays Tron Legacy images
 */
public class Background extends JPanel {
	/** Default serial version UID */
	private static final long serialVersionUID = 1L;
	/** Official movie release title */
	private static final String TRON_LEGACY = "Disney's TRON: Legacy";
	/** Game title */
	private static final String VERSION_TITLE = "Super Tetris";
	/** CrNNtn-regular font family name */
	private static final String REGULAR = "CRRNTN-Regular";
	/** CrNNtn font family name */
	private static final String OUTLINE = "CRRNTN-Outline";
	
	/** Background buffered image */
	private static BufferedImage myImage;
	/** Tron Legacy decoration label */
	private static JLabel myTronLabel;
	/** Cyan disc menu button decoration label */
	private static JLabel myGameLabel;
	/** */
	private static JLabel myBackgroundLabel;
	
	/**
	 * @param layout
	 */
	protected Background() {
		super();
		setBackground(Color.BLACK);
		
		try {
			myImage = ImageIO.read(new File("src/res/grid.jpg"));
			myBackgroundLabel = new JLabel(new ImageIcon(myImage));
		} catch (IOException e) {
			System.err.println("IOException:" + e);
			e.printStackTrace();
		}
		
		myTronLabel = new JLabel(TRON_LEGACY);
		myGameLabel = new JLabel(VERSION_TITLE);
	
		myTronLabel.setFont(new Font(OUTLINE, Font.BOLD, 24));
		myTronLabel.setForeground(ColorPalette.CYAN_TRON_LEGACY.getColor());
		myGameLabel.setFont(new Font(REGULAR, Font.TRUETYPE_FONT, 18));
		myGameLabel.setForeground(ColorPalette.TRON_BLUE.getColor());
		
		add(myTronLabel);
		add(myGameLabel);
		add(myBackgroundLabel);
	}
	
	public void paintComponents(Graphics theGraphics) {
		super.paintComponents(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
		if (myImage != null)
			g2d.drawImage(myImage, myImage.getWidth(), myImage.getHeight(), this);
		System.out.println("background="+myImage.getWidth()+","+myImage.getHeight());
	}
}
