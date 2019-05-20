package br.ufsc.vsschweitzer.thesis.messaging.message;

import java.util.List;

public class ActResponseMessage extends BaseMessage {

	ActResponseStatus status;
	List<Percept> percepts;
	
	public ActResponseMessage() {
		super(MessageType.ACT_RESPONSE);
	}
	
	public ActResponseMessage(ActResponseStatus status, List<Percept> percepts) {
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

	public List<Percept> getPercepts() {
		return percepts;
	}

	private void setPercepts(List<Percept> percepts) {
		this.percepts = percepts;
	}
	
}
