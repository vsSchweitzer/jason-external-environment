package br.ufsc.vsschweitzer.thesis.messaging.messages.enums;

import br.ufsc.vsschweitzer.thesis.messaging.messages.ActMessage;
import br.ufsc.vsschweitzer.thesis.messaging.messages.ActResponseMessage;
import br.ufsc.vsschweitzer.thesis.messaging.messages.BaseMessage;

public enum MessageType {
	ACT(ActMessage.class),
	ACT_RESPONSE(ActResponseMessage.class);
	
	Class<? extends BaseMessage> respectiveClass;
	
	MessageType(Class<? extends BaseMessage> respectiveClass) {
		this.respectiveClass = respectiveClass;
	}
	
	public Class<? extends BaseMessage> getRespectiveClass() {
		return respectiveClass;
	}
	
}
