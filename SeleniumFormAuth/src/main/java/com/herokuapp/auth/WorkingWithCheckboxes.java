package com.herokuapp.auth;

import com.herokuapp.auth.base.BasePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkingWithCheckboxes extends BasePageObject {

    private String url = "https://the-internet.herokuapp.com/";
    private By CheckBoxLocatore = By.linkText("Checkboxes");
    private By WaitForCheckBox = By.id("checkboxes");
    private By CheckBox1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");

    public WorkingWithCheckboxes(WebDriver driver, Logger log){
        super(driver, log);
    }

    public void launch(){
        openUrl(url);
    }

    public void ClickOnCheckBox(){
        log.info("Click on checkbox link");
        click(CheckBoxLocatore, 5);
    }

    public void check(){
        waitfor(WaitForCheckBox, 5);
    }

    public void clickCheckBox(){
        click(CheckBox1,5);
    }



}
