package com.mokona.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.mokona.exception.MokonaException;

public final class MokonaProperties {

	private static final String MOKONA_PROPERTIES_FILE_NAME = "mokona.properties";

	private Map<String, String> properties;

	public String getChromeDriverPath() {
		readPropertiesFile();

		return properties.get("mokona.webdriver.chrome");
	}

	private void readPropertiesFile() {
		if (properties == null) {
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(MOKONA_PROPERTIES_FILE_NAME));

				properties = new HashMap<String, String>();

				for (String property : prop.stringPropertyNames()) {
					properties.put(property, prop.getProperty(property));
				}

			} catch (IOException e) {
				throw new MokonaException("Mokona configuration file not found", e);
			}
		}
	}

}
