package com.PracticeTestAutomation.Test;

import com.PracticeTestAutomation.PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{


    //Open home page
    @Test
    public void GetInToHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.executeHome("https://practicetestautomation.com/");
    }
}
