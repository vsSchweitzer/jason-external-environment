package br.ufsc.vsschweitzer.thesis.messaging;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.vsschweitzer.thesis.messaging.message.ActMessage;
import br.ufsc.vsschweitzer.thesis.messaging.message.MessageBase;
import br.ufsc.vsschweitzer.thesis.messaging.message.MessageType;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;

public class AgentMessageInterpreter {

	public static ActMessage wrapAct(String agent, Structure action) {
		List<String> passedParameters = new ArrayList<String>();
		for (Term term : action.getTerms()) {
			passedParameters.add(term.toString());
		}
		ActMessage actMessage = new ActMessage(agent, action.getFunctor(), passedParameters);

		return actMessage;
	}

	public static String messageToJson(MessageBase message) {
		// TODO JSON implement message conversion to JSON
		switch (message.getType()) {
		case ACT:

			break;
		case ACT_RESPONSE:

			break;
		default:
		}
		return "";
	}

	public static MessageBase interpretJsonMessage(String response) {
		// TODO JSON Parse as json object
		MessageType type = null; // get type from json object
		switch (type) {
		case ACT:
			return null;
		case ACT_RESPONSE:
			return null;
		default:
			// TODO throw exception instead
			return null;
		}
	}

}
