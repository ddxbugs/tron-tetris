package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PreviewModel {
	// TODO fix me
	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;
	
	private List<Mino[]> myPreviewBlocks;
	private Tetromino myNextPiece;
	
	public PreviewModel() {
		myPreviewBlocks = new LinkedList<Mino[]>();
		myNextPiece = null;
	}
	
	public void setNextTetromino(final Tetromino theNextTetromino) {
		myNextPiece = Objects.requireNonNull(theNextTetromino);
	}
	
	public Mino[] getPreviewBlocks() {
		Mino[] arr = new Mino[WIDTH * HEIGHT];
		int i = 0;
		for (Mino[] blocks : myPreviewBlocks)
			for (Mino block : blocks) {
				arr[i++] = block;
			}
		return arr;
	}
	
	public int getWidth() {
		return WIDTH;
	}
}
