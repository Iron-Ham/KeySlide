package views.game;

import instruction.InstructionController;
import instruction.InstructionStatus;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utilities.Colors;

/**
 * DirectionPanel is the panel that has the direction image.
 * @author heshamsalman
 *
 */
public abstract class DirectionPanel extends JPanel {
	private static final long serialVersionUID = -2473781340553160448L;
	InstructionController instrControl = InstructionController.getInstance();
	private JLabel symbol;
	private int internalKey;
	protected Color[] colors = new Color[5];
	
	/**
	 * Constructor.
	 */
	public DirectionPanel() {
		setLayout(new BorderLayout());
		resolveInstructions();
		setColors();
	}
	
	/**
	 * Sets background color of the panel and of the symbol.
	 */
	private void setColors() {
		colors = Colors.getRandomColorFamily();
		setBackground(colors[2]);
		symbol.setForeground(colors[0]);	
	}
	
	/**
	 * @return internalKey, the KeyEvent code required of it per panel type
	 */
	public int getInternalKey() {
		return internalKey;
	}
	
	/**
	 * @return instrControl is the controller for the instruction.
	 */
	public InstructionController getInstructionController() {
		return instrControl;
	}
	
	/**
	 * @return returns instructionstatus type
	 */
	public InstructionStatus getStatus() {
		return instrControl.getStatus();
	}

	/**
	 * Constructor helper, also helps with updating panel
	 */
	private void resolveInstructions() {
		InstructionStatus status = instrControl.getStatus();
		if (status == InstructionStatus.LEFT)  {
			internalKey = KeyEvent.VK_LEFT;
			symbol = new LeftLabel();
		}
		else if (status == InstructionStatus.RIGHT) {
			internalKey = KeyEvent.VK_RIGHT;
			symbol = new RightLabel();
		}
		else if (status == InstructionStatus.UP) {
			internalKey = KeyEvent.VK_UP;
			symbol = new UpLabel();
			symbol.setVerticalAlignment(JLabel.CENTER);

		} else {
			internalKey = KeyEvent.VK_DOWN;
			symbol = new DownLabel();
			symbol.setVerticalAlignment(JLabel.CENTER);
		}
		symbol.setHorizontalAlignment(JLabel.CENTER);
		removeAll();
		add(symbol, BorderLayout.CENTER);
	}
}
