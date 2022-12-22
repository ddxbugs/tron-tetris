/*
 * MenuController.java
 * @author ddxbugs 
 */
package controller;

import javax.swing.JPanel;

import model.ConfigViewModel;
import view.MenuOptionView;

/**
 */
public class MenuController {
	private static final int MAX_SCREEN_WIDTH = 0;
	private static final int MAX_SCREEN_HEIGHT = 0;
	private static final String CONFIG_FILE = "config.ini";
	/** Configuration settings menu option */
	private static MenuOptionView view;
	private static ConfigViewModel model;
	/**
	 * 
	 */
	public MenuController(final JPanel thePanel) {
		// TODO Auto-generated constructor stub
		super();
		view = new MenuOptionView();	// game options menu
		model = new ConfigViewModel();
		
		view.setSize(500,500);
	}

}
