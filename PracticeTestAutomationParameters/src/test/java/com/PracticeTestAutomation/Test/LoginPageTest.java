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

    @Parameters({"UserID", "Password"})
    @Test(priority = 3)
    //Test functionality of login page
    public void PositiveTestLoginFunction(String UserID, String Password){
        LoginPage loginPage = new LoginPage(driver);
        SuccessfullLoginPage successfullLoginPage = loginPage.executeLogin(UserID, Password);
        successfullLoginPage.load();
        successfullLoginPage.verifyConditions(); //only after successfull login
    }

    @Parameters({"UserID", "Password"})
    @Test (priority = 3, groups = {"NegativeUsernameTest","regression"})
    //Test functionality of login page
    public void NegativeUsernameTest(String UserID, String Password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin(UserID, Password);
        String errorTxt = loginPage.errorMessage();
        Assert.assertEquals(errorTxt, "Your username is invalid!");
    }

    @Parameters({"UserID", "Password"})
    @Test (priority = 3, groups = {"NegativePasswordTest","regression"})
    //Test functionality of login page
    public void NegativePasswordTest(String UserID, String Password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin(UserID, Password);
        String errorTxt = loginPage.errorMessage();
        Assert.assertEquals(errorTxt, "Your password is invalid!");

    }
}
