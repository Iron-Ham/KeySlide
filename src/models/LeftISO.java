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

	@Override
	public InstructionStatus right(Instruction instruction) {
		 return InstructionStatus.RIGHT;
	}

	@Override
	public InstructionStatus up(Instruction instruction) {
		 return InstructionStatus.UP;
	}

	@Override
	public InstructionStatus down(Instruction instruction) {
		return InstructionStatus.DOWN;
	}

	@Override
	public InstructionStatus reverse(Instruction instruction) {
		 return InstructionStatus.REVERSE;
	}

	@Override
	public InstructionStatus stop(Instruction instruction) {
		 return InstructionStatus.STOP;
	}

}
