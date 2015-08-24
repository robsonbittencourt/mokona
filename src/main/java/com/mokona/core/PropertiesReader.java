package com.mokona.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

	public static Map<String, String> get() {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("mokona.properties"));
			
			Map<String, String> properties = new HashMap<String, String>();

			for (String property : prop.stringPropertyNames()) {
				properties.put(property, prop.getProperty(property));
			}
			
			return properties;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
