import javax.swing.JFrame;

//we built this class for the display frame, which may not be necessary when we have the rest of the GUI built
public class CarcassonneFrame extends JFrame {
	private CarcassonneGui gui;

	public CarcassonneFrame(CarcassonneGui gui) {
		this.gui = gui;
		add(gui.getScorePanel());
		pack();
	}

}
