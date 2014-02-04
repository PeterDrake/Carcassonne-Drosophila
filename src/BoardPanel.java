import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class BoardPanel extends JPanel {

	private CarcassonneGui gui;
	
	private static final int DEFAULT_WIDTH = 600;
	private static final int DEFAULT_HEIGHT = 600;

	public BoardPanel(CarcassonneGui gui) {
		this.gui = gui;
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
