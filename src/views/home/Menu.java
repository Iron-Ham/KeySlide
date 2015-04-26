package views.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.GameLog;
import views.Window;
import views.navbuttons.MenuItem;

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
	Window window;

	public Menu(Window window) {
		this.window = window;
		setupGui();
	}
	
	/**
	 * Sets up GUI elements.
	 */
	private void setupGui() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		start = new MenuItem(window, "Start");
		start.setSize(150, 120);
		hiScores = new MenuItem(window, "Hi-Scores");
		hiScores.setSize(150, 120);
		instructions = new MenuItem(window, "Instructions");
		instructions.setSize(150, 120);
		attachListeners();
		JLabel title = new JLabel("Key Slide");
		title.setFont(new Font("Arial", Font.BOLD, 64));
		title.setForeground(Color.WHITE);
		add(title);
		add(Box.createRigidArea(new Dimension(10, 150)));
		add(start);
		add(Box.createRigidArea(new Dimension(5, 25)));
		add(hiScores);
		add(Box.createRigidArea(new Dimension(5, 25)));
		add(instructions);
	}
	
	/**
	 * Attaches action listeners to buttons.
	 * This is what allows switching from panel to panel on click.
	 */
	private void attachListeners() {
		GameLog.log.entering(getClass().getName(), "attachListeners");
		start.addActionListener(e -> window.switchToGame());
		hiScores.addActionListener(e -> window.switchToHiScores());
		instructions.addActionListener(e -> window.switchToInstructions());
		GameLog.log.exiting(getClass().getName(), "attachListeners");

	}
}
