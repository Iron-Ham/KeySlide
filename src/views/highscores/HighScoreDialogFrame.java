package views.highscores;

import javax.swing.*;

/**
 * Window for high score dialog
 *
 * @author heshamsalman
 */
public class HighScoreDialogFrame extends JFrame {
    private static final long serialVersionUID = 6925482381491363120L;
    HighScoresPromptPanel prompt;

    public HighScoreDialogFrame(int score) {
        setVisible(false);
        if (prompt == null) {
            prompt = new HighScoresPromptPanel(this, score);
            add(prompt);
        }
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
