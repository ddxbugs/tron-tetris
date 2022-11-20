/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author User
 *
 */
public class BoardModel {
	/** List of static Block array objects currently in view */ 
	private List<Block[]> myFrozenBlocks;
	/** List of predetermined TetrisPieces */
	private List<TetrisPiece> myTetrisPieces;
	public BoardModel() {
		myFrozenBlocks = new LinkedList<Block[]>();
		myTetrisPieces = new ArrayList<TetrisPiece>();
		
	}
	
}
