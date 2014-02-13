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
	public static final int GAMEOVER_MESSAGE_X = 250;
	public static final int GAMEOVER_MESSAGE_Y = 115;

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	//displays player 1's score. can add other player's scores when multiple players added
	public void paintComponent(Graphics g) {
		int i = 0;
		for(Player p : gui.getPlayers()){
			if(p != null){
				g.drawString(p.getName() + "'s score: " + p.getScore(), MESSAGE_X, MESSAGE_Y + 10 * i );
			}
			i++;
		}
		if(gui.isGameOver()) {
			g.drawString("THE GAME IS OVER.", GAMEOVER_MESSAGE_X, GAMEOVER_MESSAGE_Y );
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
