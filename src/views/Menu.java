package views;

import handlers.MenuItemListener;

import javax.swing.JPanel;

public class Menu extends JPanel {
	private MenuItem start;
	private MenuItem hiScores;
	private MenuItem instructions;
	private MenuItemListener itemListener;
	
	public Menu() {
		start = new MenuItem("Start");
		hiScores = new MenuItem("Hi-Scores");
		instructions = new MenuItem("Instructions");
		attachListeners();
	}
	
	private void attachListeners() {
		start.addMouseListener(itemListener);
		hiScores.addMouseListener(itemListener);
		instructions.addMouseListener(itemListener);
	}
}
