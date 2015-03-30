package handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import contracts.InstructionStatus;
import controllers.InstructionController;


/**
 * Handles key events from the user. This will be used to determine whether the user 
 * entered up, down, etc...,
 * TODO: Implement game over, implement other functions that must happen when the user enters the correct key!
 * @author heshamsalman
 *
 */
public class KeyHandler implements KeyListener {	
	InstructionController instructions = InstructionController.getInstance();
	private static Logger logger =  Logger.getLogger(InstructionStatus.class.getName());
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		logger.entering(getClass().getName(), "keyPressed");
		int key = e.getKeyCode();
		logger.log(Level.FINE, "Key Pressed: " + key);
		boolean reverse = instructions.isReversed();
		InstructionStatus status = instructions.getStatus();
		switch (status) {
		case LEFT:
			if (key == KeyEvent.VK_LEFT) {
				instructions.nextInstruction();
				//Animations, etc...
			}
			else {
				//GameOver
			}
			break;
		case DOWN:
			if (key == KeyEvent.VK_DOWN) {
				instructions.nextInstruction();

			}
			else {
				//Game Over
			}
			break;
		case RIGHT:
			if (key == KeyEvent.VK_RIGHT) {
				instructions.nextInstruction();

			}
			else {
				//Game Over
			}
			break;
		case UP:
			if (key == KeyEvent.VK_UP) {
				instructions.nextInstruction();

			}
			else {
				//Game Over
			}
			break;
		case STOP:
			//Game Over
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
