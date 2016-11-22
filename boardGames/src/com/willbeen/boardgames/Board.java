package com.willbeen.boardgames;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Board implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Cell[][] cells;
	
//	turn : to know whose turn it is
//	int turn = Piece.BLACK;
	
	public Board() {
		this(8,8);
	}
	
	public Board(int hauteur, int largeur) {
		cells = new Cell[hauteur][largeur];
	}
	
	protected void initCells() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if ((i + j) % 2 == 0) {
					cells[i][j] = new Cell(Cell.WHITE, j, i);
				} else {
					cells[i][j] = new Cell(Cell.BLACK, j, i);
				}
			}
		}
	}
	
////	Sets the "canEat" boolean for every cell of the board
//	public void setCanEat() {
//		for (Cell[] row : board) {
//			for (Cell c : row) {
//				c.setCanEat(this);
//			}
//		}
//	}
	
	public abstract void movePiece(Cell from, Cell to);
	
//	ACCESSEURS
	public Cell[][] getCells() {
		return cells;
	}
	public int getHeight() {
		return this.cells.length;
	}
	public int getWidth() {
		return this.cells[0].length;
	}
	public Cell getCell(int column, int row) {
		return this.cells[row][column];
	}

	public void saveGame() {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("saveboard.ser"));
			oos.writeObject(cells);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void loadGame() {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("saveboard.ser"));
			cells = (Cell[][]) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
