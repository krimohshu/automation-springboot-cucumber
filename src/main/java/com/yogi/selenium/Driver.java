package com.yogi.selenium;

import com.yogi.common.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver driver;
    private Driver(){
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(new Base().getProperty("baseUrl"));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeWebBrowser(){
        if (null != driver){
            driver.quit();
        }
        driver = null;
    }
}

