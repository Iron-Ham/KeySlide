package views;

import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Displays game over image. 
 * @author heshamsalman
 *
 */
public class GameOverPanel extends JPanel {
	private static final long serialVersionUID = 3157367815312662841L;
	private GameOverMenu menu;
	Window window;
	int score;
	
	public GameOverPanel(Window window) {
		this.window = window;
		score = 999;
		setupGUI();
	}
	
	/**
	 * Sets up GUI components.
	 */
	private void setupGUI() {
		setLayout(new GridBagLayout());
		menu = new GameOverMenu(window, score);
		menu.setAlignmentY(0.5f);
		menu.setAlignmentX(0.5f);
		setSize(1280, 720);
		add(menu);
	}
	
	public void setScore(int score) {
		this.score = score;
		menu.setScore(score);
	}
	
	
	/**
	 * Sets background.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon("Assets/PNG/bg.jpg");
		g.drawImage(utilities.ImageHelper.PrepareFullScreenImageIcon(icon).getImage(), 0, 0, null);
	}
}
