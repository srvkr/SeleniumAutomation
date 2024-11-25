package com.PracticeTestAutomation.Test;

import com.PracticeTestAutomation.PageObjects.HomePage;
import com.PracticeTestAutomation.PageObjects.LoginPage;
import com.PracticeTestAutomation.PageObjects.PracticePage;
import com.PracticeTestAutomation.PageObjects.SuccessfullLoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseTest{

    @Test(priority = 1, groups = {"smoke"})
    //Open home page
    public void GetInToHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.executeHome("https://practicetestautomation.com/");
    }

    @Test(priority = 2, groups = {"smoke"})
    //In to practice page
    public void practicePage() {
        PracticePage practicePage = new PracticePage(driver);
        practicePage.executePracticePage();
    }

    @Test(priority = 3)
    //Test functionality of login page
    public void PositiveTestLoginFunction(){
        LoginPage loginPage = new LoginPage(driver);
        SuccessfullLoginPage successfullLoginPage = loginPage.executeLogin("student", "Password123");
        successfullLoginPage.load();
        successfullLoginPage.verifyConditions(); //only after successfull login
    }

    @Test (priority = 3, groups = {"NegativeUsernameTest","regression"})
    //Test functionality of login page
    public void NegativeUsernameTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin("incorrectUser", "Password123");
        String errorTxt = loginPage.errorMessage();
        Assert.assertEquals(errorTxt, "Your username is invalid!");
    }

    @Test (priority = 3, groups = {"NegativePasswordTest","regression"})
    //Test functionality of login page
    public void NegativePasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin("student", "incorrectPassword");
        String errorTxt = loginPage.errorMessage();
        Assert.assertEquals(errorTxt, "Your password is invalid!");

    }
}
