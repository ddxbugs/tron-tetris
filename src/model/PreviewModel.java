package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PreviewModel {
	// TODO fix me
	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;
	
	private List<Mino[]> myPreviewBlocks;
	private Mino myMino;
	
	public PreviewModel() {
		myPreviewBlocks = new LinkedList<Mino[]>();
		myMino = null;
	}
	
	public void setNextTetromino(final Mino theMinoType) {
		myMino = Objects.requireNonNull(theMinoType);
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
