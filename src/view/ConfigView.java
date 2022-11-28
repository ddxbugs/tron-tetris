/**
 * 
 */
package view;

import javax.swing.JPanel;

import model.ConfigViewModel;

/**
 * Game menu and configuration settings UI class
 */
public class ConfigView extends JPanel {
	private ConfigViewModel myModel;
	
	protected ConfigView(final int theWidth, final int theHeight) {
		setSize(theWidth, theHeight);
	}
}
