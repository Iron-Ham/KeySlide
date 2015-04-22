package views;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel {
	private GameOverMenu menu;
	Window window;
	
	public GameOverPanel(Window window) {
		this.window = window;
		setLayout(new GridBagLayout());
		menu = new GameOverMenu(window, 3);
		menu.setAlignmentY(0.5f);
		menu.setAlignmentX(0.5f);
		setSize(1280, 720);
		add(menu);
	}
}
