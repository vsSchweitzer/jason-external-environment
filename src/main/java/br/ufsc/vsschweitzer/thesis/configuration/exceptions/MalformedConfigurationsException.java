package br.ufsc.vsschweitzer.thesis.configuration.exceptions;

public class MalformedConfigurationsException extends Exception {
	
	public enum ErrorField {
		IpAddress,
		Port,
		Other
	}
	
	ErrorField erroField = ErrorField.Other;

    public MalformedConfigurationsException(ErrorField errorField) {
        super();
        setField(errorField);
    }

    public MalformedConfigurationsException(String message, ErrorField errorField) {
        super(message);
        setField(errorField);
    }

    public MalformedConfigurationsException(Throwable cause, ErrorField errorField) {
        super(cause);
        setField(errorField);
    }

    public MalformedConfigurationsException(String message, Throwable cause, ErrorField errorField) {
        super(message, cause);
        setField(errorField);
    }

	public ErrorField getField() {
		return erroField;
	}

	private void setField(ErrorField field) {
		this.erroField = field;
	}
    
}
