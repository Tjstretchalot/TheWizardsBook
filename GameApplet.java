package game;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

/**
 * Entry location for the applet
 * @author Tjstretchalot
 */
public class GameApplet extends JApplet {
	private static final long serialVersionUID = 1L;

	private GameApplet() {
		add(new Game());
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GameApplet();
			}
			
		});
	}
}
