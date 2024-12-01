package com.test.AuthPage;

import com.herokuapp.auth.PositiveAuthPage;
import com.herokuapp.auth.base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PositiveAuthPageTest extends BaseTest {

    //WebDriver driver;

    @Test
    private void PositiveTestFunc() throws InterruptedException {
        PositiveAuthPage positiveAuthPage = new PositiveAuthPage(driver, log);
        positiveAuthPage.loginFunction();
        Thread.sleep(2000);
    }

}
