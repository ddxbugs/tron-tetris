/*
 * TetrionViewModel.java
 * @author ddxbugs
 */
package model;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This class model contains the pieces, handles movement logic for the game
 */
public class TetrionViewModel {
	
	/** Default board width height */
	private static final int WIDTH = 10, HEIGHT = 20;
	/** Magic numbers */
	private static final int ONE = 1, TWO = 2, FIVE = 5;
	private static final int BUFFER = FIVE;
	/** Start position */
	private static final int START_X = WIDTH / TWO, START_Y = -(TWO);
	

	/** List of pieces currently in view */ 
	private List<Mino[]> myFrozenBlocks;
	/** Array of complete/incomplete rows */
	private boolean[] myLines;
	
	/** The current Tetromino in play */
	private Tetromino myCurrentPiece;	
	
	/**
	 * Primary TetrionViewModel constructor
	 * @param theWidth width of game board
	 * @param theHeight height of game board
	 */
	public TetrionViewModel() {

		myFrozenBlocks = new LinkedList<Mino[]>();
		myLines = new boolean[HEIGHT];
		myCurrentPiece = null;
		
	}
	/**
	 * Create new tetris game object
	 */
	public void newGame() {
	
		myFrozenBlocks.clear();	// clear the tetromino block list
		
		for (int i = 0; i < HEIGHT; i++) 
			myFrozenBlocks.add(new Mino[WIDTH]);	// reset block row empty
		
		Arrays.fill(myLines, true);	// set line counter true 
		
		myCurrentPiece = nextMovablePiece(); // prepare next piece
	}
	
	/**
	 * End the current tetris game
	 */
	public void gameOver() {
		myLines = null;
		myFrozenBlocks = null;
		myCurrentPiece = null;
	}
	/**
	 * Moves the Tetromino left
	 */
	public void left() {
		if (isCurrentPieceMovable()) {
			myCurrentPiece = myCurrentPiece.left();
		}
	}
	/**
	 * Moves the Tetromino right
	 */
	public void right() {
		if (isCurrentPieceMovable()) {
			myCurrentPiece = myCurrentPiece.right();	
		}
	}
	/**
	 * Move the Tetromino down
	 */
	public void down() {
		
		if (isCurrentPieceMovable()) 
			myCurrentPiece = myCurrentPiece.down();	// transform piece (0,-1)
		else if (checkRows())
			freezeBlocks();	// freeze current piece on board
		else 
			clearLines();
		
		// TODO event queue dispatch thread update graphics controller
	}
	/**
	 * Drop the piece instantly to the specified location
	 */
	public void drop() {
		while (isCurrentPieceMovable() ) {
			myCurrentPiece = myCurrentPiece.down();
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
//			if (isMovable()) break;	// TODO fix me
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
			
			b = myFrozenBlocks.get(p.getY())[p.getX()];	// block should be null, else collision detected at point p
			
			isMovable = b == null && isPointOnBoard(p) ? true : false; // within board dimension and no collision detected
			
			if (!isMovable) break;	// if any block is not null, not movable 
			
		}
		return isMovable;
	}
	/**
	 * Determine if a Mino block position is point on board
	 * @param thePoint the current position
	 * @return Returns true if the point is within the boundaries
	 */
	private boolean isPointOnBoard(final Point thePoint) {

		return thePoint != null && thePoint.getX() >= 0 && thePoint.getX() < WIDTH
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
		
		int row = HEIGHT - 1;
		for (final Mino[] blocks : myFrozenBlocks) {
			
			for (final Mino block : blocks) {
				
				isBlockNull = block == null ? true : false;
				if (isBlockNull) break;	// slightly faster implementation O(n - k - 1)
			}
			
			if (!isBlockNull) isLineClear = false;	// false => need to clear entire frozen blocks row at i
			
			myLines[row--] = isBlockNull;	// reverse order for correct board orientation
		}
		return isLineClear;
	}
	/**
	 * Clear completed rows from the board
	 */
	private void clearLines() {
		for (int i = 0; i < myLines.length; i++) {
			if (myLines[i] == true) {
				System.out.println(i);
				myFrozenBlocks.remove(i);
				myFrozenBlocks.add(i, new Mino[WIDTH]);
			}
		}
	}
	/**
	 * Prepare the next random tetromino in play
	 * @return Returns a random tetromino default start position and rotation
	 */
	private Tetromino nextMovablePiece() {
		return new Tetromino(ImmutableTetromino.getRandomPiece(), 
				new Point( START_X, START_Y), 
				Rotation.START);
	}
	
	/**
	 * Returns the current board as array object
	 * @return Returns the current frozen Mino pieces in game
	 */
	public Mino[] getFrozenBlocks() {
		Mino[] arr = new Mino[WIDTH * HEIGHT];
		int i = 0;
		
		for (Mino[] blocks : myFrozenBlocks)
			for (Mino block : blocks) {
				arr[i++] = block;
			}
		return arr;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
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
			sb.append('|');
			sb.append("\n");
		}
		
		// sb.append(ceil)
		sb.append(' ');
		for (int ceil=0; ceil < WIDTH; ceil++) {
			sb.append("_");
		}
		
		sb.append("\n");
		
		// sb.append(board)
		for (int row = HEIGHT - 1; row >= 0; row--) {
			
			final Mino[] blocks = myFrozenBlocks.get(row);
			sb.append('|');	// left border
			
			// for each column
			for (int col = 0; col < WIDTH; col++) {
				final Mino b = blocks[col];
				sb.append(b == null ? " " : b);
//				if (b == null) {
//					sb.append(" ");	// empty block space on board
//				} else {
//					sb.append(b); // else append block char to string 
//				}
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
