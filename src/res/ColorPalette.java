/**
 * ColorPalette.java
 * Tron Tetris theme color profile
 */
package res;

import java.awt.Color;

/**
 * enum ColorPalette
 * @source https://www.colourlovers.com/palette/1406402/Tron_Legacy_2
 * @source https://www.colourlovers.com/palette/969512/Annoy-A-Tron_2.0
 * @source https://www.colourlovers.com/palette/1526474/Tron 
 * @author ddxbugs
 * @version 0.0.1
 *
 */
public enum ColorPalette {
	CYAN_TRON_LEGACY(111, 195, 223),	// @source https://www.colourlovers.com/palette/1406402/Tron_Legacy_2
	ORANGE_TRON_LEGACY(223, 116, 12),	// @source https://www.colourlovers.com/palette/1406402/Tron_Legacy_2
	BASESTAR(12, 20, 31),	// @source https://www.colourlovers.com/palette/1406402/Tron_Legacy_2
	PANE(230, 255, 255),	// @source https://www.colourlovers.com/palette/1406402/Tron_Legacy_2
	SWEET_YELLOW(255, 230, 77),	// @source https://www.colourlovers.com/palette/1406402/Tron_Legacy_2
	FAR_AWAY_SKY(216, 218, 231), // @source https://www.colourlovers.com/palette/1526474/Tron 
	MEANWHILE(5, 13, 16),	// @source https://www.colourlovers.com/palette/1526474/Tron 
	TRON_BLUE(24, 202, 230),	// @source https://www.colourlovers.com/palette/1526474/Tron 
	WIPE_OUT(52, 96, 141),	// @source https://www.colourlovers.com/palette/1526474/Tron 
	DEAD_BABY(13, 12, 28),	// @source https://www.colourlovers.com/palette/1526474/Tron 
	SIX_SOUND_CHOICES(213, 203, 177),	// @source https://www.colourlovers.com/palette/969512/Annoy-A-Tron_2.0 
	VOLUME_CONTROL(182, 185, 165);	// @source https://www.colourlovers.com/palette/969512/Annoy-A-Tron_2.0
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
