package br.ufsc.vsschweitzer.thesis.configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnvironmentConfiguration {

	private static final int DEFAULT_PORT = 10000;
	private static final String IP_ADDRESS_REGEX = "\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"; // TODO verify regex
	private static final String PORT_REGEX = "\\d{1,5}"; // TODO verify regex

	private String ipAddress;
	private int port = DEFAULT_PORT;

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
		verifyPattern(IP_ADDRESS_REGEX, ipAddress);
		String[] octets = ipAddress.split(".");
		for (String octet: octets) {
			int octetAsInt = Integer.parseInt(octet);
			if (octetAsInt < 0 || octetAsInt > 255) {
				// TODO throw error
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

	private boolean verifyPattern(String regex, String data) {
		// TODO verify PORT and ADDRESS regex
		// TODO throw error when regex fails
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(data);
		
		return false;
	}

}
