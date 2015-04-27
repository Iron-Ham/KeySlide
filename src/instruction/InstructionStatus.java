package instruction;

import java.util.Random;

/**
 * This class is an enumerable interface for the InstructionStatus. This is a really cool design pattern that is a modified version
 * of the GOF version. The reason why it's different is because it takes advantage of the special behaviors of enumerables in Java.
 * This version treats the enumerable as an "abstract class" with built-in state recognition.
 * <p>
 * The InstructionStatus is the "state" of the Instruction. It also allows some business-logic methods to allow switching of states.
 *
 * @author heshamsalman
 */
public enum InstructionStatus implements InstructionStatusOperations {
    /**
     * States that the Instruction Status can have. On state switch, returns a class which implements the concrete state.
     */
    LEFT(new LeftISO()),
    RIGHT(new RightISO()),
    UP(new UpISO()),
    DOWN(new DownISO()),
    STOP(new StopISO());

    /**
     * The "state" variable. It is an implementation of the InstructionStatusOperations interface. This interface defines the shared
     * code between the states.
     */
    @SuppressWarnings({"unused"})
    private final InstructionStatusOperations operations;


    InstructionStatus(InstructionStatusOperations operations) {
        this.operations = operations;
    }

    /**
     * getRandomStatus generates a random status and sets the object to it.
     *
     * @return Returns a random state from values()
     */
    public static InstructionStatus getRandomStatus() {
        Random r = new Random();
        return values()[r.nextInt(values().length)];
    }
}
