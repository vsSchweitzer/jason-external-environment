package br.ufsc.vsschweitzer.thesis.messaging.message;

import java.util.List;

public class ActMessage extends MessageBase {
	
	String agent;
	String action;
	List<String> parameters;
	
	public ActMessage(String agent, String action, List<String> parameters) {
		super(MessageType.ACT);
		this.agent = agent;
		this.action = action;
		this.parameters = parameters;
	}
	
	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
	
}
