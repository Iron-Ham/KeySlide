package views.game;

import java.awt.Font;

import javax.swing.JLabel;

public class LeftLabel extends JLabel {

	public LeftLabel() {
		super();
		setFont(new Font("Arial", Font.PLAIN, 512));
		setText("<");
	}
}
