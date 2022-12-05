/*
 * TetrionViewModel.java
 * @author ddxbugs
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * This class model contains the pieces, handles movement logic for the game
 */
public class TetrionViewModel {
	/** Magic numbers */
	private static final int START_X = 0, START_Y = 0;
	private static final int BLOCK_ROW_WIDTH = 10, BLOCK_COL_HEIGHT = 20;
	private static final int ONE = 1, TWO = 2;
	
	/** TetrionView scale dimension default 1 : 2 */
	private static double scale = 0;

	/** List of pieces currently in view */ 
	private List<Mino[]> myFrozenBlocks;
	
	/** Default player level 0 */
	private Player myPlayer;
	
	/** The current Tetromino in play */
	private Tetromino myCurrentPiece;	
	
	/**
	 * Primary TetrionViewModel constructor
	 * @param theWidth width of game board
	 * @param theHeight height of game board
	 */
	public TetrionViewModel(final double theScale) {
		scale = theScale;
		myFrozenBlocks = new LinkedList<Mino[]>();
		myPlayer = null;
		myCurrentPiece = nextMovablePiece();
		
	}
	/**
	 * Creates a new tetris game instance
	 * Reset the game variables
	 */
	public void newGame() {
		myPlayer = new Player();	// new player
//		myPlayer = new Player(name);	// TODO persistence player model
	
		myFrozenBlocks.clear();	// clear the Tetris board
		for (int height = 0; height < BLOCK_COL_HEIGHT; height++) 
			myFrozenBlocks.add(new Mino[BLOCK_ROW_WIDTH]);
		
		myCurrentPiece = nextMovablePiece();
		System.out.println(myCurrentPiece.toString());
	}
	
	/**
	 * End the current tetris game
	 * Close variables
	 */
	public void gameOver() {
		myPlayer = null;
	}
	/**
	 * Moves the Tetromino left
	 */
	public void left() {
		if (isMovable(myCurrentPiece)) {
			myCurrentPiece = myCurrentPiece.left();
		}
	}
	/**
	 * Moves the Tetromino right
	 */
	public void right() {
		if (isMovable(myCurrentPiece)) {
			myCurrentPiece = myCurrentPiece.right();	
		}
	}
	/**
	 * Move the Tetromino down
	 */
	public void down() {
//		System.out.println(isMovable(myCurrentPiece));
		
		if (isMovable(myCurrentPiece)) {
			myCurrentPiece = myCurrentPiece.down();
		}
		else {
			
			checkRows();	// TODO return boolean
			clearLines();	// TODO if (checkRows) clearLines()
		}
		freezeBlocks();
	}
	/**
	 * Drop the piece instantly to the specified location
	 */
	public void drop() {
		while (isMovable(myCurrentPiece) ) {
			myCurrentPiece = myCurrentPiece.down();
		}
	}
	/** 
	 * Rotate the Tetromino clockwise 90 degrees
	 * Wallkicks offset Tetromino points' positions
	 */
	public void rotate() {
		// TODO if(ImmutableTetromino.O) rotate()
		final Tetromino piece = myCurrentPiece.rotate();
		final Point[] offsets = Wallkick.getOffset(piece.getTetromino(),
				myCurrentPiece.getRotation(),
				piece.getRotation());
		for (final Point p : offsets) {
			final Point offset = piece.getPosition().transform(p);
			final Tetromino t = piece.setPosition(offset);
			if (isMovable(t)) {
				break;	// break if 't' is legal move after rotation
			}
		}
	}
	/**
	 * Set current piece position rotation
	 * Add to list of current game pieces
	 * Timer action event method caller
	 */
	private void freezeBlocks() {
		Mino[] row;
		for (final Point p : myCurrentPiece.getBoardPoints()) {
			
			row = myFrozenBlocks.get(p.getY());
			if (isPoint(p)) {
				row[p.getX()] = myCurrentPiece.getTetromino().getBlock();
			}
		}
	}
	/**
	 * Checks the current piece movement logic for collision, freeze, boundaries
	 * @param theTetromino Current piece in play
	 * @return Returns true if the piece is able to move in the specified direction
	 */
	private boolean isMovable(final Tetromino theTetromino) {
		Mino b;
		boolean isMovable = false;
		for (final Point p : theTetromino.getBoardPoints()) {
//			System.out.println(p);
			b = myFrozenBlocks.get(p.getY())[p.getX()];	// block should be null, else collision detected at point p
			if (b == null && isPoint(p)) {
				isMovable = true;	// within board dimension and no collision detected
			}
		}
		return isMovable;
	}
	/**
	 * Determine if a Mino block position is point on board
	 * @param thePoint the current position
	 * @return Returns true if the point is within the boundaries
	 */
	private boolean isPoint(final Point thePoint) {
		return thePoint != null && thePoint.getX() >= 0 && thePoint.getX() < BLOCK_ROW_WIDTH
				&& thePoint.getY() >= 0 && thePoint.getY() < BLOCK_COL_HEIGHT;
	}
	
	/**
	 * Checks the tetris board for completed lines
	 */
	private boolean[] checkRows() {
		boolean[] rows = new boolean[BLOCK_COL_HEIGHT];
		boolean isEmpty = false;
		int i = BLOCK_COL_HEIGHT - ONE;
		for (final Mino[] blocks : myFrozenBlocks) {
			isEmpty = false;
			for (final Mino block : blocks) {
				isEmpty = block == null ? true : false;
				if (isEmpty) break;	// slightly faster implementation O(n - k - 1)
			}
			rows[i--] = isEmpty;	// reverse order for correct board orientation
		}
		return rows;
	}
	
	/**
	 * Clear completed rows from the board
	 */
	private void clearLines() {
//		for (int i = 0; i < theLines.length; i++) {
//			if (theLines[i]) {
//				myFrozenBlocks.remove(i);
//				myFrozenBlocks.add(new Mino[BLOCK_ROW_WIDTH]);
//			}
//		}
		// notify listeners: scoreboard, player
	}
	
	/**
	 * Prepare the next random tetromino in play
	 * @return Returns a random tetromino default start position and rotation
	 */
	private Tetromino nextMovablePiece() {
		return new Tetromino(ImmutableTetromino.getRandomPiece(), 
				new Point( (START_X + BLOCK_ROW_WIDTH) / TWO, START_Y), 
				Rotation.START);
	}
	
	/**
	 * Returns the current board as array object
	 * @return Returns the current frozen Mino pieces in game
	 */
	public Mino[] getFrozenBlocks() {
		Mino[] arr = new Mino[BLOCK_ROW_WIDTH * BLOCK_COL_HEIGHT];
		int i = 0;
		for (Mino[] blocks : myFrozenBlocks)
			for (Mino block : blocks) 
				arr[i++] = block;
		return arr;
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
		for (int row = BLOCK_COL_HEIGHT - ONE; row >= 0; row--) {
			
			final Mino[] blocks = myFrozenBlocks.get(row);
			sb.append('|');	// left border
			
			// for each column
			for (int col = 0; col < BLOCK_ROW_WIDTH; col++) {
				final Mino b = blocks[col];
				if (b == null) {
					sb.append(" ");	// empty block space on board
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
