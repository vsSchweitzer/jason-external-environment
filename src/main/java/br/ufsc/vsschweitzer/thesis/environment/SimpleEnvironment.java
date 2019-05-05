package br.ufsc.vsschweitzer.thesis.environment;

import jason.asSyntax.*;
import jason.environment.*;
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
			extEnvironment.act(agName, action);
			// TODO add percepts based on act response
			return true;
		} catch (FailedActionException e) {
			return false;
		}
		
		/* TODO delete this in the future
		
		switch (action.getFunctor()) {
		case "burn":
			System.out.println("Queimou");
			addPercept(Literal.parseLiteral("fire"));
			return true;
		case "run":
			System.out.println("Correu");
			return true;
		default:
			logger.info("executing: " + action + ", but not implemented!");
			return false;
		}
		
		*/
	}

	/** Called before the end of MAS execution */
	@Override
	public void stop() {
		super.stop();
	}
}
