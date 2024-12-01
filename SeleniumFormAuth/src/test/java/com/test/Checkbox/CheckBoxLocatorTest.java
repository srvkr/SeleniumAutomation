package com.test.Checkbox;

import com.herokuapp.auth.WorkingWithCheckboxes;
import com.herokuapp.auth.base.BaseTest;
import org.testng.annotations.Test;

public class CheckBoxLocatorTest extends BaseTest {

    @Test
    public void CheckBoxLocator() throws Exception{
        WorkingWithCheckboxes workingWithCheckboxes = new WorkingWithCheckboxes(driver, log);
        workingWithCheckboxes.launch();
        workingWithCheckboxes.ClickOnCheckBox();
        workingWithCheckboxes.clickCheckBox();
        Thread.sleep(3000);
    }
}
