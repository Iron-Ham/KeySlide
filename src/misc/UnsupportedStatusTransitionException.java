package misc;

public class UnsupportedStatusTransitionException extends Exception{
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
