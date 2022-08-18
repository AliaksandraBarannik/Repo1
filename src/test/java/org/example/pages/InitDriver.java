package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InitDriver {
    protected WebDriver driver;
    protected Logger log = LogManager.getRootLogger();

    protected InitDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
