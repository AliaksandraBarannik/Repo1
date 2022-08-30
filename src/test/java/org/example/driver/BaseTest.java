package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();
        Driver.openURL();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        Driver.closeBrowser();
    }
}
