import javax.swing.JFrame;


public class CarcassonneFrame extends JFrame
{
	private CarcassonneGui gui; 
	public CarcassonneFrame(CarcassonneGui gui){
		this.gui=gui; 
		add( gui.getScorePanel());
	      pack();
	}

}

