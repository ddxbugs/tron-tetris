/**
 * ColorPalette.java
 * Tron Tetris theme color profile
 */
package res;

import java.awt.Color;

/**
 * enum ColorPalette
 * @source www.colourlovers.com/palette/1406402/Tron_Legacy_2. 
 * @author ddxbugs
 * @version 0.0.1
 *
 */
public enum ColorPalette {
	CYAN(111, 195, 223),
	ORANGE(223, 116, 12),
	BASESTAR(12, 20, 31),
	PANE(230, 255, 255),
	YELLOW(255, 230, 77);
	/** Red 0-255 */
	private final int r; 
	/** Green 0-255 */
	private final int g;
	/** Blue 0-255 */
	private final int b;
	/**
	 * Private enum ColorPalette constructor
	 * @param R Red
	 * @param G Green
	 * @param B Blue
	 */
	private ColorPalette(final int R, final int G, final int B) {
		r = R;
		g = G;
		b = B;
	}
	/**
	 * Returns the enum Color
	 * @return the RGB value (0-255)
	 */
	public Color getColor() {
		return new Color(r, g, b);
	}
}
