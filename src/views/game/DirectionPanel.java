package views.game;

import instruction.InstructionController;
import instruction.InstructionStatus;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utilities.Colors;

/**
 * DirectionPanel is the abstract class. At base implementation, it is a SimpleDirectionPanel
 * @author heshamsalman
 *
 */
public abstract class DirectionPanel extends JPanel {
	private static final long serialVersionUID = -2473781340553160448L;
	InstructionController instrControl = InstructionController.getInstance();
	protected InstructionLabel symbol;
	protected int internalKey;
	protected Color[] colors = new Color[5];
	Random r = new Random();
	private enum label {
		LEFT,
		RIGHT,
		UP,
		DOWN
	}

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
	protected void setColors() {
		colors = Colors.getRandomColorFamily();
		setBackground(colors[2]);
		if (instrControl.getStatus() == InstructionStatus.STOP) 
			symbol.setForeground(Color.WHITE);
		else
			symbol.setForeground(colors[0]);	
	}
	
	/**
	 * @return internalKey, the KeyEvent code required of it per panel type
	 */
	public int getInternalKey() {
		return internalKey;
	}

	public Color[] getColors() {
		return colors;
	}

	/**
	 * Constructor helper, also helps with updating panel
	 */
	protected void resolveInstructions() {
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

		} else if (status == InstructionStatus.DOWN) {
			internalKey = KeyEvent.VK_DOWN;
			symbol = new DownLabel();
			symbol.setVerticalAlignment(JLabel.CENTER);
		} else if (status == InstructionStatus.STOP) {
			internalKey = -1;
			label l = label.values()[r.nextInt(label.values().length)];

			//Generates a Random Label for the stop instruction
			switch (l) {
				case UP:
					symbol = new UpLabel();
					symbol.setVerticalAlignment(JLabel.CENTER);
					break;
				case DOWN:
					symbol = new DownLabel();
					symbol.setVerticalAlignment(JLabel.CENTER);
					break;
				case LEFT:
					symbol = new LeftLabel();
					break;
				case RIGHT:
					symbol = new RightLabel();
					break;
				default:
					System.out.println("Unexpected value!?");
			}
		}
		symbol.setHorizontalAlignment(JLabel.CENTER);
		removeAll();
		add(symbol, BorderLayout.CENTER);
	}
}
