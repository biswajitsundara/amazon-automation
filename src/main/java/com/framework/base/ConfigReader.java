package com.framework.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	private static ConfigReader configReader;
	private static String PROPERTY_FILE_PATH = "src/test/config/config.properties";

	private ConfigReader() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at " + PROPERTY_FILE_PATH);
		}
	}

	public static ConfigReader getInstance() {
		if (configReader == null) {
			configReader = new ConfigReader();
		}
		return configReader;
	}

	public String getProperty(String propKey) {
		String propValue = properties.getProperty(propKey);
		if (propValue != null)
			return propValue;
		else
			throw new RuntimeException(propKey + "is not specified in the config.properties file.");
	}

	public int getintProperty(String propKey) {
		String propValue = properties.getProperty(propKey);
		if (propValue != null)
			return Integer.parseInt(propValue);
		else
			throw new RuntimeException(propKey + "is not specified in the config.properties file.");
	}

}
