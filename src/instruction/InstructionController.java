package instruction;

import utilities.GameLog;

import java.util.Random;

/**
 * A developer-friendly wrapper of an instruction.
 * Allows generation of the next instruction state, provides access to the instruction instance,
 * gets the status of the current instruction, and can define a "reversed" state to allow for
 * reverse input images.
 * <p>
 *
 * @author heshamsalman
 */
public class InstructionController {
    private static final InstructionController instance = new InstructionController();
    private static Instruction instr;
    boolean reverse = false;
    Random r = new Random();

    /**
     * Constructor. Set to private because this is a singleton.
     */
    private InstructionController() {
        InstructionStatus p = InstructionStatus.getRandomStatus();
        instr = new Instruction(p);
    }

    /**
     * This method returns the single instance of this class.
     * @return instance: The only instance of InstructionController
     */
    public static synchronized InstructionController getInstance() {
        return instance;
    }

    /**
     * Getter method for status.
     * @return status the status of the instruction
     */
    public InstructionStatus getStatus() {
        return instr.getStatus();
    }

    /**
     * Convenience method. Generates a random reversal status.
     * @return reverse
     */
    public boolean isReversed() {
        reverse = r.nextBoolean();
        return reverse;
    }

    /**
     * Generates next instruction by switching the instruction state.
     */
    public void nextInstruction() {
        GameLog.log.entering(getClass().getName(), "nextInstruction");
        InstructionStatus p = InstructionStatus.getRandomStatus();
        instr.setStatus(p);
        reverse = r.nextBoolean();
        GameLog.log.exiting(getClass().getName(), "nextInstruction");
    }
}
