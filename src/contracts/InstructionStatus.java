package contracts;

import misc.UnsupportedStatusTransitionException;
import models.Instruction;

import java.util.Random;
import java.util.logging.*;

import models.DownISO;
import models.LeftISO;
import models.RightISO;
import models.UpISO;
import models.StopISO;

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
	LEFT(new LeftISO()),
	RIGHT(new RightISO()),
	UP(new UpISO()),
	DOWN(new DownISO()),
	STOP(new StopISO());
	
	private static Logger logger =  Logger.getLogger(InstructionStatus.class.getName());
	
	
	public static InstructionStatus getRandomStatus() {
		Random r = new Random();
		return values()[r.nextInt(values().length)];
	}
	
	
	private final InstructionStatusOperations operations;
	 InstructionStatus(InstructionStatusOperations operations) {
	  this.operations = operations;
	 }


	public InstructionStatus left(Instruction instruction) throws UnsupportedStatusTransitionException {
		logger.entering(getClass().getName(), "success");
		return operations.left(instruction);
	}

	@Override
	public InstructionStatus right(Instruction instruction) throws UnsupportedStatusTransitionException {
		logger.entering(getClass().getName(), "success");
		return operations.right(instruction);
	}

	@Override
	public InstructionStatus up(Instruction instruction) throws UnsupportedStatusTransitionException {
		logger.entering(getClass().getName(), "success");
		return operations.up(instruction);
	}

	@Override
	public InstructionStatus down(Instruction instruction) throws UnsupportedStatusTransitionException {
		logger.entering(getClass().getName(), "success");
		return operations.down(instruction);
	}

	@Override
	public InstructionStatus stop(Instruction instruction) throws UnsupportedStatusTransitionException {
		logger.entering(getClass().getName(), "success");
		return operations.stop(instruction);
	}
}
