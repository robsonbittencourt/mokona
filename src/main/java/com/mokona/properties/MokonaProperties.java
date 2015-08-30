package com.mokona.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class MokonaProperties {
    
    private static final String MOKONA_PROPERTIES_FILE_NAME = "mokona.properties";
   
    private static MokonaProperties instance;
    
    private static Map<String, String> properties;
    
    public static String getChromeDriverPath() {
        getInstance();
        
        return properties.get("mokona.webdriver.chrome");
    }
    
    private static synchronized MokonaProperties getInstance() {
        if (instance == null) {
            instance = new MokonaProperties();
            instance.readPropertiesFile();
        }
        return instance;
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
                e.printStackTrace();
            }
        }
    }

}
