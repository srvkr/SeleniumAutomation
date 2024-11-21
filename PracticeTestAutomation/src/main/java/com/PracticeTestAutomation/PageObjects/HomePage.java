package com.PracticeTestAutomation.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By menuOptionPractice = By.id("menu-item-20");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void visit(String url) {
        super.visit(url);
    }

    public void menuSwitch() {
        driver.findElement(menuOptionPractice).click();
    }

    public void load(){
        waitForElement(menuOptionPractice);
    }

    public PracticePage executeHome(String url) {
        visit(url);
        load();
        menuSwitch();
        return new PracticePage(driver);
    }
}
