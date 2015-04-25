package views.game;

import java.awt.Font;

import javax.swing.JLabel;
/**
 * Label for right direction
 * @author heshamsalman
 *
 */
public class RightLabel extends JLabel{
	private static final long serialVersionUID = 1L;

	public RightLabel() {
		super();
		setText(">");
		setFont(new Font("Arial", Font.PLAIN, 512));
	}
}
