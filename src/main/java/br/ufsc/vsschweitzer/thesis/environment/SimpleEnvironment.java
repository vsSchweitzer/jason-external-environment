package br.ufsc.vsschweitzer.thesis.environment;

import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;

public class SimpleEnvironment extends Environment {

	private Logger logger = Logger.getLogger("tcpagent.mas2j." + SimpleEnvironment.class.getName());

	/** Called before the MAS execution with the args informed in .mas2j */
	@Override
	public void init(String[] args) {
	}

	@Override
	public boolean executeAction(String agName, Structure action) {
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
	}

	/** Called before the end of MAS execution */
	@Override
	public void stop() {
		super.stop();
	}
}
