package com.PracticeTestAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void visit(String url) {
        super.visit(url);
    }

    public PracticePage executeHome(String url) {
        visit(url);
        return new PracticePage(driver);
    }
}
