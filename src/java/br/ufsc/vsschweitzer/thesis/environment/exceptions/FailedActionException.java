package br.ufsc.vsschweitzer.thesis.environment.exceptions;

public class FailedActionException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public FailedActionException() {
    }

    public FailedActionException(String message) {
        super(message);
    }

    public FailedActionException(Throwable cause) {
        super(cause);
    }

    public FailedActionException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
