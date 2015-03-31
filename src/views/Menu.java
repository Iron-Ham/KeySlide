package views;

import handlers.MenuItemListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * The Menu. This houses all menu items. 
 * @author heshamsalman
 *
 */
public class Menu extends JPanel {
	private MenuItem start;
	private MenuItem hiScores;
	private MenuItem instructions;
	private MenuItemListener itemListener;
	
	public Menu() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		start = new MenuItem("Start");
		hiScores = new MenuItem("Hi-Scores");
		instructions = new MenuItem("Instructions");
		attachListeners();
		this.
		add(start);
		add(hiScores);
		add(instructions);
	}
	
	private void attachListeners() {
		start.addMouseListener(itemListener);
		hiScores.addMouseListener(itemListener);
		instructions.addMouseListener(itemListener);
	}
}
