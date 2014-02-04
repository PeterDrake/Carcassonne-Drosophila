import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {

	private CarcassonneGui gui;

	public ScorePanel(CarcassonneGui gui) {
		this.gui = gui;
	}

	//arbitrary location and size, can be changed when the GUI is further along
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	//displays player 1's score. can add other player's scores when multiple players added
	public void paintComponent(Graphics g) {
		g.drawString("Player 1 score: " + gui.getScore(), MESSAGE_X, MESSAGE_Y);
	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}