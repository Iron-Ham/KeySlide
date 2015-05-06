package views;

import utilities.DBUtility;
import utilities.GameLog;
import views.directions.InstructionPanel;
import views.game.GamePanel;
import views.gameover.GameOverPanel;
import views.highscores.HighScoreDialogFrame;
import views.highscores.HighScoresPanel;
import views.home.HomePanel;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

/**
 * The main window for the program
 *
 * @author heshamsalman
 */
public class Window extends JFrame {
    private static final long serialVersionUID = -8731966412182953292L;
    private static JPanel basePanel;
    private static CardLayout cardLayout = new CardLayout();
    private static GameOverPanel gameOverPanel;
    private static GamePanel gamePanel;
    private static HighScoresPanel scorePanel;


    /**
     * Constructor for window.
     * Adds all sub-panels to the base panel.
     * To add a new panel to the program, make sure you add it here, give it a label, and create a
     * switchTo method for it.
     */
    public Window() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setResizable(false);
        setTitle("KeySlide");
        setupGui();
    }

    /**
     * Sets up the GUI for this Frame
     */
    private void setupGui() {
        HomePanel homePanel = new HomePanel(this);
        gameOverPanel = new GameOverPanel();
        basePanel = new JPanel();
        InstructionPanel instructionPanel = new InstructionPanel();
        gamePanel = new GamePanel();
        gamePanel.setFocusable(true);
        scorePanel = new HighScoresPanel();
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
    public synchronized static void switchToGame() {
        gamePanel.start();
        cardLayout.show(basePanel, "game");
        gamePanel.requestFocusInWindow();
    }

    /**
     * Switches to game over panel
     */
    public synchronized static void switchToGameOver() {
        System.gc();
        int score = gamePanel.getScore();
        if (DBUtility.isHighScore(score)) {
            GameLog.log.log(Level.INFO, "New High Score: " + score);
            HighScoreDialogFrame highScoreDialog = new HighScoreDialogFrame(score);
            highScoreDialog.setVisible(true);
        }
        gameOverPanel.setScore(score);
        cardLayout.show(basePanel, "game over");
    }

    /**
     * Switches to instruction panel
     */
    public synchronized static void switchToInstructions() {
        cardLayout.show(basePanel, "instructions");
    }

    /**
     * Switches to home panel
     */
    public synchronized static void switchToHome() {
        cardLayout.show(basePanel, "home");
    }

    /**
     * Switches to high-score panel;
     */
    public synchronized static void switchToHiScores() {
        scorePanel.updateSelf();
        cardLayout.show(basePanel, "scores");
    }
}
