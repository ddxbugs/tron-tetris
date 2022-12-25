/*
 * MenuController.java
 * @author ddxbugs 
 */
package controller;

import model.MenuViewModel;
import view.MenuView;
import view.TetrionGrid;

/**
 */
public class MenuController {
//	private static final String CONFIG_FILE = "config.ini";
	
	/** The TetrionGrid view */
	private static TetrionGrid grid;
	/** Configuration settings menu option */
	private static MenuView menu;
	private static MenuViewModel model;
	/** 
	 * Primary menu controller class constructor
	 * @param theGrid The grid 
	 * @param theMenu The options menu
	 */
	public MenuController(final TetrionGrid theGrid, final MenuView theMenu) {
		grid = theGrid;
		menu = theMenu;
	}
	/**
	 * Menu option view panel default public class constructor
	 */
	public MenuController() {
		// TODO Auto-generated constructor stub
		super();
		menu = new MenuView();	// game options menu
		grid = new TetrionGrid();
		model = new MenuViewModel();
		
		menu.setSize(500,500);
	}
	
	

}
