package br.ufsc.vsschweitzer.thesis.environment;

import br.ufsc.vsschweitzer.thesis.messaging.AgentMessageInterpreter;

public class ExternalEnvironment {

	private static final ExternalEnvironment instance = new ExternalEnvironment();

	private ExternalEnvironment() {}

	public static ExternalEnvironment getInstance() {
		return instance;
	}
	
	public void act(String agent, String action) { // TODO add parameters param
		AgentMessageInterpreter.wrapAct(agent, action);
	}
}
