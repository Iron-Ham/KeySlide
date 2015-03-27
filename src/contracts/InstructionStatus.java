package contracts;

import models.Instruction;
import java.util.logging.*;
import models.DownISO;
import models.LeftISO;
import models.RightISO;
import models.UpISO;
import models.ReverseISO;
import models.StopISO;

public enum InstructionStatus implements InstructionStatusOperations {
	LEFT(new LeftISO()),
	RIGHT(new RightISO()),
	UP(new UpISO()),
	DOWN(new DownISO()),
	REVERSE(new ReverseISO()),
	STOP(new StopISO());
	
	private static Logger logger =  Logger.getLogger(InstructionStatus.class.getName());
	

	private final InstructionStatusOperations operations;
	 InstructionStatus(InstructionStatusOperations operations) {
	  this.operations = operations;
	 }


	public InstructionStatus left(Instruction instruction) {
		logger.entering(getClass().getName(), "success");
		return operations.left(instruction);
	}

	@Override
	public InstructionStatus right(Instruction instruction) {
		logger.entering(getClass().getName(), "success");
		return operations.right(instruction);
	}

	@Override
	public InstructionStatus up(Instruction instruction) {
		logger.entering(getClass().getName(), "success");
		return operations.up(instruction);
	}

	@Override
	public InstructionStatus down(Instruction instruction) {
		logger.entering(getClass().getName(), "success");
		return operations.down(instruction);
	}

	@Override
	public InstructionStatus reverse(Instruction instruction) {
		logger.entering(getClass().getName(), "success");
		return operations.reverse(instruction);
	}

	@Override
	public InstructionStatus stop(Instruction instruction) {
		logger.entering(getClass().getName(), "success");
		return operations.stop(instruction);
	}
}
