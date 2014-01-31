import java.awt.*;
import javax.swing.*;

public class CarcassonneGui {
	private ScorePanel scorePanel;
	private Carcassonne game;

	public CarcassonneGui() {
		scorePanel = new ScorePanel(this);
		game= new Carcassonne(); 

	}

	public int getScore() {
		return game.getScore();
	}

	public ScorePanel getScorePanel() {
		return scorePanel;
	}

	public void run(){
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
