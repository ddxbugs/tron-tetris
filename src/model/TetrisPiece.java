/**
 * MutableTetrisPiece.java
 */
package model;

import java.util.Objects;

/**
 * Abstract mutable TetrisPiece with Point and Rotation
 * @author ddxbugs@github.com
 *
 */
abstract class TetrisPiece {

	/**
	 * Number of block units in a TetrisPiece
	 */
	private static final int N_BLOCKS = 4;
	/**
	 * TetrisPiece enum type
	 */
	private final TETRIS_PIECE myTetrisPiece;
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
	public TetrisPiece(final TETRIS_PIECE theTetrisPiece,
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
	public TetrisPiece(final TETRIS_PIECE theTetrisPiece,
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
		for (final Point : block : getLocalPoints()) {
			blocks[block.getY()][block.getX()] = myTetrisPiece.getBlock().toString();
		}
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
	}
}

