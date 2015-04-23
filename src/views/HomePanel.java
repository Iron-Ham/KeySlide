package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
	private Menu menu;
	Window window;
	
	/**
	 * The panel which the program starts with. Contains the navigation menu.
	 * @param window
	 */
	public HomePanel(Window window) {
		this.window = window;
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		menu = new Menu(window);
		menu.setBackground(Color.WHITE);
		menu.setAlignmentY(0.5f);
		menu.setAlignmentX(0.5f);
		setSize(1280, 720);
		add(menu);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon("Assets/PNG/Blue_Abstract.png");
		g.drawImage(utilities.ImageHelper.PrepareFullScreenImageIcon(icon).getImage(), 0, 0, null);
	}
}
