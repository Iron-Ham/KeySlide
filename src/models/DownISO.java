package models;

import misc.UnsupportedStatusTransitionException;
import contracts.InstructionStatus;
import contracts.InstructionStatusOperations;

/**
 * The concrete implementation of InstructionStatusOperation. This state is "DOWN"
 * @author heshamsalman
 *
 */
public class DownISO implements InstructionStatusOperations {
	
	@Override
	public InstructionStatus down(Instruction instruction) throws UnsupportedStatusTransitionException {
		throw new UnsupportedStatusTransitionException("down");
	}
}
