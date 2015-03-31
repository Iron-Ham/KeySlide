package views;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import utilities.Colors;

/**
 * Menu Items are labels that allow the user to go to different panels of the game. 
 * @author heshamsalman
 *
 */
public class MenuItem extends JButton implements MouseListener{
	public MenuItem(String text) {
		this.setText(text);
		this.setForeground(new Color(Colors.unselected()));
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == this) {
			this.setForeground(new Color(Colors.selected()));
		}
		this.updateUI();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == this) {
			this.setForeground(new Color(Colors.unselected()));
		}
		this.updateUI();
	}
}
