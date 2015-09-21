package com.mokona.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.mokona.exception.MokonaException;

public final class MokonaProperties {

    private static final String PROPERTIES_FILE_NAME = "mokona-internal.properties";
    private static final String USER_PROPERTIES_FILE_NAME = "mokona.properties";

    public Map<String, String> loadInternalPropertiesFile() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String file = classLoader.getResource(PROPERTIES_FILE_NAME).getFile();
            FileInputStream inputStream = new FileInputStream(file);
            return loadProperties(inputStream);
        } catch (IOException e) {
            throw new MokonaException("Unexpected error", e);
        }
    }

    public Map<String, String> loadUserPropertiesFile() {
        try {
            FileInputStream inputStream = new FileInputStream(USER_PROPERTIES_FILE_NAME);
            return loadProperties(inputStream);
        } catch (IOException e) {
            throw new MokonaException("Mokona configuration file not found", e);
        }
    }

    private Map<String, String> loadProperties(FileInputStream inputStream) throws IOException {
        Properties prop = new Properties();
        prop.load(inputStream);

        Map<String, String> properties = new HashMap<String, String>();

        for (String property : prop.stringPropertyNames()) {
            properties.put(property, prop.getProperty(property));
        }

        return properties;
    }

}
