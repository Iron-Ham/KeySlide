package models;

import misc.UnsupportedStatusTransitionException;
import contracts.InstructionStatus;
import contracts.InstructionStatusOperations;

/**
 * The concrete implementation of InstructionStatusOperation. This state is "UP"
 * @author heshamsalman
 *
 */
public class UpISO implements InstructionStatusOperations {
	@Override
	public InstructionStatus up(Instruction instruction) throws UnsupportedStatusTransitionException {
		throw new UnsupportedStatusTransitionException("up");
	}
}
