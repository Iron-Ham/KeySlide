package contracts;

import misc.UnsupportedStatusTransitionException;
import java.util.Random;
import utilities.GameLog;
import models.Instruction;
import models.DownISO;
import models.LeftISO;
import models.RightISO;
import models.UpISO;

/**
 * This class is an enumerable interface for the InstructionStatus. This is a really cool design pattern that is a modified version 
 * of the GOF version. The reason why it's different is because it takes advantage of the special behaviors of enumerables in Java.
 * This version treats the enumerable as an "abstract class" with built-in state recognition. 
 * 
 * The InstructionStatus is the "state" of the Instruction. It also allows some business-logic methods to allow switching of states. 
 * @author heshamsalman
 *
 */
public enum InstructionStatus implements InstructionStatusOperations {
	/**
	 * States that the Instruction Status can have. On state switch, returns a class which implements the concrete state. 
	 */
	LEFT(new LeftISO()),
	RIGHT(new RightISO()),
	UP(new UpISO()),
	DOWN(new DownISO());	
	
	/**
	 * getRandomStatus generates a random status and sets the object to it.
	 * @return Returns a random state from values()
	 */
	public static InstructionStatus getRandomStatus() {
		Random r = new Random();
		return values()[r.nextInt(values().length)];
	}

	/**
	 * The "state" variable. It is an implementation of the InstructionStatusOperations interface. This interface defines the shared 
	 * code between the states.
	 */
	private final InstructionStatusOperations operations;
	InstructionStatus(InstructionStatusOperations operations) {
	  this.operations = operations;
	 }


	public InstructionStatus left(Instruction instruction) throws UnsupportedStatusTransitionException {
		GameLog.log.entering(getClass().getName(), "left");
		return operations.left(instruction);
	}

	@Override
	public InstructionStatus right(Instruction instruction) throws UnsupportedStatusTransitionException {
		GameLog.log.entering(getClass().getName(), "right");
		return operations.right(instruction);
	}

	@Override
	public InstructionStatus up(Instruction instruction) throws UnsupportedStatusTransitionException {
		GameLog.log.entering(getClass().getName(), "up");
		return operations.up(instruction);
	}

	@Override
	public InstructionStatus down(Instruction instruction) throws UnsupportedStatusTransitionException {
		GameLog.log.entering(getClass().getName(), "down");
		return operations.down(instruction);
	}
}
