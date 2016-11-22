import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener{
	public static final Color whiteCellColor = new Color(244, 235, 124);
	public static final Color blackCellColor = new Color(50, 10, 10);
	
	private Game game;
	private Board board = null;
	private int border = 20;
	private int coteCellule;
	private JButton[] actionButtons = null;

	public Panel(Game game) {
		this.game = game;
//		Initializes button
		String[][] buttonDescriptions = {
			{"Start a new game", "newGame"},
			{"Save this game", "saveGame"},
			{"Load a saved game", "loadGame"}
		};
		actionButtons = new JButton[buttonDescriptions.length];
		
		for(int i = 0; i < buttonDescriptions.length; i++) {
			actionButtons[i] = new JButton(buttonDescriptions[i][0]);
			actionButtons[i].setVerticalTextPosition(AbstractButton.CENTER);
			actionButtons[i].setHorizontalTextPosition(AbstractButton.LEADING);
			actionButtons[i].setMnemonic(KeyEvent.VK_D);
			actionButtons[i].setActionCommand(buttonDescriptions[i][1]);
			actionButtons[i].addActionListener(this);
			add(actionButtons[i]);
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.repaint();
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		paintBoard((Graphics2D)g);
	}
	
	public void paintBoard(Graphics2D g) {
		if (board != null) {
			int x = border;
			int y = border;
			g.setColor(Color.BLACK);
			for (boolean[] row : board.getCellColors()) {
				for (boolean color : row) {
					if (color) {
						g.setColor(Panel.whiteCellColor);
					} else {
						g.setColor(Panel.blackCellColor);
					}
					g.fillRect(x, y, coteCellule, coteCellule);
					x += coteCellule;
				}
				x = border;
				y += coteCellule;
			}
			g.setColor(Panel.blackCellColor);
			g.drawRect(border, border, board.getWidth() * coteCellule, board.getHeight() * coteCellule);
		}
	}
	
	public void setBoard(Board board) {
		this.board = board;
		setSizes();
	}
	
	public void setButtons() {
	}
	
	private void setSizes() {
		coteCellule = Math.min((getHeight() - 2 * border) / board.getHeight(),
				(getWidth() - 2 * border) / board.getWidth());
		setButtonsPosition();
	}
	
	private void setButtonsPosition() {
		if ((board != null) && (actionButtons != null)) {
			int x = 2 * border + coteCellule * board.getWidth();
			int y = border;
			int verticalSpace = 10;
			for (JButton button : actionButtons) {
				button.setLocation(x, y);
				y += verticalSpace + button.getHeight();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.actionPerformed(e.getActionCommand());
	}
}
