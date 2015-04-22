package views;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utilities.DBUtility;

/**
 * The window for the program. This is the *only* JFrame for our program.
 * @author heshamsalman
 *
 */

//Hi
public class Window extends JFrame {
	private static final long serialVersionUID = -8731966412182953292L;
	private JPanel basePanel;
	private CardLayout cardLayout = new CardLayout();
	private Menu menu;
	private HomePanel homePanel;
	private HighScoreDialogFrame highScoreDialog;
	private GameOverPanel gameOverPanel;
	private GamePanel gamePanel;
	private InstructionPanel instructionPanel;
	private HighScoresPanel scorePanel;

	/**
	 * Constructor for window.
	 * Adds all sub-panels to the base panel.
	 * To add a new panel to the program, make sure you add it here, give it a label, and create a
	 * switchTo method for it.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setResizable(false);
		setTitle("KeySlide");
		homePanel = new HomePanel(this);
		gameOverPanel = new GameOverPanel(this);
		basePanel = new JPanel();
		instructionPanel = new InstructionPanel(this);
		DirectionPanel d = new DirectionPanel();
		gamePanel = new GamePanel(this);
		gamePanel.setFocusable(true);
		scorePanel = new HighScoresPanel(this);
		basePanel.setLayout(cardLayout);
		basePanel.add(homePanel, "home");
		basePanel.add(instructionPanel, "instructions");
		basePanel.add(gamePanel, "game");
		basePanel.add(scorePanel, "scores");
		basePanel.add(gameOverPanel, "game over");

		add(basePanel);
	}

	/**
	 * Switches to game panel
	 */
	public void switchToGame() {
		gamePanel.start();
		cardLayout.show(basePanel, "game");
		gamePanel.requestFocusInWindow();
	}

	/**
	 * Switches to game over panel
	 */
	public void switchToGameOver() {
		int score = gamePanel.getScore();
		if(DBUtility.isHighScore(score)){
			highScoreDialog = new HighScoreDialogFrame(score);
			highScoreDialog.setVisible(true);
		}
		gameOverPanel.setScore(score);
		cardLayout.show(basePanel, "game over");
	}

	/**
	 * Switches to instruction panel
	 */
	public void switchToInstructions() {
		System.out.println("Switch called");
		cardLayout.show(basePanel, "instructions");
	}

	/**
	 * Switches to home panel
	 */
	public void switchToHome() {
		cardLayout.show(basePanel, "home");
	}

	/**
	 * Switches to high-score panel;
	 */
	public void switchToHiScores() {
		scorePanel.updateSelf();
		cardLayout.show(basePanel, "scores");
	}



}
