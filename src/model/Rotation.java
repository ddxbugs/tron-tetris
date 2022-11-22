/**
 * Rotation.java
 */
package model;

import java.util.Random;

/**
 * Tetris piece Rotation type enum
 * @author ddxbugs@github.com
 *
 */
enum Rotation {
	/**
	 * Begin block orientation
	 */
	START,
	/**
	 * Quarter 90 degree clockwise rotational
	 */
	QUARTER,
	/**
	 * Half 180 degree clockwise rotational
	 */
	HALF,
	/**
	 * Three quarter 270 clockwise rotational
	 */
	THREEQUARTER;
	
	/**
	 * Random class assists with generating random pieces
	 */
	private static final Random RAND = new Random();
	
	/**
	 * Rotate tetris piece one quarter clockwise rotation
	 * @return new Rotation enum representing rotated piece
	 */
	protected Rotation clockwise() {
		return values()[(this.ordinal() + 1 ) % values().length];
	}
	
	/**
	 * Randomly selects the rotation angle
	 * @return Returns an enum type Rotation
	 */
	protected Rotation random() {
		return values()[RAND.nextInt(values().length)];
	}
}
