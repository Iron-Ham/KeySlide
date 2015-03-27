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
	public InstructionStatus down(Instruction instruction) throws UnsupportedStatusTransitionException {
		throw new UnsupportedStatusTransitionException("down");
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
