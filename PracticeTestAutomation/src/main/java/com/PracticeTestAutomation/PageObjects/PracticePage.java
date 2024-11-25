package com.PracticeTestAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PracticePage extends BasePage{

    private By testLoginPageLocator = By.linkText("Test Login Page");
    private By testExceptionLocator = By.linkText("Test Exceptions");
    private By menuOptionPractice = By.id("menu-item-20");

    public PracticePage(WebDriver driver) {
        super(driver);
    }



    public void menuSwitch() {
        driver.findElement(menuOptionPractice).click();
    }

    public void loadNav(){
        waitForElement(menuOptionPractice);
    }

    public void load(){
        driver.findElement(testExceptionLocator);
        driver.findElement(testExceptionLocator);
    }

    public void verifyPracticePage() {
        String pageSource = getPageSource();
        Assert.assertTrue(pageSource.contains("Simple login page where testers can execute positive and negative login test cases"));
    }

    public void selectTestLoginPage() {
        driver.findElement(testLoginPageLocator).click();
    }

    public LoginPage executePracticePage() {

        loadNav();
        menuSwitch();
        load();
        verifyPracticePage();
        selectTestLoginPage();
        return new LoginPage(driver);
    }

}
