import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HandPanel extends JPanel {
	private CarcassonneGui gui;
	private Dimension dim;
	private Tile hand;

	public HandPanel(CarcassonneGui gui) {
		this.gui = gui;
	}

	public void paintComponent(Graphics G) {
		if (gui.getGame().getTileInHand() != null) {
			hand = gui.getGame().getTileInHand();
			Image image = new ImageIcon(hand.getFileName()).getImage();
			G.drawImage(image, 0, 0, null);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(gui.getBoardPanel().TILE_WIDTH,
				gui.getBoardPanel().TILE_WIDTH);
	}
}
