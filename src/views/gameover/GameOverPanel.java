package views.gameover;

import utilities.Colors;
import javax.swing.*;
import java.awt.*;

/**
 * Displays game over image.
 *
 * @author heshamsalman
 */
public class GameOverPanel extends JPanel {
    private static final long serialVersionUID = 3157367815312662841L;
    int score;
    private GameOverMenu menu;

    public GameOverPanel() {
        score = 999;
        setupGUI();
    }

    /**
     * Sets up GUI components.
     */
    private void setupGUI() {
        setLayout(new GridBagLayout());
        menu = new GameOverMenu(score);
        menu.setAlignmentY(0.5f);
        menu.setAlignmentX(0.5f);
        setSize(1280, 720);
        add(menu);
        setBackground(Colors.getRandomColorFamily()[2]);

    }

    /**
     * setter method for score
     * @param score the new value for score
     */
    public void setScore(int score) {
        this.score = score;
        menu.setScore(score);
    }
}
