package org.example.loggers;

import org.example.pages.BasePage;

import java.util.logging.Logger;

public class BasePageService {

    public static final Logger log = Logger.getLogger(BasePageService.class.getName());

    BasePage basePage = new BasePage();

    public void clickOnSubmitButton() {
        log.info("Click on submit button");
        basePage.clickOnSubmitButton();
    }
}
