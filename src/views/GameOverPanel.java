package views;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel {
	private GameOverMenu menu;
	Window window;
	int score;
	
	public GameOverPanel(Window window) {
		score = 999;
		this.window = window;
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
}
