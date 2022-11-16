/**
 * Block enum type for TetrisPiece
 */
package model;

/**
 * @author ddxbugs@github.com
 *	The different type of blocks that can be stored in a Board's grid.
 */
enum Block {
	/** Empty */
	EMPTY,
	/** A unit block from the 'I' tetris piece */
	I,
	/** A unit block from the 'J' tetris piece */
	J,
	/** A unit block from the 'L' tetris piece */
	L,
	/** A unit block from the square tetris piece */
	O,
	/** A unit block from the 'S' tetris piece */
	S,
	/** A unit block from the 'T' tetris piece */
	T,
	/** A unit block from the 'Z' tetris piece */
	Z;
}
