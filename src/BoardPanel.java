import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * BoardPanel is a panel attached to CarcassonneFrame that draws the board and a tile/tiles on it.
 *
 */
public class BoardPanel extends JPanel {

	private CarcassonneGui gui;
	
	private static final int DEFAULT_WIDTH = 900;
	private static final int DEFAULT_HEIGHT = 900;
	//Each Tile image is 90x90, so the height is the same as the width.
	private final int TILE_WIDTH = 90;
	
	private Board board;
	
	private Image image;

	public BoardPanel(CarcassonneGui gui) {
		this.gui = gui;
	}
	
	/**
	 * This method is retrieving all placed tiles from the Board and, for the sake of screen space,
	 * drawing the center tiles, from tile 62,62 to tile 82, 82. (A 10x10 grid)
	 */
	public void paintComponent(Graphics g) {
		//g.drawString("Player 1 score: " + gui.getScore(), 75, 100);
		board = gui.getBoard();
		Tile currentTile;
		for(int i = 0; i < board.TABLE_WIDTH; i++) {
			for(int j = 0; j < board.TABLE_WIDTH; j++) {
				currentTile = board.getTile(i, j);
				if(currentTile != null) {
					image = new ImageIcon(currentTile.getFileName()).getImage();
					g.drawImage(image, (i - (board.TABLE_MID - 5)) * TILE_WIDTH, 
							DEFAULT_HEIGHT - ((j - (board.TABLE_MID - 5)) * TILE_WIDTH), null);					
				}
			}
		}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
