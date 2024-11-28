package com.positiveauth.test;

import com.herokuapp.auth.NegativeAuthPage;
import org.testng.annotations.Test;

public class NegativeAuthPageTest extends NegativeAuthPage {

    //WebDriver driver;

    @Test
    private void NegativeTestFunc() throws InterruptedException {
        loginFunction();
        Thread.sleep(2000);
    }

}
