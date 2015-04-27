package views.gameover;

import views.Window;
import views.navbuttons.BackButton;
import views.navbuttons.ReplayButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Game over screen.
 * Displays GameOver message, shows user score, and has navigation buttons.
 *
 * @author heshamsalman
 */
public class GameOverMenu extends JPanel {
    private static final long serialVersionUID = 3752554785961368904L;
    Window window;
    int points;
    private JLabel gameOver;
    private JLabel score;
    private ReplayButton replayButton;
    private BackButton backButton;

    /**
     * @param window the window
     * @param points number of points earned in game
     */
    public GameOverMenu(Window window, int points) {
        this.window = window;
        this.points = points;
        setupGUI();
    }

    /**
     * subcomponent layout and text
     */
    private void setupGUI() {
        gameOver = new JLabel("Game Over");
        setOpaque(false);
        gameOver.setFont(new Font("Arial", Font.PLAIN, 40));
        gameOver.setForeground(Color.WHITE);
        score = new JLabel("Score: " + points);
        score.setFont(new Font("Arial", Font.PLAIN, 40));
        score.setForeground(Color.WHITE);
        replayButton = new ReplayButton(window);
        backButton = new BackButton(window) {
            private static final long serialVersionUID = 6516006810869991726L;

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == this) {
                    this.setForeground(Color.WHITE);
                }
                this.updateUI();
            }
        };
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

    public void setScore(int points) {
        score.setText("Score: " + points);
        score.updateUI();
    }

}
