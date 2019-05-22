package br.ufsc.vsschweitzer.thesis.messaging.messages;

import java.util.List;

import br.ufsc.vsschweitzer.thesis.messaging.messages.enums.ActResponseStatus;
import br.ufsc.vsschweitzer.thesis.messaging.messages.enums.MessageType;

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
