package com.positiveauth.test;

import com.herokuapp.auth.PositiveAuthPage;
import org.testng.annotations.Test;

public class PositiveAuthPageTest extends PositiveAuthPage{

    //WebDriver driver;

    @Test
    private void PositiveTestFunc() throws InterruptedException {
        loginFunction();
        Thread.sleep(2000);
    }

}
