package instruction;


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
