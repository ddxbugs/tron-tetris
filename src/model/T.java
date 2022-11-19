/**
 * 
 */
package model;

/**
 * T class extends TetrisPiece
 * TODO: implement final class
 * TODO: T class implements special function/methods 
 * Example: T, L, S, O, Z TetrisPiece extends abstract TetrisPiece
 * @author User
 *
 */
public class T extends TetrisPiece {
	/** 
	 * Default T constructor
	 * T BlockType extends TetrisPiece
	 */
	public T() {
		super(BlockType.T, new Point(0, 0), Rotation.START);
	}
	
	/**
	 * Moving T constructor
	 * T BlockType extends TetrisPiece
	 */
	public T(final Point thePoint, final Rotation theRotation) {
		super(BlockType.T, thePoint, theRotation);
	}
}

