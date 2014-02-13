import java.awt.*;
import javax.swing.*;

public class CarcassonneGui {
	private ScorePanel scorePanel;
	private BoardPanel boardPanel;
	private HandPanel handPanel;
	private Carcassonne game;
	private int lastX;
	private int lastY;

	public CarcassonneGui() {
		scorePanel = new ScorePanel(this);
		boardPanel = new BoardPanel(this);
		handPanel= new HandPanel(this);
		game = new Carcassonne();
	}
	//Returns the Board of the current game.
	public Board getBoard() {
		return game.getBoard();
	}
	/*
	 * method to pass along game
	 * 
	 */
	public Carcassonne getGame(){
		return game;
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
	public HandPanel getHandPanel(){
		return handPanel;
	}

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new CarcassonneFrame(CarcassonneGui.this);
				frame.setTitle("Carcassonne");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);				
//				JFrame nameFrame = new NameFrame(CarcassonneGui.this);
//				nameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//				nameFrame.setVisible(true);
			}
		});
		game.drawTile();
		handPanel.repaint();
		boardPanel.repaint();
		scorePanel.repaint();
	}

	public static void main(String[] args) {
		new CarcassonneGui().run();
	}
	
	public void placeTile(int i, int j) {
		if(game.placeTile(i, j)) {
			boardPanel.repaint();
			lastX= i;
			lastY=j; 
			handPanel.repaint();

			scorePanel.repaint();

		}
	}
	
	public void rotateTile(){
		game.rotateTile();
		
	}
	public boolean isGameOver() {
		return game.isGameOver();
	}
}
