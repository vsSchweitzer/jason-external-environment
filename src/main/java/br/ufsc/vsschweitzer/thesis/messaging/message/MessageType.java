package br.ufsc.vsschweitzer.thesis.messaging.message;

public enum MessageType {
	ACT(ActMessage.class),
	ACT_RESPONSE(ActResponseMessage.class);
	
	Class<? extends MessageBase> respectiveClass;
	
	MessageType(Class<? extends MessageBase> respectiveClass) {
		this.respectiveClass = respectiveClass;
	}
	
	public Class<? extends MessageBase> getRespectiveClass() {
		return respectiveClass;
	}
	
}
