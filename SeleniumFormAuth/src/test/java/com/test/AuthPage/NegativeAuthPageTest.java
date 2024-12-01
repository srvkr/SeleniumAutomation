package com.test.AuthPage;

import com.herokuapp.auth.NegativeAuthPage;
import com.herokuapp.auth.base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class NegativeAuthPageTest extends BaseTest {

    //WebDriver driver;

    @Test
    private void NegativeTestFunc() throws InterruptedException {
        NegativeAuthPage negativeAuthPage = new NegativeAuthPage(driver, log);
        negativeAuthPage.loginFunction();
        Thread.sleep(2000);
    }

}
