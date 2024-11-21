package com.PracticeTestAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SuccessfullLoginPage extends BasePage {
    private By logoutButtonLocator = By.linkText("Log out");

    public SuccessfullLoginPage(WebDriver driver){
        super(driver);
    }

    public boolean isLogoutButtonDisplayed(){
        return isDisplayed(logoutButtonLocator);
    }

    public void load() {
        waitForElement(logoutButtonLocator);
    }

    public void verifyConditions(){
        String actualUrl = getCurrentUrl();
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(actualUrl, expectedUrl);
        String getPageSource = getPageSource();
        Assert.assertTrue(getPageSource.contains("Congratulations student. You successfully logged in!"));
        Assert.assertTrue(isLogoutButtonDisplayed());
    }
}
