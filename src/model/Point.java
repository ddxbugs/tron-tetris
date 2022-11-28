/*
 * Point.java
 * @author Alan Folwer
 */
package model;

import java.util.Objects;

/**
 * Represent a Point with x and y coordinates.
 * Point objects are immutable.
 * (java.awt.Point are mutable)
 */
final class Point {
	/** The Mino block X coordinate */
	private final int myX;
	/** The Mino block Y coordinate */
	private final int myY;
	
	/**
	 * Constructor for Point using given coordinate params
	 * @param theX
	 * @param theY
	 */
	protected Point(final int theX, final int theY) {
		// TODO Auto-generated constructor stub
		myX = theX;
		myY = theY;
	}
	
	/**
	 * Mino X coord accessor 
	 * @return the Mino block X coord
	 */
	protected int getX() {
		return myX;
	}
	
	/**
	 * Mino Y coord accessor
	 * @return the Mino block Y coord
	 */
	protected int getY() {
		return myY;
	}
	
	/**
	 * Transforms the block X,Y points to new X,Y points
	 * @param theX the domain transformation
	 * @param theY the range transformation
	 * @return the new block X,Y transformation
	 */
	protected Point transform(final int theX, final int theY) {
		return new Point(myX + theX, myY + theY);
	}
	
	/**
	 * Creates a new immutable Point with
	 * respective transformation
	 * @param thePoint the Point X,Y shift and translation
	 * @return
	 */
	public Point transform(final Point thePoint) {
		return transform(myX + thePoint.getX(),
				myY + thePoint.getY());
	}
	
	/**
	 * Overrides Object inherited equals method
	 * @return the result of the comparison operation
	 */
	@Override
	public boolean equals(final Object theOther) {
		boolean result = false;
		if (theOther == this) result = true;
		else if (theOther != null && theOther.getClass() == getClass()) {
			final Point p = (Point) theOther;
			result = myX == p.myX && myY == p.myY;
		}
		return result;			
	}
	
	/**
	 * Return the block X,Y object hash value 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(myX, myY);
	}
	
	/**
	 * Return the block X,Y string format
	 */
	@Override
	public String toString() {
		return String.format("(%d, %d)", myX, myY);
	}
}
