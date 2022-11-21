/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author User
 *
 */
public class BoardModel {

	/** TetrisGame BoardView dimensions */
	private int myWidth;
	private int myHeight;
	
	/** List of static Block array objects currently in view */ 
	private List<Block[]> myFrozenBlocks;
	/** List of predetermined TetrisPieces */
	private List<TetrisPiece> myTetrisPieces;
	/** Tetris game player default level 0 */
	private Player myPlayer;
	/** The current tetris piece in play */
	private TetrisPiece myTetrisPiece;
	/**
	 * Primary BoardModel constructor
	 * @param theWidth width of game board
	 * @param theHeight height of game board
	 */
	public BoardModel(final int theWidth, final int theHeight) {
		myWidth = theWidth;
		myHeight = theHeight;
		myFrozenBlocks = new LinkedList<Block[]>();
		myTetrisPieces = new ArrayList<TetrisPiece>();
		myPlayer = null;
		myTetrisPiece = null;
		
	}
	
	public void newGame() {
		myPlayer = new Player();	// new player
	
		myFrozenBlocks.clear();	// clear the Tetris board
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
	
	private boolean isMovable(final TetrisPiece theTetrisPiece) {
		boolean isMovable = false;
		
		return isMovable;
	}
	
	/**
	 * Returns the board as a string
	 * @return current tetris board string representation
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		
		// TODO sb.append(function: create ceiling buffer)
		// for each row
		for (int i = myHeight; i >= 0; i--) {
			
			final Block[] row = Objects.requireNonNull(myFrozenBlocks.get(i));
			sb.append('|');	// left border
			
			// for each column
			for (int j = 0; j < myWidth - 1; j++) {
				final Block b = row[j];
				if (b == null) {
					sb.append(' ');	// empty block space on board
				} else {
					sb.append(b);
				}
			}	
			sb.append("|\n");	// start new row
		}
		
		// TODO sb.append(function: create floor)
		
		return sb.toString();
	}
}
