package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();
        Driver.openURL();
        Driver.waiters();
    }

    @AfterSuite(alwaysRun = true)
    public void stopBrowser() {
        Driver.closeBrowser();
    }
}
