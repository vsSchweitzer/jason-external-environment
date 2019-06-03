package br.ufsc.vsschweitzer.thesis.messaging.messages;

import java.util.List;
import java.util.stream.Collectors;

import br.ufsc.vsschweitzer.thesis.messaging.messages.enums.PerceptAction;
import jason.asSyntax.Literal;

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
	
	public Literal asLiteral() {
		String literalToParse = getPercept();
		if (getPerceptValues() != null
				&& getPerceptValues().size() > 0) {
			literalToParse += getPerceptValues().stream()
								.map(n -> String.valueOf(n))
								.collect(Collectors.joining(",", "(", ")"));
		}
		return Literal.parseLiteral(literalToParse);
	}
	
}
