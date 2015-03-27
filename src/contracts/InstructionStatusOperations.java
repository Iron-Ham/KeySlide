package contracts;

import misc.UnsupportedStatusTransitionException;
import models.Instruction;

public interface InstructionStatusOperations {
	InstructionStatus left(Instruction instruction) throws UnsupportedStatusTransitionException;
	InstructionStatus right(Instruction instruction) throws UnsupportedStatusTransitionException;
	InstructionStatus up(Instruction instruction) throws UnsupportedStatusTransitionException;
	InstructionStatus down(Instruction instruction) throws UnsupportedStatusTransitionException;
	InstructionStatus reverse(Instruction instruction) throws UnsupportedStatusTransitionException;
	InstructionStatus stop(Instruction instruction) throws UnsupportedStatusTransitionException;
}
