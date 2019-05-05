package br.ufsc.vsschweitzer.thesis.messaging.message;

public abstract class MessageBase {
	
	MessageType type;
	
	public MessageBase(MessageType type) {
		this.type = type;
	}

	public MessageType getType() {
		return type;
	}
	
	public void setType(MessageType type) {
		this.type = type;
	}
	
}
