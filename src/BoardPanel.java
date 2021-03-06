import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * BoardPanel is a panel attached to CarcassonneFrame that draws the board and a
 * tile/tiles on it.
 * 
 */
public class BoardPanel extends JPanel implements MouseListener {

	private CarcassonneGui gui;

	private static final int DEFAULT_WIDTH = 900;

	private static final int DEFAULT_HEIGHT = 540;
	//Each Tile image is 90x90, so the height is the same as the width.
	public static final int TILE_WIDTH = 90;

	private Board board;

	private Image image;
	private Image meepleImage;

	public BoardPanel(CarcassonneGui gui) {
		JButton addFollower = new JButton("Add a Follower");
		this.add(addFollower);
		AddFollowerAction addFollowerAction = new AddFollowerAction();
		addFollower.addActionListener(addFollowerAction);
		
		JButton rotate = new JButton("Rotate tile (Clockwise)");
		this.add(rotate);
		RotateAction rotateAction = new RotateAction();
		rotate.addActionListener(rotateAction);
		
		
		this.gui = gui;
		addMouseListener(this);
	}

	/**
	 * This method is retrieving all placed tiles from the Board and, for the
	 * sake of screen space, drawing the center tiles, from tile 62,62 to tile
	 * 82, 82. (A 10x10 grid)
	 */
	public void paintComponent(Graphics g) {
		// g.drawString("Player 1 score: " + gui.getScore(), 75, 100);
		board = gui.getBoard();
		Tile currentTile;
		meepleImage = new ImageIcon("blackMeeple.png").getImage();
		for (int i = 0; i < board.MAX_BOARD_SIZE; i++) {
			for (int j = 0; j < board.MAX_BOARD_SIZE; j++) {
				currentTile = board.getTile(i, j);
				if (currentTile != null) {
					image = new ImageIcon(currentTile.getFileName()).getImage();
					g.drawImage(
							image,
							(i - (board.TABLE_MID - 5)) * TILE_WIDTH,
							DEFAULT_HEIGHT
									- ((j - (board.TABLE_MID - 5)) * TILE_WIDTH),
							null);
				}

				g.setColor(Color.BLACK);
				g.drawRect((i - (board.TABLE_MID - 5)) * TILE_WIDTH,
						DEFAULT_HEIGHT
								- ((j - (board.TABLE_MID - 5)) * TILE_WIDTH),
						TILE_WIDTH, TILE_WIDTH);
			}
		}

		for (int i = 0; i < board.MAX_BOARD_SIZE; i++) {
			for (int j = 0; j < board.MAX_BOARD_SIZE; j++) {
				currentTile = board.getTile(i, j);
				if (currentTile != null) {
					if (currentTile.hasMeeple()) {
//						System.out.println("PRINTING MEEPLE");
//						while (!g.drawImage(meepleImage, 0, 0, null))
//							;
//						System.out.println("Done printing meeple");
						while (!g
								.drawImage(
										meepleImage,
										(i - (board.TABLE_MID - 5))
												* TILE_WIDTH,
										DEFAULT_HEIGHT
												- ((j - (board.TABLE_MID - 5)) * TILE_WIDTH),
										null)) {

						}
					}
				}
			}
		}
		repaint();
	}

	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	@Override
	public void mouseClicked(MouseEvent mouse) {
		// TODO Auto-generated method stub
		int x = TILE_WIDTH * (mouse.getX() / TILE_WIDTH);
		int y = TILE_WIDTH * (mouse.getY() / TILE_WIDTH);

		System.out.println("You clicked at pixels "+mouse.getX()+ "|" +mouse.getY());
		System.out.println("You clicked at pixels "+x+ "|" +y);

		int i = (x / TILE_WIDTH) + (board.TABLE_MID - 5);
		int j = (y - DEFAULT_HEIGHT) / (-TILE_WIDTH) + (board.TABLE_MID - 5);

		System.out.println("You Clicked At: " + i + "|" + j);
		
		gui.placeTile(i, j);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private class AddFollowerAction implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			board.placeMeeple(board.getLastX(), board.getLastY(), 0, 0);
			// gui.addFollower();
		}
	}
	
	private class RotateAction implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			gui.rotateTile();
			// gui.addFollower();
		}
	}
}
