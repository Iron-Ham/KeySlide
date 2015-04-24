package views.navbuttons;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import utilities.Colors;
import views.Window;

/**
 * The abstract class defining behavior for navigation buttons.
 * @author heshamsalman
 *
 */
public abstract class NavigationButton extends JButton implements ActionListener, MouseListener {
	private static final long serialVersionUID = 8971973612959800330L;
	Window window;
	
	/**
	 * Should be ran at initialization of the concrete class.
	 * Initializes all components of the abstract class.
	 */
	protected void initializeComponents() {
		addListeners();
		setupLookAndFeel();
	}
	
	private void addListeners() {
		addActionListener(this);
		addMouseListener(this);
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
	
	/**
	 * Sets up UI Feel
	 */
	private void setupLookAndFeel() {
		setFont(new Font("Arial", Font.PLAIN, 40));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorder(BorderFactory.createEmptyBorder());
		setForeground(Colors.unselected());
	}
	
}
