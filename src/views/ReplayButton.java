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
	private static final long serialVersionUID = -8928983203121047464L;
	Window window;
	
	public ReplayButton(Window window) {
		super("Replay");
		this.window = window;
		addActionListener(this);
		setFont(new Font("Arial", Font.PLAIN, 40));
		setContentAreaFilled(false);
		addMouseListener(this);
		setFocusPainted(false);
		setBorder(BorderFactory.createEmptyBorder());
		setForeground(Colors.unselected());
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
			setForeground(Colors.selected());
		}
		updateUI();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == this) {
			setForeground(Colors.unselected());
		}
		updateUI();
	}
}
