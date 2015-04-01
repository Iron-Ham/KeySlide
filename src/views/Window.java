package views;

import java.awt.GridBagLayout;
import javax.swing.JFrame;

/**
 * The window for the program. This is the *only* JFrame for our program.
 * @author heshamsalman
 *
 */
public class Window extends JFrame {
	private static final long serialVersionUID = -8731966412182953292L;
	private static final Window instance = new Window();
	private Menu menu;
	
	private Window() {
		setLayout(new GridBagLayout());
		menu = new Menu();
		menu.setAlignmentX(0.5f);
		menu.setAlignmentY(0.5f);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1280, 720);
		add(menu);
	}
	
	public static synchronized Window getInstance() {
		return instance;
	}
}
