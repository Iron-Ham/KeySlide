package views;

import javax.swing.JFrame;

public class HighScoreDialogFrame extends JFrame {

	HighScoresPromptPanel prompt;
	
	
	public HighScoreDialogFrame(int score) {
		prompt = new HighScoresPromptPanel(this, score);
		add(prompt);
		setSize(420,420);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
