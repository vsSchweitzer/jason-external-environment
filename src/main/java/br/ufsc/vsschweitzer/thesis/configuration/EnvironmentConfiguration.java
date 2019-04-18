package br.ufsc.vsschweitzer.thesis.configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnvironmentConfiguration {

	private static final int DEFAULT_PORT = 10000;
	private static final String IP_ADDRESS_REGEX = ""; // TODO make regex
	private static final String PORT_REGEX = ""; // TODO make regex

	private String ipAddress;
	private int port = DEFAULT_PORT;

	public EnvironmentConfiguration(String ipAddress, int port) {
		this.setIpAddress(ipAddress);
		this.setPort(port);
	}

	public String getIpAddress() {
		return ipAddress;
	}

	private void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	private void setPort(int port) {
		this.port = port;
	}

	private void verifyPattern(String regex, String data) {
		// TODO incomplete implementation
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(data);
	}

}
