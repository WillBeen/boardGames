public class Board {
	private boolean[][] cellColors;
	private Piece[][] pieces;
	
	public Board() {
		cellColors = new boolean[8][8];
		boolean pairRow = true;
		boolean pairColumn = true;
		for (int row = 0; row < cellColors.length; row++) {
			pairRow = !pairRow;
			for (int column = 0; column < cellColors.length; column++) {
				pairColumn = !pairColumn;
				cellColors[row][column] = !(pairRow ^ pairColumn);
			}
		}
	}
	
	public int getHeight() {
		return cellColors[0].length;
	}
	public int getWidth() {
		return cellColors.length;
	}
	public boolean[][] getCellColors() {
		return cellColors;
	}
}
