package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import utilities.Colors;

/**
 * Replay Button allows user to replay game
 * @author heshamsalman
 *
 */
public class ReplayButton extends JButton implements ActionListener, MouseListener{
	Window window;
	
	public ReplayButton(Window window) {
		super("Replay");
		this.window = window;
		this.addActionListener(this);
		this.setFont(new Font("Arial", Font.PLAIN, 40));
		this.setContentAreaFilled(false);
		this.addMouseListener(this);
		this.setFocusPainted(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setForeground(Colors.unselected());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		window.switchToGame();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == this) {
			this.setForeground(Colors.selected());
		}
		this.updateUI();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == this) {
			this.setForeground(Colors.unselected());
		}
		this.updateUI();
	}
}
