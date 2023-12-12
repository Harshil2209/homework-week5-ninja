package com.tutorialninja.testbase;

import com.tutorialninja.propertyreader.PropertyReader;
import com.tutorialninja.utility.Utility;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        selectBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeBrowser();
    }

}
