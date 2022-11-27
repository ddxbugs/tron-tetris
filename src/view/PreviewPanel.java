/*
 * PreviewPanel.java
 * @author ddxbugs 
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * PreviewPanel class displays next tetris piece on board
 */
public class PreviewPanel extends JPanel {
	private static final Border bf = BorderFactory.createSoftBevelBorder(BevelBorder.RAISED);
	/**
	 * 
	 */
	public PreviewPanel() {
		// TODO Auto-generated constructor stub
		super();
		setSize(150, 300);	// TODO debug, remove hard code 
		setBorder(bf);
//		setVisible(true);
		
	}
	
	@Override
	public void paintComponent(final Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
		// select tetris piece 
		// draw
	}
}
