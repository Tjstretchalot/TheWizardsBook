package game;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Entry location for the application (Frame version)
 * @author Tjstretchalot
 */
public class GameApplication extends JFrame {
	private GameApplication() {
		setTitle("The Wizard's Book");
		setLocationRelativeTo(null);
		setSize(640, 480); // I have absolutely no idea what you use
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Game());
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GameApplication();
			}
			
		});
	}
}
