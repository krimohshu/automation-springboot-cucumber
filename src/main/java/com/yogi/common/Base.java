package com.yogi.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Base {
    String path="application.properties";

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
