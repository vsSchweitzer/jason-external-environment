package br.ufsc.vsschweitzer.thesis.messaging.message;

import java.util.Map;

public class ActMessage {
	
	MessageType type;
	String agent;
	String action;
	Map<String, Object> params;
	
	public ActMessage(MessageType type, String agent, String action) {
		this.type = type;
		this.agent = agent;
		this.action = action;
	}

	public MessageType getType() {
		return type;
	}
	
	public String getAgent() {
		return agent;
	}
	
	public String getAction() {
		return action;
	}
	
}
