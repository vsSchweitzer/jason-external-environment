package br.ufsc.vsschweitzer.thesis.configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnvironmentConfiguration {

	private static final String DEFAULT_IP_ADDRESS = "localhost";
	private static final String DEFAULT_PORT = "12345";
	private static final String IP_ADDRESS_REGEX = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
	private static final String PORT_REGEX = "\\d{1,5}";

	private String ipAddress;
	private int port;

	public EnvironmentConfiguration() {
		this.setIpAddress(DEFAULT_IP_ADDRESS);
		this.setPort(DEFAULT_PORT);
	}

	public EnvironmentConfiguration(String ipAddress, String port) {
		this.setIpAddress(ipAddress);
		this.setPort(port);
	}

	public String getIpAddress() {
		return ipAddress;
	}

	private void setIpAddress(String ipAddress) {
		verifyIpAddress(ipAddress);
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	private void setPort(String port) {
		verifyPort(port);
		this.port = Integer.parseInt(port);
	}

	private void verifyIpAddress(String ipAddress) {
		if (ipAddress != "localhost") {
			verifyPattern(IP_ADDRESS_REGEX, ipAddress);
			String[] octets = ipAddress.split(".");
			for (String octet : octets) {
				int octetAsInt = Integer.parseInt(octet);
				if (octetAsInt < 0 || octetAsInt > 255) {
					// TODO throw error
				}
			}
		}
	}

	private void verifyPort(String port) {
		verifyPattern(PORT_REGEX, port);
		int portAsInt = Integer.parseInt(port);
		if (portAsInt < 1 || portAsInt > 65535) {
			// TODO throw error
		}
	}

	private void verifyPattern(String regex, String data) {
		// TODO verify PORT and ADDRESS regex
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(data);
		boolean correct = matcher.matches();
		
		if (!correct) {
			// TODO throw error when regex fails
		}
	}

}
