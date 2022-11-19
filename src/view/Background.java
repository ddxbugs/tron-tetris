/**
 * 
 */
package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author User
 *
 */
public class Background extends JPanel {
	private static Image image = 
			Toolkit.getDefaultToolkit().getImage("G:\\code\\git\\tron-tetris\\src\\res\\background.jpg");
	private static JLabel label;
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -4143335180036947216L;
	/**
	 * Private constructor 
	 */
	@SuppressWarnings("unused")
	private Background() {
		// TODO Auto-generated constructor stub
		System.err.println("error:" + IllegalStateException.class);
		throw new IllegalStateException();
	}

	/**
	 * @param layout
	 */
	public Background(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
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
//		g.drawImage(image, ALLBITS, ABORT, label);
	}
}
