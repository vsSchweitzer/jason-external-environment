package br.ufsc.vsschweitzer.thesis.messaging.messages;

import java.util.List;

import br.ufsc.vsschweitzer.thesis.messaging.messages.enums.MessageType;

public class ActMessage extends BaseMessage {

	String agent;
	String action;
	List<String> parameters;
	
	public ActMessage() {
		super(MessageType.ACT);
	}

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
