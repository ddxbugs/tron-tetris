/*
 * TetrisPiece.java
 * @author Alan Fowler
 */
package model;

import java.util.Objects;
import java.util.Random;

/**
 * 
 * TetrisPiece Enum type
 * @author ddxbugs@github.com
 *
 */
enum ImmutableTetrisPiece {
	
	/** The 'I' TetrisPiece */
	I(4, 1, Block.I, 
			new Point (0, 2),
			new Point (1, 2),
			new Point (2, 2),
			new Point (3, 2)),
	
	/** The 'J' TetrisPiece */
	J(3, 2, Block.J,
			new Point (0, 2),
			new Point (0, 1),
			new Point (1, 1),
			new Point (2, 1)),
	
	/** The 'L' TetrisPiece */
	L(3, 2, Block.L,
			new Point (2, 2),
			new Point (0, 1),
			new Point (1, 1),
			new Point (2, 1)),
	
	/** The 'O' TetrisPiece */
	O(2, 2, Block.O,
			new Point (1, 2),
			new Point (2, 2),
			new Point (1, 1),
			new Point (2, 1)),
	
	/** The 'S' TetrisPiece */
    S(3, 2, Block.S,
    		new Point (1, 2), 
			new Point (2, 2), 
			new Point (0, 1), 
			new Point (1, 1)),
    
    /** The 'T' TetrisPiece */
    T(3, 2, Block.T,
    		new Point (1, 2), 
    		new Point (0, 1), 
    		new Point (1, 1), 
    		new Point (2, 1)),

    /** The 'Z' TetrisPiece */
    Z(3, 2, Block.Z,
    		new Point (0, 2), 
    		new Point (1, 2), 
    		new Point (1, 1), 
    		new Point (2, 1));
	
	/** The random class object */
	private static final Random RAND = new Random();
	/** The block width of the TetrisPiece */
	private final int myWidth;
	/** The block height of the TetrisPiece */
	private final int myHeight;
	/** The TetrisPiece Block Enum type */
	private final Block myBlock;
	/** The TetrisPiece points array */
	private final Point[] myPoints;
	/**
	 * TetrisPiece default constructor
	 * @param theWidth TetrisPiece block width
	 * @param theHeight TetrisPiece block height
	 * @param theBlock TetrisPiece block Enum type
	 */
	ImmutableTetrisPiece(final int theWidth, final int theHeight, final Block theBlock, final Point... thePoints) {
		myWidth = theWidth;
		myHeight = theHeight;
		myBlock = theBlock;
		myPoints = Objects.requireNonNull(thePoints).clone();
	}
	
	/**
	 * Return the TetrisPiece block width
	 * @return the block width of the TetrisPiece
	 */
	protected int getWidth() {
		return myWidth;
	}
	
	/**
	 * Return the TetrisPiece block height
	 * @return the block height of the TetrisPiece
	 */
	protected int getHeight() {
		return myHeight;
	}
	
	/**
	 * Return the TetrisPiece Block Enum type
	 * @return the Block Enum type
	 */
	protected Block getBlock() {
		return myBlock;
	}
	
	/**
	 * Return the TetrisPiece point array
	 * @return the Points of the TetrisPiece
	 */
	protected Point[] getPoints() {
		return myPoints.clone();
	}
	
	/**
	 * Return a random TetrisPiece
	 * @return a random TetrisPiece
	 */
	protected static ImmutableTetrisPiece getRandomPiece() {
		return values()[RAND.nextInt(values().length)];
	}
}
