package controllers;

import java.util.Random;
import java.util.logging.Logger;

import utilities.GameLog;
import contracts.InstructionStatus;
import models.Instruction;

/**
 * Handles generating the next instruction. Singleton.
 * 
 * @author heshamsalman
 *
 */
public class InstructionController {
	private static Instruction instr;
	private static final InstructionController instance = new InstructionController();
	boolean reverse = false;
	Random r = new Random();

	private InstructionController() {
		InstructionStatus p = InstructionStatus.getRandomStatus();
		instr = new Instruction(p);
	}

	public static synchronized InstructionController getInstance() {
		return instance;
	}

	public Instruction getInstr() {
		return instr;
	}

	public InstructionStatus getStatus() {
		return instr.getStatus();
	}

	public boolean isReversed() {
		reverse = r.nextBoolean();
		return reverse;
	}

	public void nextInstruction() {
		GameLog.log.entering(getClass().getName(), "nextInstruction");
		InstructionStatus p = InstructionStatus.getRandomStatus();
		while (p == instr.getStatus()) {
			p = InstructionStatus.getRandomStatus();
		}
		instr.setStatus(p);
		reverse = r.nextBoolean();
		GameLog.log.exiting(getClass().getName(), "nextInstruction");
	}
}
