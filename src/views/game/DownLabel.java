package views.game;

import java.awt.Font;
import javax.swing.JLabel;

public class DownLabel extends JLabel {
	private static final long serialVersionUID = 1L;

	public DownLabel() {
		super();
		setText(">");
		setFont(new Font("Arial", Font.PLAIN, 512));
		setUI(new VerticalLabelUI(true));
	}
}
