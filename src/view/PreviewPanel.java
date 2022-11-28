/*
 * PreviewPanel.java
 * @author ddxbugs 
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import res.ColorPalette;

/**
 * PreviewPanel class displays next tetris piece on board
 */
public class PreviewPanel extends JPanel {
	/**
	 * Preview panel class displays next tetris piece during game
	 */
	public PreviewPanel() {
		// TODO Auto-generated constructor stub
		super();
		
		setLocation(900, 300);
		setBackground(ColorPalette.MEANWHILE.getColor());
		setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, 
				ColorPalette.PANE.getColor(), ColorPalette.TRON_BLUE.getColor()));
//		setVisible(true);
		
	}
	
	@Override
	public void paintComponent(final Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2d = (Graphics2D) theGraphics;
		// select tetris piece 
		// fill and draw the rects
	}
}
