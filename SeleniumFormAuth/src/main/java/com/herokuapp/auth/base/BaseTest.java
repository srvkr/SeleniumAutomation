package com.herokuapp.auth.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest{

    protected WebDriver driver;
    protected Logger log;

    @BeforeMethod(alwaysRun = true)
    public void setup(ITestContext ctx){
        String Testname = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(Testname);


        BrowserDriverFactory factory = new BrowserDriverFactory(log);
        log.info("Creating Chrome Driver");
        driver = factory.CreateDriver();
        log.info("Maximizing Chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        log.info("Closing Driver");
        driver.quit();
    }

}
