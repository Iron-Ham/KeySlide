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
    private JPanel basePanel;
    private CardLayout cardLayout = new CardLayout();
    private GameOverPanel gameOverPanel;
    private GamePanel gamePanel;
    private HighScoresPanel scorePanel;


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
        gameOverPanel = new GameOverPanel(this);
        basePanel = new JPanel();
        InstructionPanel instructionPanel = new InstructionPanel(this);
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
        GameLog.log.entering(getClass().getName(), "switchToGame");
        gamePanel.start();
        cardLayout.show(basePanel, "game");
        gamePanel.requestFocusInWindow();
        GameLog.log.exiting(getClass().getName(), "switchToGame");
    }

    /**
     * Switches to game over panel
     */
    public void switchToGameOver() {
        GameLog.log.entering(getClass().getName(), "switchToGameOver");
        int score = gamePanel.getScore();
        if (DBUtility.isHighScore(score)) {
            GameLog.log.log(Level.INFO, "New High Score: " + score);
            HighScoreDialogFrame highScoreDialog = new HighScoreDialogFrame(score);
            highScoreDialog.setVisible(true);
        }
        gameOverPanel.setScore(score);
        cardLayout.show(basePanel, "game over");
        GameLog.log.exiting(getClass().getName(), "setStatus");
    }

    /**
     * Switches to instruction panel
     */
    public void switchToInstructions() {
        GameLog.log.entering(getClass().getName(), "switchToInstructions");
        cardLayout.show(basePanel, "instructions");
        GameLog.log.exiting(getClass().getName(), "switchToInstructions");
    }

    /**
     * Switches to home panel
     */
    public void switchToHome() {
        GameLog.log.entering(getClass().getName(), "switchToHome");
        cardLayout.show(basePanel, "home");
        GameLog.log.exiting(getClass().getName(), "switchToHome");
    }

    /**
     * Switches to high-score panel;
     */
    public void switchToHiScores() {
        GameLog.log.entering(getClass().getName(), "switchToHiScores");
        scorePanel.updateSelf();
        cardLayout.show(basePanel, "scores");
        GameLog.log.exiting(getClass().getName(), "switchToHiScores");
    }
}
