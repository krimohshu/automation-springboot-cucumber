package com.yogi.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {
    String path="application.properties";

    /*== Just for demo purpose of traditional property access otherwise this is not required
         1. Use Spring @Value to get the property from Yml etc
         2. Alternatively Autowired Environment to get property e.g. from app.{xxx}.properties
         3. Use Java8 Files and Path and stream api to manipulate site easily
     */
    
    public String getProperty(String itemType){

        Properties prop = new Properties();
        InputStream input= null;
        input = getClass().getClassLoader().getResourceAsStream(path);
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(itemType);
    }
}
