package com.mokona.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	public String getConfig(String property) {
		Properties properties = new Properties();
		InputStream input = null;

		try {
			String filename = "config.properties";
			input = Config.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				return null;
			}

			properties.load(input);
			return properties.getProperty(property);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
