/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author User
 *
 */
public class BoardModel {
	/** List of static Block array objects currently in view */ 
	private List<Block[]> myFrozenBlocks;
	/** List of predetermined TetrisPieces */
	private List<TetrisPiece> myTetrisPieces;
	
	/** TetrisGame BoardView dimensions */
	private int myWidth;
	private int myHeight;
	
	/**
	 * Primary BoardModel constructor
	 * @param theWidth width of game board
	 * @param theHeight height of game board
	 */
	public BoardModel(final int theWidth, final int theHeight) {
		myFrozenBlocks = new LinkedList<Block[]>();
		myTetrisPieces = new ArrayList<TetrisPiece>();
		myWidth = theWidth;
		myHeight = theHeight;
		
	}
	
	public void newGame() {
		myFrozenBlocks.clear();	// clear the TetrisPiece list
		// TODO reset score
		// TODO reset tetris piece preview panel
	}
	
	/**
	 * Moves the TetrisPiece left
	 */
	public void left() {
		
	}
	
	/**
	 * Moves the TetrisPiece right
	 */
	public void right() {
		
	}
	
	/** 
	 * Rotate the TetrisPiece clockwise 90 degrees
	 */
	public void rotate() {
		
	}
	
	/**
	 * Move the TetrisPiece down
	 */
	public void down() {
		
	}
	
	/**
	 * Call down() until TetrisPiece freezes
	 */
	public void drop() {
		
	}
}
