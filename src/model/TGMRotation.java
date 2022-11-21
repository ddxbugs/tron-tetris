package model;

/**
 * WallKick rotations offsets TetrisPiece positions
 * TetrisPiece  
 */
final class TGMRotation {
    
    /**
     * The kick offsets for rotations of J, L, S, T, and Z pieces 
     */
    private static final Point[][] JLSTZ_OFFSETS = {
		{ new Point(0, 0), new Point(-1, 0), new Point(-1, +1), new Point(0, -2), new Point(-1, -2) }, // NONE to QUARTER
	    { new Point(0, 0), new Point(+1, 0), new Point(+1, -1), new Point(0, +2), new Point(+1, +2) }, // QUARTER to NONE
	    { new Point(0, 0), new Point(+1, 0), new Point(+1, -1), new Point(0, +2), new Point(+1, +2) }, // QUARTER to HALF
	    { new Point(0, 0), new Point(-1, 0), new Point(-1, +1), new Point(0, -2), new Point(-1, -2) }, // HALF to QUARTER
	    { new Point(0, 0), new Point(+1, 0), new Point(+1, +1), new Point(0, -2), new Point(+1, -2) }, // HALF to THREEQUARTER
	    { new Point(0, 0), new Point(-1, 0), new Point(-1, -1), new Point(0, +2), new Point(-1, +2) }, // THREEQUARTER to HALF
	    { new Point(0, 0), new Point(-1, 0), new Point(-1, -1), new Point(0, +2), new Point(-1, +2) }, // THREEQUARTER to NONE
	    { new Point(0, 0), new Point(+1, 0), new Point(+1, +1), new Point(0, -2), new Point(+1, -2) }  // NONE to THREEQUARTER
    };
    
    /**
     * The kick offsets for rotations of I piece
     */
    private static final Point[][] I_OFFSETS = {
		{ new Point(0, 0), new Point(-2, 0), new Point(+1, 0), new Point(-2, -1), new Point(+1, +2) }, // NONE to QUARTER
        { new Point(0, 0), new Point(+2, 0), new Point(-1, 0), new Point(+2, +1), new Point(-1, -2) }, // QUARTER to NONE    
        { new Point(0, 0), new Point(-1, 0), new Point(+2, 0), new Point(-1, +2), new Point(+2, -1) }, // QUARTER to HALF
        { new Point(0, 0), new Point(+1, 0), new Point(-2, 0), new Point(+1, -2), new Point(-2, +1) }, // HALF to QUARTER
        { new Point(0, 0), new Point(+2, 0), new Point(-1, 0), new Point(+2, +1), new Point(-1, -2) }, // HALF to THREEQUARTER
        { new Point(0, 0), new Point(-2, 0), new Point(+1, 0), new Point(-2, -1), new Point(+1, +2) }, // THREEQUARTER to HALF
        { new Point(0, 0), new Point(+1, 0), new Point(-2, 0), new Point(+1, -2), new Point(-2, +1) }, // THREEQUARTER to NONE 
        { new Point(0, 0), new Point(-1, 0), new Point(+2, 0), new Point(-1, +2), new Point(+2, -1) }  // NONE to THREEQUARTER
    };
    
    /**
     * Empty private constructor 
     */
    private TGMRotation() {
        // do nothing
    }
    
    /**
     * Returns an array of Points representing the wall kick offsets
     * 
     * @param thePiece the piece type being rotated
     * @param theCurrentRotation the current rotation angle
     * @param theRotationAngle the next rotation angle 
     * @return the points offset by wall kick
     */
    public static Point[] getKickOffset(final ImmutableTetrisPiece thePiece,
                                       final Rotation theCurrentRotation,
                                       final Rotation theRotationAngle) {
        
        Point[] points = new Point[0];
        
        if (thePiece == ImmutableTetrisPiece.I) {
            points = getIPieceKicks(theCurrentRotation, theRotationAngle);
        } else if (thePiece != ImmutableTetrisPiece.O) {
            points = getJLSTZKicks(theCurrentRotation, theRotationAngle);
        }
        
        return points;
    }

    /**
     * Returns an array of Points representing the wall kick offsets
     * for J, L, S, T, and Z TetrisPieces
     * 
     * @param theCurrentRotation the current rotation angle
     * @param theRotationAngle the next rotation angle
     * @return the points offset by wall kick
     */
    private static Point[] getJLSTZKicks(final Rotation theCurrentRotation,
                                         final Rotation theRotationAngle) {
        Point[] points = new Point[0];
        switch (theCurrentRotation) {
            case START:
                if (theRotationAngle == Rotation.QUARTER) {
                    points = JLSTZ_OFFSETS[0];	// CW START TO QUARTER
                } else if (theRotationAngle == Rotation.THREEQUARTER) {
                    points = JLSTZ_OFFSETS[7];	// CCW START TO THREEQUARTER
                }
                break;
            case QUARTER:
                if (theRotationAngle == Rotation.HALF) {
                    points = JLSTZ_OFFSETS[2];	// CW QUARTER TO HALF
                } else if (theRotationAngle == Rotation.START) {
                    points = JLSTZ_OFFSETS[1];	// CCW QUARTER TO START
                }
                break;
            case HALF:
                if (theRotationAngle == Rotation.THREEQUARTER) {
                    points = JLSTZ_OFFSETS[4];	// CW HALF TO THREEQUARTER
                } else if (theRotationAngle == Rotation.QUARTER) {
                    points = JLSTZ_OFFSETS[3];	// CCW HALF TO QUARTER
                }
                break;
            case THREEQUARTER:
                if (theRotationAngle == Rotation.START) {
                    points = JLSTZ_OFFSETS[6];	// CW THREEQUARTER TO START
                } else if (theRotationAngle == Rotation.HALF) {
                    points = JLSTZ_OFFSETS[5];	// CCW THREEQUARTER TO HALF
                }
                break;
            default:
            	// do nothing
                break;
        }
        return points;
    }

    /**
     * Returns an array of Points representing the wall kick offsets
     * for IPieces
     * 
     * @param theCurrentRotation the current rotation angle
     * @param theRotationAngle the next rotation angle
     * @return The wall kick offsets for these conditions
     */
    private static Point[] getIPieceKicks(final Rotation theCurrentRotation,
                                          final Rotation theRotationAngle) {
        Point[] points = new Point[0];
        switch (theCurrentRotation) {
            case START:
                if (theRotationAngle == Rotation.QUARTER) {
                    points = I_OFFSETS[0];	// CW START TO QUARTER
                } else if (theRotationAngle == Rotation.THREEQUARTER) {
                    points = I_OFFSETS[7];	// CCW START TO THREEQUARTER
                }
                break;
            case QUARTER:
                if (theRotationAngle == Rotation.HALF) {
                    points = I_OFFSETS[2];	// CW HALF TO THREEQUARTER
                } else if (theRotationAngle == Rotation.START) {
                    points = I_OFFSETS[1];	// CCW QUARTER TO START
                }
                break;
            case HALF:
                if (theRotationAngle == Rotation.THREEQUARTER) {
                    points = I_OFFSETS[4];	// CW HALF TO THREEQUARTER
                } else if (theRotationAngle == Rotation.QUARTER) {	
                    points = I_OFFSETS[3];	// CCW HALF TO QUARTER
                }
                break;
            case THREEQUARTER:
                if (theRotationAngle == Rotation.START) {
                    points = I_OFFSETS[6];	// CW THREEQUARTER TO START
                } else if (theRotationAngle == Rotation.HALF) {
                    points = I_OFFSETS[5];	// CCW THREEQUARTER TO HALF
                }
                break;
            default:
                // do nothing
                break;
        }
        return points;
    }

}