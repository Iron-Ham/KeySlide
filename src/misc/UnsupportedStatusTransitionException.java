package misc;

/**
 * An exception to be thrown by InstructionStatus or Instruction. This Exception is called whenever an illegal 
 * status transition occurs.
 * @author heshamsalman
 *
 */
public class UnsupportedStatusTransitionException extends Exception{
	private static final long serialVersionUID = -1671801597417239034L;
	
	public UnsupportedStatusTransitionException() {
		super();
	}
	public UnsupportedStatusTransitionException(String message) {
		super(message);
	}
	public UnsupportedStatusTransitionException(Throwable cause) {
		super(cause);
	}
	public UnsupportedStatusTransitionException(String message, Throwable cause) { 
		super(message, cause);
	}

}
