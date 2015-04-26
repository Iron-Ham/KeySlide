package instruction;


/**
 * The defined operations for an instruction status. This interface defines state transitions. 
 * Contains default implementations of state transitions. 
 * @author heshamsalman
 *
 */
public interface InstructionStatusOperations {
	
	default InstructionStatus left(Instruction instruction) throws UnsupportedStatusTransitionException {
		 return InstructionStatus.LEFT;
	}

	
	default InstructionStatus right(Instruction instruction) throws UnsupportedStatusTransitionException {
		 return InstructionStatus.RIGHT;
	}

	
	default InstructionStatus up(Instruction instruction) throws UnsupportedStatusTransitionException {
		 return InstructionStatus.UP;
	}

	
	default InstructionStatus down(Instruction instruction) throws UnsupportedStatusTransitionException {
		return InstructionStatus.DOWN;
	}

	default InstructionStatus stop(Instruction instruction) throws UnsupportedStatusTransitionException {
		return InstructionStatus.STOP;
	}
	

}
