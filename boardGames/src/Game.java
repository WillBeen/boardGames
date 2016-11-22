
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Game extends JFrame implements MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title = "Jeux de plateau";
	private Panel pan = new Panel(this);
	
	public static void main(String[] args) {
		Game g = new Game();
		g.setVisible(true);
	}

	public Game(){
	    pan.addMouseMotionListener(this);
	    pan.addMouseListener(this);
	    pan.setOpaque(true);
		this.setSize(800, 600);
		this.setTitle(title);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
//		Thread threadAnim = new Thread(new Animation(pan));
//		threadAnim.start();
		
		this.setVisible(true);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
//		pan.setMoveTo(e.getPoint());
//		pan.setCursorX(e.getX());
//		pan.setCursorY(e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
//		pan.setCursorX(e.getX());
//		pan.setCursorY(e.getY());
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
//		pan.setMousePressed(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		pan.movePiece();
//		pan.setMoveFrom(null);
//		pan.setMoveTo(null);
//		pan.setMousePressed(false);
	}
//
//	public Point getDragOrigin() {
//		return dragOrigin;
//	}

	public void actionPerformed(String actionCommand) {
		switch (actionCommand) {
		case "newGame" : newGame();
		break;
		case "saveGame" : saveGame();
		break;
		case "loadGame" : loadGame();
		break;
		}
	}
	
	public void newGame() {
		System.out.println("new game");
		pan.setBoard(new Board());
	}
	
	public void saveGame() {
		System.out.println("save game");
	}
	
	public void loadGame() {
		System.out.println("load game");
	}
}
