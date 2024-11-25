package com.PracticeTestAutomation.Test;

import com.PracticeTestAutomation.PageObjects.PracticePage;
import org.testng.annotations.Test;

public class PracticePageTest extends BaseTest{


    //In to practice page
    @Test
    public void practicePage() {
        PracticePage practicePage = new PracticePage(driver);
        practicePage.executePracticePage();
    }

}
