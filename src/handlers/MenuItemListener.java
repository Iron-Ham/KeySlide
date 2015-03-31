package handlers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import utilities.Colors;
import views.MenuItem;

public class MenuItemListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		//Return panel
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
