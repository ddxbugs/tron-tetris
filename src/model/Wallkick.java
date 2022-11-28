/*
 * Wallkick.java
 * @author Alan Fowler
 */
package model;

/**
 * Wallkick offsets Tetromino positions
 * Based on Tetris Grand Master game mechanics
 */
final class Wallkick {
    
    /**
     * The clockwise and counter offsets for rotating J, L, S, T, and Z Tetrominos 
     */
    private static final Point[][] JLSTZ_OFFSETS = {
		{ new Point(0, 0), new Point(-1, 0), new Point(-1, +1), new Point(0, -2), new Point(-1, -2) }, // START to QUARTER
	    { new Point(0, 0), new Point(+1, 0), new Point(+1, -1), new Point(0, +2), new Point(+1, +2) }, // QUARTER to START
	    { new Point(0, 0), new Point(+1, 0), new Point(+1, -1), new Point(0, +2), new Point(+1, +2) }, // QUARTER to HALF
	    { new Point(0, 0), new Point(-1, 0), new Point(-1, +1), new Point(0, -2), new Point(-1, -2) }, // HALF to QUARTER
	    { new Point(0, 0), new Point(+1, 0), new Point(+1, +1), new Point(0, -2), new Point(+1, -2) }, // HALF to THREEQUARTER
	    { new Point(0, 0), new Point(-1, 0), new Point(-1, -1), new Point(0, +2), new Point(-1, +2) }, // THREEQUARTER to HALF
	    { new Point(0, 0), new Point(-1, 0), new Point(-1, -1), new Point(0, +2), new Point(-1, +2) }, // THREEQUARTER to START
	    { new Point(0, 0), new Point(+1, 0), new Point(+1, +1), new Point(0, -2), new Point(+1, -2) }  // START to THREEQUARTER
    };
    
    /**
     * The clockwise and counter offsets for rotating I Tetrominos
     */
    private static final Point[][] I_OFFSETS = {
		{ new Point(0, 0), new Point(-2, 0), new Point(+1, 0), new Point(-2, -1), new Point(+1, +2) }, // START to QUARTER
        { new Point(0, 0), new Point(+2, 0), new Point(-1, 0), new Point(+2, +1), new Point(-1, -2) }, // QUARTER to START    
        { new Point(0, 0), new Point(-1, 0), new Point(+2, 0), new Point(-1, +2), new Point(+2, -1) }, // QUARTER to HALF
        { new Point(0, 0), new Point(+1, 0), new Point(-2, 0), new Point(+1, -2), new Point(-2, +1) }, // HALF to QUARTER
        { new Point(0, 0), new Point(+2, 0), new Point(-1, 0), new Point(+2, +1), new Point(-1, -2) }, // HALF to THREEQUARTER
        { new Point(0, 0), new Point(-2, 0), new Point(+1, 0), new Point(-2, -1), new Point(+1, +2) }, // THREEQUARTER to HALF
        { new Point(0, 0), new Point(+1, 0), new Point(-2, 0), new Point(+1, -2), new Point(-2, +1) }, // THREEQUARTER to START 
        { new Point(0, 0), new Point(-1, 0), new Point(+2, 0), new Point(-1, +2), new Point(+2, -1) }  // START to THREEQUARTER
    };
    /**
     * Returns an array of Points representing the wall kick offsets
     * 
     * @param theTetromino the piece type being rotated
     * @param theCurrentRotation the current rotation angle
     * @param theNewRotation the next rotation angle 
     * @return the points offset by wall kick
     */
    public static Point[] getOffset(final ImmutableTetromino theTetromino,
                                       final Rotation theCurrentRotation,
                                       final Rotation theNewRotation) {
        Point[] points = new Point[0];
        points = theTetromino == ImmutableTetromino.I ? 
        		getIPieceOffset(theCurrentRotation, theNewRotation) : getJLSTZOffset(theCurrentRotation, theNewRotation);
        return points;
    }

    /**
     * Returns Points offset by Tetromino wall kicks
     * for J, L, S, T, and Z Tetrominos
     * 
     * @param theCurrentRotation the current rotation angle
     * @param theNewRotation the next rotation angle
     * @return the points offset by wall kick
     */
    private static Point[] getJLSTZOffset(final Rotation theCurrentRotation,
                                         final Rotation theNewRotation) {
        Point[] points = new Point[0];
        switch (theCurrentRotation) {
            case START:
            	points = theNewRotation == Rotation.QUARTER ? JLSTZ_OFFSETS[0] : JLSTZ_OFFSETS[7];
                break;
            case QUARTER:
            	points = theNewRotation == Rotation.HALF ? JLSTZ_OFFSETS[2] : JLSTZ_OFFSETS[1];
                break;
            case HALF:
                points = theNewRotation == Rotation.THREEQUARTER ? JLSTZ_OFFSETS[4] : JLSTZ_OFFSETS[3];
                break;
            case THREEQUARTER:
                points = theNewRotation == Rotation.START ? JLSTZ_OFFSETS[6] : JLSTZ_OFFSETS[5];
                break;
            default:
            	points = null;
                break;
        }
        return points;
    }

    /**
     * Returns Points offset by Tetromino wall kicks
     * for IPieces
     * 
     * @param theCurrentRotation the current rotation angle
     * @param theNewRotation the next rotation angle
     * @return The wall kick offsets for these conditions
     */
    private static Point[] getIPieceOffset(final Rotation theCurrentRotation,
                                          final Rotation theNewRotation) {
        Point[] points = new Point[0];
        switch (theCurrentRotation) {
	        case START:
	        	points = theNewRotation == Rotation.QUARTER ? I_OFFSETS[0] : I_OFFSETS[7];
	            break;
	        case QUARTER:
	        	points = theNewRotation == Rotation.HALF ? I_OFFSETS[2] : I_OFFSETS[1];
	            break;
	        case HALF:
	            points = theNewRotation == Rotation.THREEQUARTER ? I_OFFSETS[4] : I_OFFSETS[3];
	            break;
	        case THREEQUARTER:
	            points = theNewRotation == Rotation.START ? I_OFFSETS[6] : I_OFFSETS[5];
	            break;
	        default:
	        	points = null;
	            break;
        }
        return points;
    }

}