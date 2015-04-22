package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import utilities.Colors;

/**
 * Back Button allows user to go back to home page when clicked. 
 * @author heshamsalman
 *
 */
public class BackButton extends JButton implements ActionListener {
	Window window;

	public BackButton(Window window) {
		super("<");
		this.window = window;
		this.setFont(new Font("Arial", Font.PLAIN, 64));
		this.addActionListener(this);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setForeground(Colors.selected());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		window.switchToHome();
	}
	
	
}
