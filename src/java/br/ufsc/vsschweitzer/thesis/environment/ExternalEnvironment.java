package br.ufsc.vsschweitzer.thesis.environment;

import java.io.IOException;
import java.util.List;

import br.ufsc.vsschweitzer.thesis.configuration.ConfigurationReader;
import br.ufsc.vsschweitzer.thesis.configuration.EnvironmentConfiguration;
import br.ufsc.vsschweitzer.thesis.configuration.exceptions.MalformedConfigurationsException;
import br.ufsc.vsschweitzer.thesis.environment.exceptions.FailedActionException;
import br.ufsc.vsschweitzer.thesis.exceptions.ConnectionNotOpenException;
import br.ufsc.vsschweitzer.thesis.messaging.AgentMessageInterpreter;
import br.ufsc.vsschweitzer.thesis.messaging.Messenger;
import br.ufsc.vsschweitzer.thesis.messaging.messages.ActMessage;
import br.ufsc.vsschweitzer.thesis.messaging.messages.ActResponseMessage;
import br.ufsc.vsschweitzer.thesis.messaging.messages.Percept;
import jason.asSyntax.Structure;

public class ExternalEnvironment {
	
	private EnvironmentConfiguration configuration;
	
	public ExternalEnvironment(String ipAddress, String port) throws MalformedConfigurationsException {
		configuration = new EnvironmentConfiguration(ipAddress, port);
	}
	
	public List<Percept> act(String agent, Structure action) throws FailedActionException {
		Messenger messenger = new Messenger(configuration.getIpAddress(), configuration.getPort());
		try {
			ActMessage message = AgentMessageInterpreter.wrapAct(agent, action);
			String messageAsJson = AgentMessageInterpreter.messageToJson(message);
			
			messenger.open();
			messenger.send(messageAsJson);
			String response = messenger.listen();
			ActResponseMessage responseMsg = (ActResponseMessage) AgentMessageInterpreter.interpretJsonMessage(response);
			return responseMsg.getPercepts();
		} catch (IOException | ConnectionNotOpenException e) {
			throw new FailedActionException(e);
		} finally {
			messenger.close();
		}
	}
}
