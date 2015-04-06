package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BackButton extends JButton implements ActionListener {
	Window window = Window.getInstance();

	public BackButton() {
		super("<");
		this.setFont(new Font("Arial", Font.PLAIN, 64));
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		window.setContentPane(new Menu());
	}
	
	
}
