/*
 * Background.java 
 * @author ddxbugs 
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Background class displays Tron Legacy images
 */
public class Background extends JPanel {
	private static JLabel label;
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -4143335180036947216L;
	/**
	 * @param layout
	 */
	protected Background() {
		super();
		// TODO Auto-generated constructor stub
		setBackground(Color.BLACK);
	}
	
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		System.out.println(getFocusCycleRootAncestor());
//		g.drawImage(image, label.getIcon().getIconWidth(), label.getIcon().getIconHeight(), label);
	}
}
