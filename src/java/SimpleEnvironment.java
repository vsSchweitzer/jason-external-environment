import jason.asSyntax.*;
import jason.environment.*;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.logging.*;
import br.ufsc.vsschweitzer.thesis.configuration.exceptions.MalformedConfigurationsException;
import br.ufsc.vsschweitzer.thesis.environment.ExternalEnvironment;
import br.ufsc.vsschweitzer.thesis.environment.exceptions.FailedActionException;
import br.ufsc.vsschweitzer.thesis.messaging.messages.Percept;

public class SimpleEnvironment extends Environment {

	private Logger logger = Logger.getLogger("tcpagent.mas2j." + SimpleEnvironment.class.getName());

	ExternalEnvironment extEnvironment;

	/** Called before the MAS execution with the args informed in .mas2j */
	/* The first arg is the ipAddress of the environment server
	 * The second arg is the port of the environment server
	 * The third arg is the number of threads to execute the agents.
	 *		It is recommended that there is a thread for every agent.
	 *		* Note: This value is limited to 1000 by JASON itself.
	 * 
	 */
	@Override
	public void init(String[] args) {
		try {
			extEnvironment = new ExternalEnvironment(args[0], args[1]);
		    executor = Executors.newFixedThreadPool(Integer.parseInt(args[2]));
		} catch (MalformedConfigurationsException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean executeAction(String agName, Structure action) {		
		logger.info("Agent " + agName + " executing: " + action);
		try {
			List<Percept> percepts = extEnvironment.act(agName, action);
			updatePercepts(agName, percepts);
			logger.info("[SUCCESS] " + agName + " executed " + action);
			return true;
		} catch (FailedActionException e) {
			logger.info(" [FAILED] " + agName + " failed to execute " + action);
			return false;
		}
	}
	
	private void updatePercepts(String agName, List<Percept> percepts) {
		for (Percept percept: percepts) {
			switch (percept.getAction()) {
				case ADD:
					addPercept(agName, percept.asLiteral());
					break;
				case REMOVE:
					removePerceptsByUnif(agName, percept.asLiteral());
					break;
			}
		}
	}

	/** Called before the end of MAS execution */
	@Override
	public void stop() {
		super.stop();
	}
}
