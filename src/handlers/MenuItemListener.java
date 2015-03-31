package handlers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

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
public class MenuItemListener implements MouseListener {
	Window window = Window.getInstance();

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
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

	@Override
	public void mousePressed(MouseEvent e) {
		//Do Nothing
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//Do nothing
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//change color
		Object source = e.getSource();
		if (source instanceof MenuItem) {
			MenuItem m = (MenuItem) source;
			m.setForeground(new Color(Colors.selected()));
			m.updateUI();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object source = e.getSource();
		if (source instanceof MenuItem) {
			MenuItem m = (MenuItem) source;
			m.setForeground(new Color(Colors.unselected()));
			m.updateUI();
		}
	}

}
