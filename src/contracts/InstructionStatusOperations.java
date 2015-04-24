package contracts;

import misc.UnsupportedStatusTransitionException;
import models.Instruction;

/**
 * The currently defined InstructionStatus states. As we add more "rules", we should add more states. 
 * TODO: Add compound states. 
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
	

}
