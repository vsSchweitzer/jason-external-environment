package br.ufsc.vsschweitzer.thesis.messaging.message;

import java.util.List;
import java.util.Map;

public class ActResponseMessage extends MessageBase {

	ActResponseStatus status;
	Map<String, List<String>> percepts;
	
	public ActResponseMessage(ActResponseStatus status, Map<String, List<String>> percepts) {
		super(MessageType.ACT_RESPONSE);
		setStatus(status);
		setPercepts(percepts);
	}

	public ActResponseStatus getStatus() {
		return status;
	}

	private void setStatus(ActResponseStatus status) {
		this.status = status;
	}

	public Map<String, List<String>> getPercepts() {
		return percepts;
	}

	private void setPercepts(Map<String, List<String>> percepts) {
		this.percepts = percepts;
	}
	
}
