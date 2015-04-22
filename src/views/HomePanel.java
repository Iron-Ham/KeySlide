package views;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class HomePanel extends JPanel {
	private Menu menu;
	Window window;
	
	public HomePanel(Window window) {
		this.window = window;
		setLayout(new GridBagLayout());
		menu = new Menu(window);
		menu.setAlignmentY(0.5f);
		menu.setAlignmentX(0.5f);
		setSize(1280, 720);
		add(menu);
	}
}
