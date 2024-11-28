package com.herokuapp.auth.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private Logger log;

    public BrowserDriverFactory(Logger log){
        this.log = log;
    }

    public WebDriver CreateDriver(){

        driver.set(new ChromeDriver());
        log.info("Launching Chrome");
        return driver.get();
    }
}
