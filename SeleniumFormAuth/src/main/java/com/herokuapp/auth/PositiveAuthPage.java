package com.herokuapp.auth;

import com.herokuapp.auth.base.BasePageObject;
import com.herokuapp.auth.base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PositiveAuthPage extends BasePageObject {

    private String url = "https://the-internet.herokuapp.com/";
    By FormAuthLink = By.linkText("Form Authentication");
    By UserName = By.id("username");
    By Password = By.id("password");
    By LoginButton = By.xpath("//*[@id=\"login\"]/button");
    By VerifyTest = By.xpath("//*[@id=\"content\"]/div/h4");
    By FindLogoutButton = By.xpath("//*[@id=\"content\"]/div/a/i");

    public PositiveAuthPage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    private void launchUrl(String url){
        openUrl(url);
    }

    private void getInToFormAuth(){
        click(FormAuthLink,5);
    }

    private void login(){
        log.info("Positive Test");
        type(UserName,"tomsmith");
        type(Password,"SuperSecretPassword!");
        click(LoginButton,5);
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

    public void loginFunction(){
        launchUrl(url);
        getInToFormAuth();
        login();
        verify();
    }

}
