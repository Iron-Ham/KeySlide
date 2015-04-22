package views;

import javax.swing.JFrame;

public class HighScoreDialogFrame extends JFrame {

	HighScoresPromptPanel prompt;
	
	
	public HighScoreDialogFrame(int score) {
		setVisible(false);
		if (prompt == null) {
			prompt = new HighScoresPromptPanel(this, score);
			add(prompt);
		}
		setSize(420,420);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
