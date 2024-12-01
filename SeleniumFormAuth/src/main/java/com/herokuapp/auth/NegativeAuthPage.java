package com.herokuapp.auth;

import com.herokuapp.auth.base.BasePageObject;
import com.herokuapp.auth.base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NegativeAuthPage extends BasePageObject {

    String url = "https://the-internet.herokuapp.com/";
    By FormAuthLink = By.linkText("Form Authentication");
    By UserName = By.id("username");
    By Password = By.id("password");
    By LoginButton = By.xpath("//*[@id=\"login\"]/button");
    By VerifyTest = By.id("flash");
    By FindLogoutButton = By.xpath("//*[@id=\"content\"]/div/a/i");

    public NegativeAuthPage(WebDriver driver, Logger log) {
        super(driver, log);
    }


    private void launchUrl(String url){
        openUrl(url);
    }

    private void getInToFormAuth(){
        click(FormAuthLink,5);
    }

    private void login(){
        log.info("Negative Test");
        type(UserName, "tomsmith");
        type(Password,"SuperTopSecretPassword!");
        click(LoginButton,5);
    }

    private void verify() {
        String PageSource = driver.getPageSource();
        assert PageSource != null;
        String verifyTest = driver.findElement(this.VerifyTest).getText();
        Assert.assertFalse(PageSource.contains(" You logged into a secure area!"));
        Assert.assertEquals(verifyTest,"Your password is invalid!\n×");
        try {
            Assert.assertFalse(driver.findElement(FindLogoutButton).isDisplayed());
        }
        catch (NoSuchElementException e){
            log.info("Logout Button Not Present");
        }
        log.info("NegativeLoginTest Pass Successfully");
    }

    public void loginFunction(){
        launchUrl(url);
        getInToFormAuth();
        login();
        verify();
    }

}
