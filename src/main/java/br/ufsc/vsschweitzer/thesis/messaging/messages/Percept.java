package br.ufsc.vsschweitzer.thesis.messaging.messages;

import java.util.List;

import br.ufsc.vsschweitzer.thesis.messaging.messages.enums.PerceptAction;
import jason.asSyntax.Atom;
import jason.asSyntax.Structure;

public class Percept {
	
	String percept;
	List<String> perceptValues;
	PerceptAction action;
	
	public Percept() {}
	
	public Percept(String percept, List<String> perceptValues, PerceptAction action) {
		setPercept(percept);
		setPerceptValues(perceptValues);
		setAction(action);
	}

	public String getPercept() {
		return percept;
	}
	
	public void setPercept(String percept) {
		this.percept = percept;
	}
	
	public List<String> getPerceptValues() {
		return perceptValues;
	}
	
	public void setPerceptValues(List<String> perceptValues) {
		this.perceptValues = perceptValues;
	}

	public PerceptAction getAction() {
		return action;
	}

	public void setAction(PerceptAction action) {
		this.action = action;
	}
	
	public Structure asLiteral() {
		Structure percept = new Structure(getPercept());
		for (String term : getPerceptValues()) {
			percept.addTerm(new Atom(term));
		}
		return percept;
	}
	
}
