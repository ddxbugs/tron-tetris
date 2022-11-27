/*
 * Background.java 
 * @author ddxbugs 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Background class displays Tron Legacy images
 */
public class Background extends JPanel {
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -4143335180036947216L;
	
	private static BufferedImage background;
	/**
	 * @param layout
	 */
	protected Background() {
		super();
		setBackground(Color.BLACK);
		try {
			background = ImageIO.read(new File("src/res/grid.jpg"));
			System.out.println(background.getWidth()+","+background.getHeight());	// TODO debug, uncomment remove me
		} catch (IOException e) {
			System.err.println("IOException:" + e);
			e.printStackTrace();
		}
	}
	
	public void paintComponents(Graphics theGraphics) {
		super.paintComponents(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
		if (background != null)
			g2d.drawImage(background, background.getWidth(), background.getHeight(), this);
		System.out.println("background="+background.getWidth()+","+background.getHeight());
	}
}
