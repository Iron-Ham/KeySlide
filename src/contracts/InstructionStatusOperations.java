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
	InstructionStatus left(Instruction instruction) throws UnsupportedStatusTransitionException;
	InstructionStatus right(Instruction instruction) throws UnsupportedStatusTransitionException;
	InstructionStatus up(Instruction instruction) throws UnsupportedStatusTransitionException;
	InstructionStatus down(Instruction instruction) throws UnsupportedStatusTransitionException;
	InstructionStatus stop(Instruction instruction) throws UnsupportedStatusTransitionException;
}
