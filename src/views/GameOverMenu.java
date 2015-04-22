package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameOverMenu extends JPanel {

	private JLabel gameOver;
	private JLabel score;
	private ReplayButton replayButton;
	private BackButton backButton;
	
	public GameOverMenu(Window window, int points) {
		gameOver = new JLabel("Game Over");
		gameOver.setFont(new Font("Arial", Font.PLAIN, 40));
		gameOver.setForeground(Color.WHITE);
		score = new JLabel("Score: " + points); //TODO: Connect with database for actual score, or pass score to menu.
		score.setFont(new Font("Arial", Font.PLAIN, 40));
		score.setForeground(Color.WHITE);
		replayButton = new ReplayButton(window);
		backButton = new BackButton(window);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		gameOver.setSize(512, 256);
		add(gameOver);
		add(Box.createRigidArea(new Dimension(5, 25)));
		add(score);
		add(Box.createRigidArea(new Dimension(5, 25)));
		add(replayButton);
		add(Box.createRigidArea(new Dimension(5, 25)));
		add(backButton);
	}
	
}
