package com.yogi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Used to retrieve properties and make them available to tests
 */
@Configuration
public class TestProperties {

    @Autowired
    private Environment environment;


    public String getFileScannerBaseURL() {
        return environment.getProperty("FileScanner.base.url");


    }
}
