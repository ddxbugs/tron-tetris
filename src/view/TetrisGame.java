/**
 * 
 */
package view;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @author User
 *
 */
public class TetrisGame extends JFrame {
	/** */
	private static final long serialVersionUID = 1L;
	
	/** */
	private static final int TIME_DELAY = 1000;
	
	/** Full screen configuration settings and variables */
	private static final int BLOCK_SIZE = 1;
	private static final int SCALE = 1;
	/** Window bar icon decoration */
	private static final ImageIcon ICON = new ImageIcon(".\\src\\res\\icon.jpg");
	private static Background bg;

	/**
	 * @throws HeadlessException
	 */
	public TetrisGame() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Disney's Tron: Legacy Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(ICON.getImage());
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	/** 
	 * Invokes new Runnable configuration
	 */
	public void start() {
		initialize();
		setUp();
		pack();
		setVisible(true);
	}
	
	/** 
	 * Initialize JComponent and event handlers
	 */
	private void initialize() {
		bg = new Background(new FlowLayout());
	}
	
	private void setUp() {
		add(bg);
	}
	
}
