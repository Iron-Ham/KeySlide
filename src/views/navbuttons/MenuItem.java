package views.navbuttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import utilities.Colors;
import views.Window;

/**
 * Menu Items are JButtons that allow the user to go to different panels of the game. 
 * @author heshamsalman
 *
 */
public class MenuItem extends JButton implements MouseListener{
	private static final long serialVersionUID = 3699142395262583263L;
	Window window;
	public MenuItem(Window window, String text) {
		this.window = window;
		setText(text);
		setActionCommand(text);
		addMouseListener(this);
		setupGui();
	}
	
	private void setupGui() {
		setFont(new Font("Arial", Font.PLAIN, 40));
		setMaximumSize(new Dimension(400, 100));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorder(BorderFactory.createEmptyBorder());
		setForeground(Colors.orange());
	}

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
			setForeground(Colors.orange());
		}
		updateUI();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}
}
