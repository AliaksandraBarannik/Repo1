package org.example.loggers;

import org.example.pages.InitDriver;
import org.example.pages.StartedPage;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class StartedLogger extends InitDriver {

    public static final Logger log = Logger.getLogger(StartedLogger.class.getName());
    StartedPage startedPage = new StartedPage(driver);

    public StartedLogger(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInMenu() {
        log.info("Click on 'Sign in' menu button");
        startedPage.clickOnSignInMenu();
    }

    public String getAccountGreetingText() {
        log.info("Get text with user name");
        return startedPage.getAccountGreetingText();
    }

    public StartedLogger fillSearchField(String text) {
        log.info("Fill search filed with text " + text);
        startedPage.fillSearchField(text);
        return this;
    }

    public void clickOnSubmitButton() {
        log.info("Click on submit button ");
        startedPage.clickOnSubmitButton();
    }

    public StartedLogger navigate() {
        startedPage.navigate();
        return this;
    }

    public void clickOnCartButton() {
        log.info("Click on Cart button");
        startedPage.clickOnCartButton();
    }
}
