/*
 * Background.java 
 * @author ddxbugs 
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Background class displays Tron Legacy images
 */
public class Background extends JPanel {
	private static Image image = 
			Toolkit.getDefaultToolkit().getImage(".\\src\\res\\background.jpg");
	private static JLabel label;
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -4143335180036947216L;
	/**
	 * @param layout
	 */
	public Background() {
		super();
		// TODO Auto-generated constructor stub
		setBackground(Color.BLACK);
		label = new JLabel(new ImageIcon(image));
		add(label);
	}

	/**
	 * @param isDoubleBuffered
	 */
	public Background(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public Background(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		System.out.println(getFocusCycleRootAncestor());
//		g.drawImage(image, label.getIcon().getIconWidth(), label.getIcon().getIconHeight(), label);
	}
}
