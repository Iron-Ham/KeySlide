package views.game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class DownLabel extends JLabel {

	public DownLabel() {
		super();
		setText(">");
		setFont(new Font("Arial", Font.PLAIN, 512));
		setUI(new VerticalLabelUI(true));
	}
}
