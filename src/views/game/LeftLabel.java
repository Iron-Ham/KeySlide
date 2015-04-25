package views.game;

import java.awt.Font;

import javax.swing.JLabel;
/**
 * Label for left direction
 * @author heshamsalman
 *
 */
public class LeftLabel extends JLabel {
	private static final long serialVersionUID = -1759791089118720507L;

	public LeftLabel() {
		super();
		setFont(new Font("Arial", Font.PLAIN, 512));
		setText("<");
	}
}
