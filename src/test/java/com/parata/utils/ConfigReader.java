package com.parata.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author MFU
 * 1/11/2021
 */
public class ConfigReader
{
    public static Properties properties = null;

    public static Properties readProperties(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            if(properties == null){
                properties = new Properties();
            }
           
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void addProperty(String key, String value){
        properties.setProperty(key, value);
    }
}
