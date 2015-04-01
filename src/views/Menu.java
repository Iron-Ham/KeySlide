package views;

import java.awt.Dimension;

import handlers.MenuItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * The Menu. This houses all menu items. 
 * @author heshamsalman
 *
 */
public class Menu extends JPanel {
	private static final long serialVersionUID = -6758351920150177724L;
	private MenuItem start;
	private MenuItem hiScores;
	private MenuItem instructions;
	private MenuItemListener itemListener;
	
	public Menu() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		start = new MenuItem("Start");
		start.setSize(150, 120);
		hiScores = new MenuItem("Hi-Scores");
		instructions = new MenuItem("Instructions");
		attachListeners();
		add(start);
		add(Box.createRigidArea(new Dimension(5, 25)));
		add(hiScores);
		add(Box.createRigidArea(new Dimension(5, 25)));
		add(instructions);
	}
	
	private void attachListeners() {
		start.addActionListener(itemListener);
		hiScores.addActionListener(itemListener);
		instructions.addActionListener(itemListener);
	}
}
