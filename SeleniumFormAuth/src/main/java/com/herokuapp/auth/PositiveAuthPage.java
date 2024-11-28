package com.herokuapp.auth;

import com.herokuapp.auth.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PositiveAuthPage extends BaseTest {

    String url = "https://the-internet.herokuapp.com/";
    By FormAuthLink = By.linkText("Form Authentication");
    By UserName = By.id("username");
    By Password = By.id("password");
    By LoginButton = By.xpath("//*[@id=\"login\"]/button");
    By VerifyTest = By.xpath("//*[@id=\"content\"]/div/h4");
    By FindLogoutButton = By.xpath("//*[@id=\"content\"]/div/a/i");


    private void launchUrl(String url){
        log.info("Connecting to " + url);
        driver.get(url);
    }

    private void getInToFormAuth(){
        driver.findElement(FormAuthLink).click();
    }

    private void login(){
        log.info("Positive Test");
        driver.findElement(UserName).sendKeys("tomsmith");
        driver.findElement(Password).sendKeys("SuperSecretPassword!");
        driver.findElement(LoginButton).click();
    }

    private void verify() {
        String PageSource = driver.getPageSource();
        assert PageSource != null;
        WebElement verifymsg = driver.findElement(VerifyTest);
        Assert.assertTrue(PageSource.contains(" You logged into a secure area!"));
        Assert.assertEquals(verifymsg.getText(),"Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertTrue(driver.findElement(FindLogoutButton).isDisplayed());

        log.info("Login Success");
    }

    protected void loginFunction(){
        launchUrl(url);
        getInToFormAuth();
        login();
        verify();
    }

}
