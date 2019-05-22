package br.ufsc.vsschweitzer.thesis.environment;

import java.io.IOException;
import java.util.List;

import br.ufsc.vsschweitzer.thesis.configuration.ConfigurationReader;
import br.ufsc.vsschweitzer.thesis.configuration.EnvironmentConfiguration;
import br.ufsc.vsschweitzer.thesis.environment.exceptions.FailedActionException;
import br.ufsc.vsschweitzer.thesis.exceptions.ConnectionNotOpenException;
import br.ufsc.vsschweitzer.thesis.messaging.AgentMessageInterpreter;
import br.ufsc.vsschweitzer.thesis.messaging.Messenger;
import br.ufsc.vsschweitzer.thesis.messaging.messages.ActResponseMessage;
import br.ufsc.vsschweitzer.thesis.messaging.messages.enums.ActMessage;
import jason.asSyntax.Structure;

public class ExternalEnvironment {
	
	private ExternalEnvironment() {}
	
	private static ExternalEnvironment instance;
	
	private static EnvironmentConfiguration configuration;

	public static ExternalEnvironment getInstance() {
		if (instance == null) {
			initializeInstance();
		}
		return instance;
	}

	private static void initializeInstance() {
		instance = new ExternalEnvironment();
		configuration = ConfigurationReader.getConfiguration();
	}
	
	public List<Structure> act(String agent, Structure action) throws FailedActionException {
		Messenger messenger = new Messenger(configuration.getIpAddress(), configuration.getPort());
		try {
			ActMessage message = AgentMessageInterpreter.wrapAct(agent, action);
			String messageAsJson = AgentMessageInterpreter.messageToJson(message);
			
			messenger.open();
			messenger.send(messageAsJson);
			String response = messenger.listen();
			ActResponseMessage responseMsg = (ActResponseMessage) AgentMessageInterpreter.interpretJsonMessage(response);
			// TODO determinar o que fazer com o status da mensagem de resposta.
			return AgentMessageInterpreter.responsePerceptsToLiterals(responseMsg);
		} catch (IOException | ConnectionNotOpenException e) {
			throw new FailedActionException(e);
		} finally {
			messenger.close();
		}
	}
}
