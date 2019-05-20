package br.ufsc.vsschweitzer.thesis.messaging.message;

import java.util.List;

public class Percept {
	
	String percept;
	List<String> perceptValues;
	
	public Percept() {}
	
	public Percept(String percept, List<String> perceptValues) {
		setPercept(percept);
		setPerceptValues(perceptValues);
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
	
}
