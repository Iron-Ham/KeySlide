package views;

import javax.swing.JFrame;

/**
 * The window for the program. This is the *only* JFrame for our program.
 * @author heshamsalman
 *
 */
public class Window extends JFrame {
	private static final Window instance = new Window();
	
	
	private Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1280, 720);
	}
	
	public static synchronized Window getInstance() {
		return instance;
	}
}
