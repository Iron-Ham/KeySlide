package views;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.*;
import contracts.InstructionStatus;
import controllers.InstructionController;

public class DirectionPanel extends JPanel {
	InstructionController instrControl = InstructionController.getInstance();
	private JLabel image;
	private int internalKey;
	
	
	public DirectionPanel() {
		resolveInstructions();
		add(image);
	}
	
	public int getInternalKey() {
		return internalKey;
	}
	
	
	public void updateDirection() {
		instrControl.nextInstruction();
		resolveInstructions();
		updateUI();
	}
	
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
	}
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
	
	
}
