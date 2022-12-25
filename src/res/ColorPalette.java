/*
 * ColorPalette.java
 * @author ddxbugs
 */
package res;

import java.awt.Color;

/**
 * Tron Tetris theme color profile
 * enum ColorPalette
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
	VOLUME_CONTROL(182, 185, 165),	// @source https://www.colourlovers.com/palette/969512/Annoy-A-Tron_2.0
	NOW_EVEN_MORE (36, 167, 216), // @source https://www.colourlovers.com/palette/969512/Annoy-A-Tron_2.0
	ANNOYING_WITH (42, 153, 120); // @source https://www.colourlovers.com/palette/969512/Annoy-A-Tron_2.0
	/** Red 0-255 */
	private final int myR; 
	/** Green 0-255 */
	private final int myG;
	/** Blue 0-255 */
	private final int myB;
	/**
	 * Private enum ColorPalette constructor
	 * @param theR Red
	 * @param theG Green
	 * @param theB Blue
	 */
	private ColorPalette(final int theR, final int theG, final int theB) {
		myR = theR;
		myG = theG;
		myB = theB;
	}
	/**
	 * Returns the enum Color
	 * @return the RGB value (0-255)
	 */
	public Color getColor() {
		return new Color(myR, myG, myB);
	}
	
	
}
