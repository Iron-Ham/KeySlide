package models;

import misc.UnsupportedStatusTransitionException;
import contracts.InstructionStatus;
import contracts.InstructionStatusOperations;

public class ReverseISO implements InstructionStatusOperations {

	@Override
	public InstructionStatus left(Instruction instruction) {
		return InstructionStatus.LEFT;
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
	public InstructionStatus reverse(Instruction instruction) throws UnsupportedStatusTransitionException {
		 throw new UnsupportedStatusTransitionException("reverse");
	}

	@Override
	public InstructionStatus stop(Instruction instruction) {
		 return InstructionStatus.STOP;
	}

}
