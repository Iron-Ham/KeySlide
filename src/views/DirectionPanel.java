package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.*;
import contracts.InstructionStatus;
import controllers.InstructionController;

public class DirectionPanel extends JPanel {
	InstructionController instrControl = InstructionController.getInstance();
	private JLabel image;
	
	
	public DirectionPanel() {
		resolveInstructions();
		add(image);
	}
	
	public void updateDirection() {
		instrControl.nextInstruction();
		resolveInstructions();
		updateUI();
	}
	
	private void resolveInstructions() {
		InstructionStatus status = instrControl.getStatus();
		if (status == status.values()[0])  {
			//left
			System.out.println("left");
			ImageIcon icon;
			if (instrControl.isReversed()) {
				icon = new ImageIcon("images/8.png");
			} else {
				icon = new ImageIcon("images/4.png");
			}
			image = new JLabel(icon);
		}
		else if (status == status.values()[1]) {
			//right
			System.out.println("right");
			ImageIcon icon;
			if (instrControl.isReversed()) {
				icon = new ImageIcon("images/7.png");
			} else {
				icon = new ImageIcon("images/3.png");
			}
			image = new JLabel(icon);
		}
		else if (status == status.values()[2]) {
			//up
			System.out.println("up");
			ImageIcon icon;
			if (instrControl.isReversed()) {
				icon = new ImageIcon("images/5.png");
			} else {
				icon = new ImageIcon("images/1.png");
			}
			image = new JLabel(icon);
		} else {
			//down
			System.out.println("down");
			ImageIcon icon;
			if (instrControl.isReversed()) {
				icon = new ImageIcon("images/6.png");
			} else {
				icon = new ImageIcon("images/2.png");
			}
			image = new JLabel(icon);
		}
		
	}
}
