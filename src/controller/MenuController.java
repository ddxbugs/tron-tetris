/*
 * MenuController.java
 * @author ddxbugs 
 */
package controller;

import model.MenuViewModel;
import view.MenuView;
import view.Tetrion;

/**
 */
public class MenuController {
	private static final int MAX_SCREEN_WIDTH = 0;
	private static final int MAX_SCREEN_HEIGHT = 0;
	private static final String CONFIG_FILE = "config.ini";
	private static Tetrion tetrion;
	/** Configuration settings menu option */
	private static MenuView menu;
	private static MenuViewModel model;
	/** 
	 * Primary menu controller class constructor
	 * @param theTetrion The tetrion 
	 * @param theMenu The options menu
	 */
	public MenuController(final Tetrion theTetrion, final MenuView theMenu) {
		tetrion = theTetrion;
		menu = theMenu;
	}
	/**
	 * Menu option view panel default public class constructor
	 */
	public MenuController() {
		// TODO Auto-generated constructor stub
		super();
		menu = new MenuView();	// game options menu
		tetrion = new Tetrion();
		model = new MenuViewModel();
		
		menu.setSize(500,500);
	}
	
	

}
