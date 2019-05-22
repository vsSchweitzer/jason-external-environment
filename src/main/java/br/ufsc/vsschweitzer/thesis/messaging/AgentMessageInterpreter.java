package br.ufsc.vsschweitzer.thesis.messaging;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.ufsc.vsschweitzer.thesis.messaging.messages.ActMessage;
import br.ufsc.vsschweitzer.thesis.messaging.messages.BaseMessage;
import br.ufsc.vsschweitzer.thesis.messaging.messages.enums.MessageType;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;

public class AgentMessageInterpreter {

	private static final String TYPE_FIELD = "type";

	static ObjectMapper objectMapper = new ObjectMapper();

	public static String messageToJson(BaseMessage message) throws IOException {
		return objectMapper.writeValueAsString(message);
	}

	public static BaseMessage interpretJsonMessage(String message) throws IOException {
		ObjectNode genericNode = objectMapper.readValue(message, ObjectNode.class);
		MessageType type = MessageType.valueOf(genericNode.get(TYPE_FIELD).asText());

		return objectMapper.convertValue(genericNode, type.getRespectiveClass());
	}

	public static ActMessage wrapAct(String agent, Structure action) {
		List<String> passedParameters = new ArrayList<String>();
		if (action.getTerms() != null) {
			for (Term term : action.getTerms()) {
				passedParameters.add(term.toString());
			}
		}
		ActMessage actMessage = new ActMessage(agent, action.getFunctor(), passedParameters);

		return actMessage;
	}

}
