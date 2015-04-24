package models;

import misc.UnsupportedStatusTransitionException;
import contracts.InstructionStatus;
import contracts.InstructionStatusOperations;

/**
 * The concrete implementation of InstructionStatusOperation. This state is "RIGHT"
 * @author heshamsalman
 *
 */
public class RightISO implements InstructionStatusOperations {

	@Override
	public InstructionStatus right(Instruction instruction) throws UnsupportedStatusTransitionException{
		throw new UnsupportedStatusTransitionException("right");
	}
}
