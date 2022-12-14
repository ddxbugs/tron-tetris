/*
 * Tetromino.java
 * @author Alan Fowler
 */
package model;

import java.util.Objects;
import java.util.Random;

/**
 * 
 * Tetromino Enum type
 * @author ddxbugs@github.com
 *
 */
enum ImmutableTetromino {
	
	/** The 'I' Tetromino */
	I(4, 1, Mino.I, 
			new Point (0, 2),
			new Point (1, 2),
			new Point (2, 2),
			new Point (3, 2)),
	
	/** The 'J' Tetromino */
	J(3, 2, Mino.J,
			new Point (0, 2),
			new Point (0, 1),
			new Point (1, 1),
			new Point (2, 1)),
	
	/** The 'L' Tetromino */
	L(3, 2, Mino.L,
			new Point (2, 2),
			new Point (0, 1),
			new Point (1, 1),
			new Point (2, 1)),
	
	/** The 'O' Tetromino */
	O(2, 2, Mino.O,
			new Point (1, 2),
			new Point (2, 2),
			new Point (1, 1),
			new Point (2, 1)),
	
	/** The 'S' Tetromino */
    S(3, 2, Mino.S,
    		new Point (1, 2), 
			new Point (2, 2), 
			new Point (0, 1), 
			new Point (1, 1)),
    
    /** The 'T' Tetromino */
    T(3, 2, Mino.T,
    		new Point (1, 2), 
    		new Point (0, 1), 
    		new Point (1, 1), 
    		new Point (2, 1)),

    /** The 'Z' Tetromino */
    Z(3, 2, Mino.Z,
    		new Point (0, 2), 
    		new Point (1, 2), 
    		new Point (1, 1), 
    		new Point (2, 1));
	
	/** The random class object */
	private static final Random RAND = new Random();
	/** The block width of the Tetromino */
	private final int myWidth;
	/** The block height of the Tetromino */
	private final int myHeight;
	/** The Tetromino Mino Enum type */
	private final Mino myBlock;
	/** The Tetromino points array */
	private final Point[] myPoints;
	/**
	 * Tetromino default constructor
	 * @param theWidth Tetromino block width
	 * @param theHeight Tetromino block height
	 * @param theBlock Tetromino block Enum type
	 */
	ImmutableTetromino(final int theWidth, final int theHeight, 
			final Mino theBlock, final Point... thePoints) {
		
		myWidth = theWidth;
		myHeight = theHeight;
		myBlock = theBlock;
		myPoints = Objects.requireNonNull(thePoints);
	}
	
	/**
	 * Return the Tetromino block width
	 * @return the block width of the Tetromino
	 */
	protected int getWidth() {
		return myWidth;
	}
	
	/**
	 * Return the Tetromino block height
	 * @return the block height of the Tetromino
	 */
	protected int getHeight() {
		return myHeight;
	}
	
	/**
	 * Return the Tetromino Mino Enum type
	 * @return the Mino Enum type
	 */
	protected Mino getBlock() {
		return myBlock;
	}
	
	/**
	 * Return the Tetromino point array
	 * @return the Points of the Tetromino
	 */
	protected Point[] getPoints() {
		return myPoints.clone();
	}
	
	/**
	 * Return a random Tetromino
	 * @return a random Tetromino
	 */
	protected static ImmutableTetromino getRandomPiece() {
		return values()[RAND.nextInt(values().length)];
	}
}
