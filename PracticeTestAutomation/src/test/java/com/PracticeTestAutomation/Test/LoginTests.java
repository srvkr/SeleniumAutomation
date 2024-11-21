package com.PracticeTestAutomation.Test;

import com.PracticeTestAutomation.PageObjects.HomePage;
import com.PracticeTestAutomation.PageObjects.LoginPage;
import com.PracticeTestAutomation.PageObjects.PracticePage;
import com.PracticeTestAutomation.PageObjects.SuccessfullLoginPage;
import org.testng.annotations.*;

public class LoginTests extends BaseTest{

    @Test (priority = 1)
    //Open home page
    public void GetInToHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.executeHome("https://practicetestautomation.com/");
    }

    @Test (priority = 2)
    //In to practice page
    public void practicePage() {
        PracticePage practicePage = new PracticePage(driver);
        practicePage.executePracticePage();
    }


    @Test (priority = 3)
    //Test functionality of login page
    public void TestLoginFunction(){
        LoginPage loginPage = new LoginPage(driver);
        SuccessfullLoginPage successfullLoginPage = loginPage.executeLogin("student", "Password123");
        successfullLoginPage.load();
        successfullLoginPage.verifyConditions();
    }
}
