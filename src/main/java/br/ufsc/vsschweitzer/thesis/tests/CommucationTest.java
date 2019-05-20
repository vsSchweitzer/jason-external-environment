package br.ufsc.vsschweitzer.thesis.tests;

import java.util.List;

import br.ufsc.vsschweitzer.thesis.environment.ExternalEnvironment;
import jason.asSyntax.Structure;
import jason.asSyntax.Term;
import jason.asSyntax.VarTerm;

public class CommucationTest {

	static String ip = "127.0.0.1";
	static int port = 10000;

	static String testAgentName = "Ag1";

	public static void main(String args[]) throws Exception {

		ExternalEnvironment env = ExternalEnvironment.getInstance();

		Structure action = new Structure("VoidPublic");
		List<Structure> percepts = env.act(testAgentName, action);
		printReceivedMessage(percepts);
		
		action = new Structure("VoidPrivate");
		percepts = env.act(testAgentName, action);
		printReceivedMessage(percepts);
		
		action = new Structure("List");
		percepts = env.act(testAgentName, action);
		printReceivedMessage(percepts);
		
		action = new Structure("Parameterized");
		action.addTerm(new VarTerm("A"));
		action.addTerm(new VarTerm("B"));
		action.addTerm(new VarTerm("3"));
		percepts = env.act(testAgentName, action);
		printReceivedMessage(percepts);
		
		action = new Structure("TenSecondsWait");
		percepts = env.act(testAgentName, action);
		printReceivedMessage(percepts);
		
		action = new Structure("MultipleTenSecondsWait");
		percepts = env.act(testAgentName, action);
		printReceivedMessage(percepts);
	}

	public static void printReceivedMessage(List<Structure> percepts) {
		System.out.println("Percepts : {");
		for (Structure percept : percepts) {
			String toPrint = "    " + percept.getFunctor() + ": [";
			if (percept.getTerms() != null) {
				for (Term term : percept.getTerms()) {
					toPrint += term + ", ";
				}
				toPrint = toPrint.substring(0, toPrint.length() - 2);
			}
			toPrint += "]";
			System.out.println(toPrint);
		}
		System.out.println("}");
	}

}
