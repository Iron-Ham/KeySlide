package views;

import javax.swing.JPanel;
import models.*;
import controllers.InstructionController;

public class DirectionPanel extends JPanel {
	InstructionController instrControl = InstructionController.getInstance();
	
	public DirectionPanel() {
		System.out.println(instrControl.getInstr() + "\t" + instrControl.getStatus());
	}
}
