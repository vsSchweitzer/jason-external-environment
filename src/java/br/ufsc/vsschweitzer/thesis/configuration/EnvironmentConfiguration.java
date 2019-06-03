package br.ufsc.vsschweitzer.thesis.configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.ufsc.vsschweitzer.thesis.configuration.exceptions.MalformedConfigurationsException;
import br.ufsc.vsschweitzer.thesis.configuration.exceptions.MalformedConfigurationsException.ErrorField;

public class EnvironmentConfiguration {

	private static final String DEFAULT_IP_ADDRESS = "127.0.0.1";
	private static final String DEFAULT_PORT = "12345";
	private static final String IP_ADDRESS_REGEX = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
	private static final String PORT_REGEX = "\\d{1,5}";

	private String ipAddress;
	private int port;

	public EnvironmentConfiguration() {
		try {
			this.setIpAddress(DEFAULT_IP_ADDRESS);
			this.setPort(DEFAULT_PORT);
		} catch (Exception e) {
			// Never happens
		}
	}

	public EnvironmentConfiguration(String ipAddress, String port) throws MalformedConfigurationsException {
		this.setIpAddress(ipAddress);
		this.setPort(port);
	}

	public String getIpAddress() {
		return ipAddress;
	}

	private void setIpAddress(String ipAddress) throws MalformedConfigurationsException {
		verifyIpAddress(ipAddress);
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	private void setPort(String port) throws MalformedConfigurationsException {
		verifyPort(port);
		this.port = Integer.parseInt(port);
	}

	private void verifyIpAddress(String ipAddress) throws MalformedConfigurationsException {
		if (ipAddress != "localhost") {
			boolean valid = verifyPattern(IP_ADDRESS_REGEX, ipAddress);
			if (!valid) {
				throw new MalformedConfigurationsException(ErrorField.IpAddress);
			}
			String[] octets = ipAddress.split(".");
			for (String octet : octets) {
				int octetAsInt = Integer.parseInt(octet);
				if (octetAsInt < 0 || octetAsInt > 255) {
					throw new MalformedConfigurationsException(ErrorField.IpAddress);
				}
			}
		}
	}

	private void verifyPort(String port) throws MalformedConfigurationsException {
		boolean valid = verifyPattern(PORT_REGEX, port);
		if (!valid) {
			throw new MalformedConfigurationsException(ErrorField.Port);
		}
		int portAsInt = Integer.parseInt(port);
		if (portAsInt < 1 || portAsInt > 65535) {
			throw new MalformedConfigurationsException(ErrorField.Port);
		}
	}

	private boolean verifyPattern(String regex, String data) {
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(data);
		boolean correct = matcher.matches();
		
		return correct;
	}

}
