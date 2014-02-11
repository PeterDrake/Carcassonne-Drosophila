import java.awt.*;
import javax.swing.*;

public class CarcassonneGui {
	private ScorePanel scorePanel;
	private BoardPanel boardPanel;
	private Carcassonne game;

	public CarcassonneGui() {
		scorePanel = new ScorePanel(this);
		boardPanel = new BoardPanel(this);
		game = new Carcassonne();
	}
	//Returns the Board of the current game.
	public Board getBoard() {
		return game.getBoard();
	}
	
	//method to pass along the player
	public Player[] getPlayers() {
		return game.getPlayers();
	}

	public ScorePanel getScorePanel() {
		return scorePanel;
	}
	
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new CarcassonneFrame(CarcassonneGui.this);
				frame.setTitle("Carcassonne");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		new CarcassonneGui().run();
	}
}
