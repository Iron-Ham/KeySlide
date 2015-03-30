package controllers;

import java.util.Random;
import java.util.logging.Logger;

import contracts.InstructionStatus;
import misc.UnsupportedStatusTransitionException;
import models.Instruction;

/**
 * Handles generating the next instruction. 
 * @author heshamsalman
 *
 */
public class InstructionController {
	private static Instruction instr;
	private static final InstructionController instance = new InstructionController();
	boolean reverse = false;
	private static Logger logger =  Logger.getLogger(InstructionStatus.class.getName());
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
		return reverse;
	}
	
	public void nextInstruction() {
		logger.entering(getClass().getName(), "nextInstruction");
		InstructionStatus p = InstructionStatus.getRandomStatus();
		if (p != instr.getStatus()) {
			instr.setStatus(p);
			reverse = r.nextBoolean();
		}
	}
}
