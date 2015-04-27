package instruction;

/**
 * Concrete implementation of InstructionStatusOperations. This state is "STOP".
 * Created by heshamsalman on 4/26/15.
 */
public class StopISO implements InstructionStatusOperations {

    @Override
    public InstructionStatus stop(Instruction instruction) throws UnsupportedStatusTransitionException {
        throw new UnsupportedStatusTransitionException("stop");
    }
}
