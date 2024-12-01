package com.herokuapp.auth.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject{

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject (WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
    }

    protected void openUrl(String url){
        log.info("Connecting to:: " + url);
        driver.get(url);
    }

    protected void click(By element, Integer time){
        waitfor(element, time);
        find(element).click();
    }

    protected void type(By locator, String Data){
        find(locator).sendKeys(Data);
    }

    protected WebElement find(By element){
            return driver.findElement(element);
    }

    protected void waitfor(By locator, Integer time){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
