package br.ufsc.vsschweitzer.thesis.tests;

import java.util.List;

import br.ufsc.vsschweitzer.thesis.environment.ExternalEnvironment;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;

public class CommucationTest {

	static String ip = "127.0.0.1";
	static int port = 10000;

	static String testAgentName = "Ag1";

	public static void main(String args[]) throws Exception {

		ExternalEnvironment env = ExternalEnvironment.getInstance();

		Structure action = new Structure("VoidPublic");
		List<Structure> percepts = env.act(testAgentName, action);
		printReceivedMessage(percepts);
	}

	public static void printReceivedMessage(List<Structure> percepts) {
		System.out.println("Percepts:");
		for (Structure percept : percepts) {
			String toPrint = "    " + percept.getFunctor() + ": [";
			for (Term term : percept.getTerms()) {
				toPrint += term + ",";
			}
			toPrint = toPrint.substring(-1);
			toPrint += " ]";
		}
	}

}
