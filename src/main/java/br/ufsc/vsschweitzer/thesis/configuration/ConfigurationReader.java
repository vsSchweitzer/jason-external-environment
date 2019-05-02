package br.ufsc.vsschweitzer.thesis.configuration;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigurationReader {

	private static final String CONFIGURATION_FILE_PATH = "./src/main/resources";
	private static final String CONFIGURATION_FILE_NAME = "configurations.json";

	private static final ObjectMapper mapper = new ObjectMapper();

	public static EnvironmentConfiguration getConfiguration() {
		File configurationFile = new File(CONFIGURATION_FILE_PATH + "/" + CONFIGURATION_FILE_NAME);
		EnvironmentConfiguration readConfig;
		try {
			readConfig = mapper.readValue(configurationFile, EnvironmentConfiguration.class);
		} catch (Exception e) {
			readConfig = new EnvironmentConfiguration();
		}

		return readConfig;
	}

}
