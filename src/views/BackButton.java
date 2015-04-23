package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import utilities.Colors;

/**
 * Back Button allows user to go back to home page when clicked. 
 * @author heshamsalman
 *
 */
public class BackButton extends JButton implements ActionListener, MouseListener {
	Window window;

	public BackButton(Window window) {
		super("Home");
		this.window = window;
		this.setFont(new Font("Arial", Font.PLAIN, 40));
		this.addActionListener(this);
		this.addMouseListener(this);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setForeground(Colors.unselected());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		window.switchToHome();
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
			this.setForeground(Colors.orange());
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
