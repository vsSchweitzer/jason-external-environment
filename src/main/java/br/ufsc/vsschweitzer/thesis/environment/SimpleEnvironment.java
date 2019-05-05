package br.ufsc.vsschweitzer.thesis.environment;

import jason.asSyntax.*;
import jason.environment.*;

import java.util.List;
import java.util.logging.*;

import br.ufsc.vsschweitzer.thesis.environment.exceptions.FailedActionException;

public class SimpleEnvironment extends Environment {

	private Logger logger = Logger.getLogger("tcpagent.mas2j." + SimpleEnvironment.class.getName());

	ExternalEnvironment extEnvironment;

	/** Called before the MAS execution with the args informed in .mas2j */
	@Override
	public void init(String[] args) {
		extEnvironment = ExternalEnvironment.getInstance();
	}

	@Override
	public boolean executeAction(String agName, Structure action) {
		logger.info(agName + " executing: " + action);
		try {
			List<Structure> percepts = extEnvironment.act(agName, action);
			for (Structure percept: percepts) {
				addPercept(agName, percept);
			}
			logger.info("[SUCCESS] " + agName + " executed " + action);
			return true;
		} catch (FailedActionException e) {
			logger.info(" [FAILED] " + agName + " failed to execute " + action);
			return false;
		}
	}

	/** Called before the end of MAS execution */
	@Override
	public void stop() {
		super.stop();
	}
}
