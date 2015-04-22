package views;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.*;
import contracts.InstructionStatus;
import controllers.InstructionController;

/**
 * DirectionPanel is the panel that has the direction image.
 * @author heshamsalman
 *
 */
public class DirectionPanel extends JPanel {
	InstructionController instrControl = InstructionController.getInstance();
	private JLabel image;
	private int internalKey;
	
	/**
	 * Constructor.
	 */
	public DirectionPanel() {
		resolveInstructions();
		add(image);
	}
	
	/**
	 * @return internalKey, the KeyEvent code required of it per panel type
	 */
	public int getInternalKey() {
		return internalKey;
	}
	
	/**
	 * @return returns instructionstatus type
	 */
	public InstructionStatus getStatus() {
		return instrControl.getStatus();
	}
	
	/**
	 * Switches to the next instruction and updates this panel.
	 */
	public void updateDirection() {
		instrControl.nextInstruction();
		resolveInstructions();
		updateUI();
	}

	/**
	 * Constructor helper, also helps with updating panel
	 */
	private void resolveInstructions() {
		InstructionStatus status = instrControl.getStatus();
		if (status == InstructionStatus.LEFT)  {
			internalKey = KeyEvent.VK_LEFT;
			ImageIcon icon;
			if (instrControl.isReversed()) {
				icon = new ImageIcon("images/8.png");
			} else {
				icon = new ImageIcon("images/4.png");
			}
			image = new JLabel(icon);
		}
		else if (status == InstructionStatus.RIGHT) {
			internalKey = KeyEvent.VK_RIGHT;
			ImageIcon icon;
			if (instrControl.isReversed()) {
				icon = new ImageIcon("images/7.png");
			} else {
				icon = new ImageIcon("images/3.png");
			}
			image = new JLabel(icon);
		}
		else if (status == InstructionStatus.UP) {
			internalKey = KeyEvent.VK_UP;
			ImageIcon icon;
			if (instrControl.isReversed()) {
				icon = new ImageIcon("images/5.png");
			} else {
				icon = new ImageIcon("images/1.png");
			}
			image = new JLabel(icon);
		} else {
			internalKey = KeyEvent.VK_DOWN;
			ImageIcon icon;
			if (instrControl.isReversed()) {
				icon = new ImageIcon("images/6.png");
			} else {
				icon = new ImageIcon("images/2.png");
			}
			image = new JLabel(icon);
		}
		removeAll();
		add(image);
	}
	
	
}
