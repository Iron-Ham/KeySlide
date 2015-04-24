package models;

import misc.UnsupportedStatusTransitionException;
import contracts.InstructionStatus;
import contracts.InstructionStatusOperations;
/**
 * The concrete implementation of InstructionStatusOperation. This state is "LEFT"
 * @author heshamsalman
 *
 */
public class LeftISO implements InstructionStatusOperations {

	@Override
	public InstructionStatus left(Instruction instruction) throws UnsupportedStatusTransitionException {
		throw new UnsupportedStatusTransitionException("left");
	}
}
