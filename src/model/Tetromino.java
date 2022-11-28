/*
 * Tetromino.java
 * @author Alan Fowler
 */
package model;

import java.util.Objects;

/**
 * Abstract mutable Tetromino with Point and Rotation
 */
public class Tetromino {

	/**
	 * Number of block units in a Tetromino
	 */
	private static final int N_BLOCKS = 4;
	/**
	 * Tetromino enum type
	 */
	private final ImmutableTetromino myTetrisPiece;
	/**
	 * Tetromino current position on board
	 */
	private final Point myPosition;
	/**
	 * Tetromino current rotation angle
	 */
	private final Rotation myRotation;
	
	/**
	 * Tetromino constructor allows creation
	 * of movable pieces set to the specified enum
	 * type, rotation angle, and point position
	 * @param theTetrisPiece the Tetromino enum type
	 * @param thePosition the Tetromino starting point
	 * @param theRotation the Tetromino initial angle
	 */
	public Tetromino(final ImmutableTetromino theTetrisPiece,
			final Point thePosition,
			final Rotation theRotation) {
		myTetrisPiece = Objects.requireNonNull(theTetrisPiece, 
				"NullPointerException.class: Tetromino enum type " + theTetrisPiece);
		myPosition = Objects.requireNonNull(thePosition, 
				"NullPointerException.class: Point.class " + thePosition);
		myRotation = Objects.requireNonNull(theRotation, 
				"NullPointerException.class: Rotation enum type " + theRotation);
		
	}
	
	/**
	 * Default initial Tetromino constructor starting
	 * rotation and position on the board
	 * @param theTetrisPiece enum type
	 * @param thePosition the Tetromino position on board
	 */
	public Tetromino(final ImmutableTetromino theTetrisPiece,
			final Point thePosition) {
		this(theTetrisPiece, thePosition, Rotation.START);
	}
	
	/**
	 * Return the absolute height of the moving Tetromino
	 * @return the Tetromino block height difference
	 */
	protected int getHeight() {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		for (final Point block : getLocalPoints()) {
			min = Math.min(min, block.getY());
			max = Math.max(max, block.getY());
		}
		return max - min + 1;
	}
	
	/**
	 * Return the absolute width of the moving Tetromino
	 * @return the Tetromino block width difference
	 */
	protected int getWidth() {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		for (final Point block : getLocalPoints()) {
			min = Math.min(min, block.getX());
			max = Math.max(max,  block.getX());
		}
		return max - min + 1;
	}
	
	/**
	 * Returns a Tetromino enum block type
	 * @return the Mino enum type
	 */
	public Mino getBlock() {
		return myTetrisPiece.getBlock();
	}
	
	// override class Object method toString()
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		final String[][] blocks = new String[N_BLOCKS][N_BLOCKS];
		for (int height = 0; height < N_BLOCKS; height++) {
			for (int width = 0; width < N_BLOCKS; width++) {
				blocks[width][height] = " ";
			}
		}
		for (final Point block : getLocalPoints()) {
			blocks[block.getY()][block.getX()] = myTetrisPiece.getBlock().toString();
		}
		return sb.toString();
	}
	/**
	 * Returns this object's Tetromino 
	 * @return the Tetromino's enum BlockType
	 */
	protected ImmutableTetromino getTetrisPiece() {
		return myTetrisPiece;
	}
	/**
	 * Returns the Tetromino's current position on the board
	 * @return the Tetromino position
	 */
	protected Point getPosition() {
		return myPosition;
	}
	
	// TODO implement method for 'wall kicking'
	/**
	 * Returns new Tetromino of current type, rotation and new position
	 * 
	 * @param thePosition the new tetris piece position
	 * @return the new Tetromino at specified position
	 */
	protected Tetromino setPosition(final Point thePosition) {
		return new Tetromino(myTetrisPiece, thePosition, myRotation);
	}
	/**
	 * Return the current rotation of the Tetromino
	 * @return the Tetromino rotation state
	 */
	protected Rotation getRotation() {
		return myRotation;
	}
	/**
	 * Returns all the Tetromino block positions on the board
	 * @return an array of Points 
	 */
	protected Point[] getBoardPoints() {
		return getPoints(myPosition);
	}
	/**
	 * Retrieve local block Point positions
	 * @return array of Tetromino block points
	 */
	private Point[] getLocalPoints() {
		return getPoints(null);
	}
	
	private Point[] getPoints(final Point thePoint) {
		final Point[] blocks = myTetrisPiece.getPoints();
		// for each Point in blocks
		for (int i = 0; i < blocks.length; i++) {
			
			final Point block = blocks[i];
			
			// case: myRotation current state
			switch(myRotation) {
			// TODO bug Tetris Piece 'O' rotation 
				case QUARTER: blocks[i] = new Point(block.getY(),
						myTetrisPiece.getWidth() - block.getX() - 1);
					break;
				case HALF: blocks[i] = new Point(myTetrisPiece.getWidth() - block.getX() - 1,
						myTetrisPiece.getWidth() - block.getY() - 1);
					break;
				case THREEQUARTER: blocks[i] = new Point(myTetrisPiece.getWidth() - block.getY() - 1,
						block.getX());
					break;
				default: 
					break;
			}
		}
		return blocks;
	}
	
	/*********************************************************
	 * Tetromino movements
	 ********************************************************/
	
	/**
	 * Rotate the tetris piece clockwise 90 degrees
	 * @return new rotated tetris piece
	 */
	protected Tetromino rotate() { 
		return new Tetromino(myTetrisPiece, myPosition, myRotation.clockwise());
	}
	/**
	 * Moves the tetris piece to the left 1 unit
	 * @return new tetris piece shifted to left
	 */
	protected Tetromino left() {
		return new Tetromino(myTetrisPiece, myPosition.transform(-1, 0), myRotation);
	}
	/**
	 * Moves the tetris piece to the right 1 unit
	 * @return new tetris piece shifted to right 
	 */
	protected Tetromino right() {
		return new Tetromino(myTetrisPiece, myPosition.transform(1, 0), myRotation);
	}
	/**
	 * Moves the tetris piece down 1 unit
	 * @return new tetris piece position
	 */
	protected Tetromino down() {
		return new Tetromino(myTetrisPiece, myPosition.transform(0, -1), myRotation);
		
	}
}
