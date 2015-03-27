package models;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Logger.*;

import contracts.InstructionStatus;


public class Instruction {
	private InstructionStatus status;
	private int id;
	private int expectedKey;
	private static final Logger logger = Logger.getLogger(Instruction.class.getName());
	
	
	public void setStatus(InstructionStatus status) {
		logger.entering(getClass().getName(), "setStatus");
		if (status != null && status != this.status) {
			logger.log(Level.FINER, "Instruction#" + id + ": cahnging status from " + this.status + " to " + status);
			this.status = status;
		}
		logger.exiting(getClass().getName(), "setStatus");
	}
}
