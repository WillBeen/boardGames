package com.willbeen.boardgames;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Game extends JFrame implements MouseListener, MouseMotionListener, ActionListener {
	private Panel pan;
	private Point dragOrigin = new Point();
	private Board board;
	private ButtonDescription[] buttonDescriptions;
	
	public static void main(String[] args) {
		Game g = new Game();
		g.setVisible(true);
	}

	public Game(){
		
//		Initializes buttons
		int buttonNumber = 3;
		buttonDescriptions = new ButtonDescription[buttonNumber];
		JButton[] actionButtons = new JButton[buttonDescriptions.length];
		int index = 0;
		buttonDescriptions[index++] = new ButtonDescription("Start a new game", "newGame");
		buttonDescriptions[index++] = new ButtonDescription("Save this game", "saveGame");
		buttonDescriptions[index++] = new ButtonDescription("Load a saved game", "loadGame");
		
		pan = new Panel(this, board);
		pan.setButtons(this, buttonDescriptions);
	    pan.addMouseMotionListener(this);
	    pan.addMouseListener(this);
	    pan.setOpaque(true);
		this.setSize(800, 600);
		this.setTitle("Jeu de dames anglaises");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
//		Thread threadAnim = new Thread(new Animation(pan));
//		threadAnim.start();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
//		pan.setMoveTo(e.getPoint());
		pan.setCursorX(e.getX());
		pan.setCursorY(e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pan.setCursorX(e.getX());
		pan.setCursorY(e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		pan.setMoveFrom(e.getPoint());
//		pan.setMoveTo(e.getPoint());
		pan.setMousePressed(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		pan.movePiece();
//		pan.setMoveFrom(null);
//		pan.setMoveTo(null);
		pan.setMousePressed(false);
	}

	public Point getDragOrigin() {
		return dragOrigin;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "newGame" : 
			newGame();
			System.out.println("new");
		break;
		case "saveGame" : 
			saveGame();
		break;
		case "loadGame" :
			loadGame();
		break;
		}
	}
	
	public void newGame() {
		board = (Board) new EnglishDraughtBoard();
//		pan.repaint();
	}
	
	public void saveGame() {
		System.out.println("save");
	}
	
	public void loadGame() {
		System.out.println("load");
//		board.setCanEat();
	}
	
}
