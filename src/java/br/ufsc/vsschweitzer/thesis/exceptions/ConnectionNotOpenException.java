package br.ufsc.vsschweitzer.thesis.exceptions;

public class ConnectionNotOpenException extends Exception {

	private static final long serialVersionUID = 1L;
	
	static final String MESSAGE = "Cannot send a message without starting the connection first";

	public ConnectionNotOpenException() {
		super(MESSAGE);
	}

}
