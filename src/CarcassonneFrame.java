import java.awt.BorderLayout;

import javax.swing.JFrame;

//we built this class for the display frame, which may not be necessary when we have the rest of the GUI built
public class CarcassonneFrame extends JFrame {
	private CarcassonneGui gui;

	public CarcassonneFrame(CarcassonneGui gui) {
		this.gui = gui;
		setLayout(new BorderLayout());
		add(gui.getBoardPanel(), BorderLayout.NORTH);
		add(gui.getScorePanel(), BorderLayout.SOUTH);
		add(gui.getHandPanel(), BorderLayout.SOUTH);
		pack();
	}

}
