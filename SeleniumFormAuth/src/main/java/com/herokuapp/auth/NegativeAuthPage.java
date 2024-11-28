package com.herokuapp.auth;

import com.herokuapp.auth.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

public class NegativeAuthPage extends BaseTest {

    String url = "https://the-internet.herokuapp.com/";
    By FormAuthLink = By.linkText("Form Authentication");
    By UserName = By.id("username");
    By Password = By.id("password");
    By LoginButton = By.xpath("//*[@id=\"login\"]/button");
    By VerifyTest = By.id("flash");
    By FindLogoutButton = By.xpath("//*[@id=\"content\"]/div/a/i");


    private void launchUrl(String url){
        log.info("Connecting to:: " + url);
        driver.get(url);
    }

    private void getInToFormAuth(){
        driver.findElement(FormAuthLink).click();
    }

    private void login(){
        log.info("Negative Test");
        driver.findElement(UserName).sendKeys("tomsmith");
        driver.findElement(Password).sendKeys("SuperTopSecretPassword!");
        driver.findElement(LoginButton).click();
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

    protected void loginFunction(){
        launchUrl(url);
        getInToFormAuth();
        login();
        verify();
    }

}
