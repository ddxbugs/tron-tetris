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
		myTetrisPiece.left();
	}
	
	/**
	 * Moves the TetrisPiece right
	 */
	public void right() {
		myTetrisPiece.right();
	}
	
	/** 
	 * Rotate the TetrisPiece clockwise 90 degrees
	 */
	public void rotate() {
		// TODO if(ImmutableTetrisPiece.O) rotate()
		final TetrisPiece piece = myTetrisPiece.rotate();
		final Point[] offsets = TGMRotation.getOffset(piece.getTetrisPiece(),
				myTetrisPiece.getRotation(),
				piece.getRotation());
		for (final Point p : offsets) {
			final Point offset = piece.getPosition().transform(p);
			final TetrisPiece t = piece.setPosition(offset);
			if (isMovable(t)) {
				break;	// breaks if Block 't' is legal move after rotation
			}
		}
	}
	
	/**
	 * Move the TetrisPiece down
	 */
	public void down() {
		// TODO implement freeze blocks, clear lines, update listeners
		myTetrisPiece.down();
	}
	
	/**
	 * Call down() until TetrisPiece freezes
	 */
	public void drop() {
		// TODO while piece can still move down => down()
		myTetrisPiece.down();
	}
	
	/**
	 * Checks the current piece movement logic for collision, freeze, wallkicking, boundaries
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
	
	private void checkRows() {
		for (final Block[] row : myFrozenBlocks) {
			System.out.println(row);
			System.out.println(row.length);
			// TODO check each row for completion
			
		}
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
				final Block col = row[j];
				if (col == null) {
					sb.append(' ');	// empty block space on board
				} else {
					sb.append(col);
				}
			}	
			sb.append("|\n");	// start new row
		}
		
		// TODO sb.append(function: create floor)
		
		return sb.toString();
	}
}
