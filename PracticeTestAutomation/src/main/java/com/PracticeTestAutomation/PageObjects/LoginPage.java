package com.PracticeTestAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{
    private By userNameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By submitButtonLocator = By.id("submit");
    private By errorMessageLocator = By.id("error");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void visit() {
        super.visit("https://practicetestautomation.com/practice-test-login/");
    }

    public void verifyLoginPage() {
        String pageSource = getPageSource();
        Assert.assertTrue(pageSource.contains("Use next credentials to execute Login:"));
    }

    public void inputUserName(String username){
        driver.findElement(userNameLocator).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickSubmitButton(){
        driver.findElement(submitButtonLocator).click();
    }

    public SuccessfullLoginPage executeLogin(String username, String password){
        verifyLoginPage();
        inputUserName(username);
        inputPassword(password);
        clickSubmitButton();
        return new SuccessfullLoginPage(driver);
    }

    public String errorMessage(){
        return waitForElement(errorMessageLocator).getText();
    }

}
