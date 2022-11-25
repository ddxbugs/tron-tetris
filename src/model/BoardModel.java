/*
 * BoardModel.java
 * @author ddxbugs
 */
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class model contains the pieces, handles movement logic for the game
 */
public class BoardModel {
	private static final int START_X = 0, START_Y = 0;
	/** TetrisGame BoardView dimensions for bounds checking*/
	private int myWidth;
	private int myHeight;
	
	/** List of static Block array objects currently in view */ 
	private List<Block[]> myFrozenBlocks;
	/** List of predetermined TetrisPieces */
	private List<TetrisPiece> myTetrisPieces;
	/** Tetris game player default level 0 */
	private Player myPlayer;
	/** The current tetris piece in play */
	private TetrisPiece myCurrentPiece;	
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
		myCurrentPiece = null;
		
	}
	/**
	 * Creates a new tetris game instance
	 * Reset the game variables
	 */
	public void newGame() {
		myPlayer = new Player();	// new player
//		myPlayer = new Player(name);
	
		myFrozenBlocks.clear();	// clear the Tetris board
		// TODO reset score
		// TODO reset tetris piece preview panel
	}
	
	/**
	 * End the current tetris game
	 * Close variables
	 */
	public void gameOver() {
		myPlayer = null;
	}
	/**
	 * Moves the TetrisPiece left
	 */
	public void left() {
		if (isMovable(myCurrentPiece)) {
			myCurrentPiece.left();
		}
	}
	/**
	 * Moves the TetrisPiece right
	 */
	public void right() {
		if (isMovable(myCurrentPiece)) {
			myCurrentPiece.right();	
		}
	}
	/**
	 * Move the TetrisPiece down
	 */
	public void down() {
		// TODO implement freeze blocks, clear lines, update listeners
		if (isMovable(myCurrentPiece)) {
			myCurrentPiece.down();
		} else {
			for (final Point p : myCurrentPiece.getBoardPoints()) {
				if (p.getX() >= 0 && p.getX() <= myWidth && p.getY() >= 0 && p.getY() <= myHeight) {
					final Block[] blocks = myFrozenBlocks.get(p.getY());
					blocks[p.getX()] = myCurrentPiece.getTetrisPiece().getBlock();
				}
			}
			checkRows();	// double check rows for complete lines
		}
	}
	/**
	 * Drop the piece instantly to the specified location
	 */
	public void drop() {
		// TODO while piece can still move down => down()
		while (isMovable(myCurrentPiece) ) {
			myCurrentPiece.down();
		}
	}
	/** 
	 * Rotate the TetrisPiece clockwise 90 degrees
	 * Wallkicks offset TetrisPiece points' positions
	 */
	public void rotate() {
		// TODO if(ImmutableTetrisPiece.O) rotate()
		final TetrisPiece piece = myCurrentPiece.rotate();
		final Point[] offsets = TGMRotation.getOffset(piece.getTetrisPiece(),
				myCurrentPiece.getRotation(),
				piece.getRotation());
		for (final Point p : offsets) {
			final Point offset = piece.getPosition().transform(p);
			final TetrisPiece t = piece.setPosition(offset);
			if (isMovable(t)) {
				break;	// break if 't' is legal move after rotation
			}
		}
	}
	
	/**
	 * Checks the current piece movement logic for collision, freeze, boundaries
	 * @param theTetrisPiece Current piece in play
	 * @return Returns true if the piece is able to move in the specified direction
	 */
	private boolean isMovable(final TetrisPiece theTetrisPiece) {
		Block b;
		boolean isMovable = false;
		for (final Point p : theTetrisPiece.getBoardPoints()) {
			b = myFrozenBlocks.get(p.getY())[p.getX()];	// block should be null, else collision detected at point p
			if (b == null 
					&& p.getX() >= 0 && p.getX() <= myWidth 
					&& p.getY() <= 0 && p.getY() >= myHeight) {
				isMovable = true;	// within board dimension and no collision detected
			}
		}
		return isMovable;
	}
	
	/**
	 * Checks the tetris board for completed lines
	 */
	private void checkRows() {
		boolean[] lines = new boolean[myHeight];
		boolean linesClear = false;
		int i = myHeight;
		for (final Block[] blocks : myFrozenBlocks) {
			linesClear = false;
			for (final Block block : blocks) {
				linesClear = block == null ? true : false;
				if (linesClear) break;	// slightly faster implementation O(n - k - 1)
			}
			lines[i--] = linesClear;	// reverse order for correct board orientation
		}
		clearLines(lines);	// remove the filled rows from the board, update score
	}
	
	/**
	 * Clear completed rows from the board
	 * @param theLines The board as a boolean array of filled/partial/empty blocks
	 */
	private void clearLines(final boolean[] theLines) {
		for (int i = 0; i < theLines.length; i++) {
			if (theLines[i]) {
				myFrozenBlocks.remove(i);
				myFrozenBlocks.add(new Block[myWidth]);
			}
		}
		// notify listeners: scoreboard, player
	}
	
	/**
	 * Prepare the next random tetris piece in play
	 * @return Returns a random tetris piece default start position and rotation
	 */
	private TetrisPiece nextMovablePiece() {
		return new TetrisPiece(ImmutableTetrisPiece.getRandomPiece(), new Point(START_X, START_Y), Rotation.START);
	}
	
	/**
	 * Helper method for preparing next tetris piece
	 */
	private void prepareNextMovablePiece() {
		
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
		for (int row = myHeight; row >= 0; row--) {
			
			final Block[] blocks = Objects.requireNonNull(myFrozenBlocks.get(row));
			sb.append('|');	// left border
			
			// for each column
			for (int col = 0; col < myWidth - 1; col++) {
				final Block b = blocks[col];
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
