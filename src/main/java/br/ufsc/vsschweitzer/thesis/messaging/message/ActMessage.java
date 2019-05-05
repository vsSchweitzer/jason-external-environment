package br.ufsc.vsschweitzer.thesis.messaging.message;

import java.util.List;

public class ActMessage extends MessageBase {

	String agent;
	String action;
	List<String> parameters;

	public ActMessage(String agent, String action, List<String> parameters) {
		super(MessageType.ACT);
		setAgent(agent);
		setAction(action);
		setParameters(parameters);
	}

	public String getAgent() {
		return agent;
	}

	private void setAgent(String agent) {
		this.agent = agent;
	}

	public String getAction() {
		return action;
	}

	private void setAction(String action) {
		this.action = action;
	}

	public List<String> getParameters() {
		return parameters;
	}

	private void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}

}
