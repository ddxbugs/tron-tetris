/*
 * TetrionViewModel.java
 * @author ddxbugs
 */
package model;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

/**
 * This class model contains the pieces, handles movement logic for the game
 */
public class TetrionViewModel {
	
	/** Default board width height */
	private static final int WIDTH = 10, HEIGHT = 20;
	/** Magic numbers */
	private static final int ZERO = 0, ONE = 1, TWO = 2, FIVE = 5;
	private static final int BUFFER = FIVE;
	/** Start position */
	private static final int START_X = WIDTH / TWO, START_Y = FIVE;
	

	/** List of pieces currently in view */ 
	private List<Mino[]> myFrozenBlocks;
	/** Array of complete/incomplete rows */
	private boolean[] myLines;
	
	/** The current Tetromino in play */
	private Tetromino myCurrentPiece;	
	/** The next Tetromino */
	private Tetromino myNextPiece;
	
	private ChangeListener changeListener;
	/**
	 * Primary TetrionViewModel constructor
	 * @param theWidth width of game board
	 * @param theHeight height of game board
	 */
	public TetrionViewModel() {

		myFrozenBlocks = new LinkedList<Mino[]>();
		myLines = new boolean[HEIGHT];
		myCurrentPiece = null;
		myNextPiece = null;

		changeListener = null;
	}
	/**
	 * Create new tetris game object
	 */
	public void newGame() {
	
		myFrozenBlocks.clear();	// clear the tetromino block list
		
		for (int i = 0; i < HEIGHT; i++) 
			myFrozenBlocks.add(new Mino[WIDTH]);	// reset block row empty
		
		Arrays.fill(myLines, true);	// set line counter true 
		
		myNextPiece = nextTetromino(); // current piece
		myCurrentPiece = myNextPiece;	// next piece
		myNextPiece = nextTetromino();
		
		changeListener.stateChanged(new ChangeEvent(myNextPiece));	// update the preview change listener
		changeListener.stateChanged(new ChangeEvent(myCurrentPiece));	// update the view change listener
	}
	
	/**
	 * End the current tetris game
	 */
	public void gameOver() {
		myLines = null;
		myFrozenBlocks = null;
		myCurrentPiece = null;
		myNextPiece = null;
	}
	/**
	 * Moves the Tetromino left
	 */
	public void left() {
		if (isCurrentPieceMovable()) {
			myCurrentPiece = myCurrentPiece.left();	// transform (-1, 0)
			changeListener.stateChanged(new ChangeEvent(myCurrentPiece));
		}
	}
	/**
	 * Moves the Tetromino right
	 */
	public void right() {
		if (isCurrentPieceMovable()) {
			myCurrentPiece = myCurrentPiece.right();	// transform (1, 0)	
			changeListener.stateChanged(new ChangeEvent(myCurrentPiece));
		}
	}
	/**
	 * Move the Tetromino down
	 */
	public void down() {
		if (isCurrentPieceMovable()) {
			myCurrentPiece = myCurrentPiece.down();	// transform (0, -1)
			changeListener.stateChanged(new ChangeEvent(myCurrentPiece));
		}	
	}
	/**
	 * Drop the piece instantly to the specified location
	 */
	public void drop() {
		while (isCurrentPieceMovable() ) {
			myCurrentPiece = myCurrentPiece.down(); // TODO Add key pressed function
			changeListener.stateChanged(new ChangeEvent(myCurrentPiece));
		}
	}
	/** 
	 * Rotate the Tetromino clockwise 90 degrees
	 * Wallkicks offset Tetromino points' positions
	 */
	public void rotate() {
		
		// TODO if(ImmutableTetromino.O) rotate() phantom wallkick bug
		final Tetromino piece = myCurrentPiece.rotate();
		final Point[] offsets = Wallkick.getOffset(piece.getTetromino(),
													myCurrentPiece.getRotation(),
													piece.getRotation());
		for (final Point p : offsets) {
			final Point offset = piece.getPosition().transform(p);
			final Tetromino t = piece.setPosition(offset);
			if (isCurrentPieceMovable()) {
				myCurrentPiece = t;
				changeListener.stateChanged(new ChangeEvent(myCurrentPiece));
			}
		}
	}
	/**
	 * Set current piece position rotation
	 * Timer event queue thread dispatch
	 */
	private void freezeBlocks() {
		Mino[] row;
		for (final Point p : myCurrentPiece.getBoardPoints()) {			
			if (isPointOnBoard(p)) {
				row = myFrozenBlocks.get(p.getY());
				row[p.getX()] = myCurrentPiece.getTetromino().getBlock();
				myFrozenBlocks.remove(p.getY());	// remove old frozen block row from list
				myFrozenBlocks.add(p.getY(), row);	// replace with updated frozen block row 
			}
		}
	}	
	/**
	 * Checks the current piece movement logic for collision, freeze, boundaries
	 * @param theTetromino Current piece in play
	 * @return Returns true if the piece is able to move in the specified direction
	 */
	private boolean isCurrentPieceMovable() {
		
		Mino b;
		
		boolean isMovable = false;
		
		for (final Point p : myCurrentPiece.getBoardPoints()) {	
			
			b = myFrozenBlocks.get(p.getY())[p.getX()];
			
			isMovable = (b == null && isPointOnBoard(p)) ? true : false; // within board dimension and no collision detected
			
			if (!isMovable) break;	// if block is not null or not on the board at x, y break, slightly faster implementation
			
		}
		
		if (!isMovable) {
			
			if (!checkRows()) clearLines();	// TODO graphic controller sprite animation
			
			myCurrentPiece = myNextPiece;
			myNextPiece = nextTetromino();
			
			changeListener.stateChanged(new ChangeEvent(myCurrentPiece));
			changeListener.stateChanged(new ChangeEvent(myNextPiece));
			
		} else {
			
			freezeBlocks();
			
		}
			
		return isMovable;
	}
	
	/**
	 * Determine if a Mino block position is point on board
	 * @param thePoint the current position
	 * @return Returns true if the point is within the boundaries
	 */
	private boolean isPointOnBoard(final Point thePoint) {
		
		return thePoint.getX() >= 0 && thePoint.getX() < WIDTH
				&& thePoint.getY() >= 0;
				
	}
	/**
	 * Checks the frozen Tetrominos for completed lines by row
	 * Checks each block by column for completed lines,
	 * break for loop if empty space found (incomplete row)
	 *  
	 */
	private boolean checkRows() {
		boolean isBlockNull = false;	
		boolean isLineClear = true;
		
		int row = 0;
		for (final Mino[] blocks : myFrozenBlocks) {
			
			for (final Mino block : blocks) {
				
				isBlockNull = block == null ? true : false;
				if (isBlockNull) break;	// slightly faster implementation O(n - k - 1)
			}
			
			if (!isBlockNull) isLineClear = false;	// false => need to clear entire frozen blocks row at i
			
			myLines[row] = isBlockNull;	// reverse order for correct board orientation
			row++;
		}
		
		return isLineClear;
	}
	/**
	 * Clear completed rows from the board
	 */
	private void clearLines() {
		for (int i = 0; i < myLines.length; i++) {
			if (myLines[i] == false) {
				myFrozenBlocks.remove(i);
				// TODO shift blocks down n lines	
			}
		}
	}
	/**
	 * Prepare the next random tetromino in play
	 * @return Returns a random tetromino default start position and rotation
	 */
	private Tetromino nextTetromino() {
		return new Tetromino(ImmutableTetromino.getRandomPiece(), 
				new Point(START_X, START_Y), Rotation.START);
	}
	/**
	 * Returns the current board as array object
	 * @return Returns the current frozen Mino pieces in game
	 */
	public Mino[] getFrozenBlocks() {
		Mino[] arr = new Mino[WIDTH * HEIGHT];
		int i = 0;
		for (final Mino[] row : myFrozenBlocks) 
			for (final Mino block : row) {
				arr[i++] = block;
			}
		return arr;
	}
	/** 
	 * Return the width of the model
	 * @return The width
	 */
	public int getWidth() {
		return WIDTH;
	}
	/** 
	 * Return the height of the model
	 * @return The height
	 */
	public int getHeight() {
		return HEIGHT;
	}
	/**
	 * Register the view change listener
	 * @param theChangeListener The change listener class
	 */
	public void addChangeListener(final ChangeListener theChangeListener) {
		changeListener = theChangeListener;
	}
	/**
	 * Returns the board as a string
	 * @return current tetris board string representation
	 */
	@Override
	public String toString() {
		
		final StringBuilder sb = new StringBuilder();
		
		// sb.append(buffer)
		for (int row = 0; row < BUFFER; row++) {
			sb.append('|');
			for (int col = 0; col < WIDTH; col++) {
				sb.append(' ');
			}
			sb.append("|\n");
		}
		
		// sb.append(ceil)
		sb.append(' ');
		for (int ceil=0; ceil < WIDTH; ceil++) {
			sb.append("_");
		}	
		sb.append("\n");
	
		// sb.append(board)
		for (final Mino[] row : myFrozenBlocks) {
			sb.append('|');	// left border
			// for each column
			for (final Mino block : row) {
				sb.append(block == null ? " " : block);
			}
			sb.append("|\n");	// start new row
		}
		
		// sb.append(floor)
		sb.append(' ');
		for (int floor = 0; floor < WIDTH; floor++) {
			sb.append("_");
		}
		
		return sb.toString();
	}
}
