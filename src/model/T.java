/*
 * T.java
 * @author ddxbugs
 */
package model;

import java.awt.Color;

import res.ColorPalette;

/**
 * T class extends Tetromino
 * TODO: implement final class
 * TODO: T class implements special function/methods 
 * Example: T, L, S, O, Z Tetromino extends abstract Tetromino
 *
 */
public final class T extends Tetromino {
	/** T Tetromino default color */
//	private static final Color cyan = ColorPalette.CYAN_TRON_LEGACY.getColor();
	/** 
	 * Default T constructor
	 * T  extends Tetromino
	 */
	public T() {
		super(ImmutableTetromino.T, new Point(0, 0), Rotation.START);
	}
	
	/**
	 * Moving T constructor
	 * T  extends Tetromino
	 */
	public T(final Point thePoint, final Rotation theRotation) {
		super(ImmutableTetromino.T, thePoint, theRotation);
	}
}

