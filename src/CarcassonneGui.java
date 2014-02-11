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
	
	//method to pass along the game's score to the ScorePanel
	public int getScore() {
		return game.getScore();
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
		game.drawTile();
		boardPanel.repaint();
	}

	public static void main(String[] args) {
		new CarcassonneGui().run();
	}
	public void placeTile(int i, int j) {
		if(game.getBoard().isValidMove(i, j, game.getTileInHand()))
		{
			System.out.println("Legal Move At: " + i + "|" + j);
			game.getBoard().placeTile(game.getTileInHand(), i, j);
			boardPanel.repaint();
		}
		
		System.out.println("Not Legal Move");
	}
}
