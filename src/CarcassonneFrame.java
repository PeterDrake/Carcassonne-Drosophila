import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

//we built this class for the display frame, which may not be necessary when we have the rest of the GUI built
public class CarcassonneFrame extends JFrame {
	private CarcassonneGui gui;

	public CarcassonneFrame(CarcassonneGui gui) {
		this.gui = gui;
		setLayout(new GridBagLayout());
		add(gui.getBoardPanel(), new GBC(0, 0, 3, 2).setFill(GBC.BOTH).setWeight(1, 1));
		add(gui.getScorePanel(), new GBC(1, 2, 2, 1).setFill(GBC.BOTH).setWeight(1, 1));
		add(gui.getHandPanel(), new GBC(0, 2, 1, 1).setFill(GBC.BOTH).setWeight(1, 1));
		pack();
	}

}
