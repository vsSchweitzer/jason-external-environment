package br.ufsc.vsschweitzer.thesis.environment;

public class ExternalEnvironment {

	private static final ExternalEnvironment instance = new ExternalEnvironment();

	private ExternalEnvironment() {
		
	}

	public static ExternalEnvironment getInstance() {
		return instance;
	}

}
