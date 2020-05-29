package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * reads the properties file configuration.properties
 */
public class ConfigurationReader {

    private static Properties properties;

    static {
        try {
            // file name which will be read
            String path = "configuration.properties";
            // read the file into java by using the string path
            FileInputStream input = new FileInputStream(path);
            //create properties object
            // properties --> class that store properties in key / value format
            properties = new Properties();
            // the values from the file is loaded into the properties object
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

}