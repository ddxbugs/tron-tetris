/*
 * TetrisPiece.java
 * @author Alan Fowler
 */
package model;

import java.util.Objects;

/**
 * Abstract mutable TetrisPiece with Point and Rotation
 */
public class TetrisPiece {

	/**
	 * Number of block units in a TetrisPiece
	 */
	private static final int N_BLOCKS = 4;
	/**
	 * TetrisPiece enum type
	 */
	private final ImmutableTetrisPiece myTetrisPiece;
	/**
	 * TetrisPiece current position on board
	 */
	private final Point myPosition;
	/**
	 * TetrisPiece current rotation angle
	 */
	private final Rotation myRotation;
	
	/**
	 * TetrisPiece constructor allows creation
	 * of movable pieces set to the specified enum
	 * type, rotation angle, and point position
	 * @param theTetrisPiece the TetrisPiece enum type
	 * @param thePosition the TetrisPiece starting point
	 * @param theRotation the TetrisPiece initial angle
	 */
	public TetrisPiece(final ImmutableTetrisPiece theTetrisPiece,
			final Point thePosition,
			final Rotation theRotation) {
		myTetrisPiece = Objects.requireNonNull(theTetrisPiece, 
				"NullPointerException.class: TetrisPiece enum type " + theTetrisPiece);
		myPosition = Objects.requireNonNull(thePosition, 
				"NullPointerException.class: Point.class " + thePosition);
		myRotation = Objects.requireNonNull(theRotation, 
				"NullPointerException.class: Rotation enum type " + theRotation);
		
	}
	
	/**
	 * Default initial TetrisPiece constructor starting
	 * rotation and position on the board
	 * @param theTetrisPiece enum type
	 * @param thePosition the TetrisPiece position on board
	 */
	public TetrisPiece(final ImmutableTetrisPiece theTetrisPiece,
			final Point thePosition) {
		this(theTetrisPiece, thePosition, Rotation.START);
	}
	
	/**
	 * Return the absolute height of the moving TetrisPiece
	 * @return the TetrisPiece block height difference
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
	 * Return the absolute width of the moving TetrisPiece
	 * @return the TetrisPiece block width difference
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
	 * Returns a TetrisPiece enum block type
	 * @return the Block enum type
	 */
	public Block getBlock() {
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
	 * Returns this object's TetrisPiece 
	 * @return the TetrisPiece's enum BlockType
	 */
	protected ImmutableTetrisPiece getTetrisPiece() {
		return myTetrisPiece;
	}
	/**
	 * Returns the TetrisPiece's current position on the board
	 * @return the TetrisPiece position
	 */
	protected Point getPosition() {
		return myPosition;
	}
	
	// TODO implement method for 'wall kicking'
	/**
	 * Returns new TetrisPiece of current type, rotation and new position
	 * 
	 * @param thePosition the new tetris piece position
	 * @return the new TetrisPiece at specified position
	 */
	protected TetrisPiece setPosition(final Point thePosition) {
		return new TetrisPiece(myTetrisPiece, thePosition, myRotation);
	}
	/**
	 * Return the current rotation of the TetrisPiece
	 * @return the TetrisPiece rotation state
	 */
	protected Rotation getRotation() {
		return myRotation;
	}
	/**
	 * Returns all the TetrisPiece block positions on the board
	 * @return an array of Points 
	 */
	protected Point[] getBoardPoints() {
		return getPoints(myPosition);
	}
	/**
	 * Retrieve local block Point positions
	 * @return array of TetrisPiece block points
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
	 * TetrisPiece movements
	 ********************************************************/
	
	/**
	 * Rotate the tetris piece clockwise 90 degrees
	 * @return new rotated tetris piece
	 */
	protected TetrisPiece rotate() { 
		return new TetrisPiece(myTetrisPiece, myPosition, myRotation.clockwise());
	}
	/**
	 * Moves the tetris piece to the left 1 unit
	 * @return new tetris piece shifted to left
	 */
	protected TetrisPiece left() {
		return new TetrisPiece(myTetrisPiece, myPosition.transform(-1, 0), myRotation);
	}
	/**
	 * Moves the tetris piece to the right 1 unit
	 * @return new tetris piece shifted to right 
	 */
	protected TetrisPiece right() {
		return new TetrisPiece(myTetrisPiece, myPosition.transform(1, 0), myRotation);
	}
	/**
	 * Moves the tetris piece down 1 unit
	 * @return new tetris piece position
	 */
	protected TetrisPiece down() {
		return new TetrisPiece(myTetrisPiece, myPosition.transform(0, -1), myRotation);
		
	}
}

