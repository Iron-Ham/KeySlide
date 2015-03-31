package handlers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import contracts.InstructionStatus;
import utilities.Colors;
import views.GamePanel;
import views.InstructionPanel;
import views.MenuItem;
import views.ScorePanel;
import views.Window;

/**
 * Listens for mouse over and mouse click events on the menu items. 
 * @author heshamsalman
 *
 */
public class MenuItemListener implements ActionListener {
	Window window = Window.getInstance();
	private static Logger logger =  Logger.getLogger(InstructionStatus.class.getName());
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		logger.log(Level.INFO, "Button click event.");
		if (source instanceof MenuItem) {
			MenuItem m = (MenuItem) source;
			switch (m.getText()) {
			case "Start":
				JPanel game = new GamePanel();
				window.setContentPane(game);
				break;
			case "Hi-Scores":
				JPanel score = new ScorePanel();
				window.setContentPane(score);
				break;
			case "Instructions":
				JPanel instructions = new InstructionPanel();
				window.setContentPane(instructions);
				break;
			}
		}
	}
}
