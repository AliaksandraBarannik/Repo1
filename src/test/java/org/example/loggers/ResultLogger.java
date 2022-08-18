package org.example.loggers;

import org.example.pages.InitDriver;
import org.example.pages.ResultPage;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class ResultLogger extends InitDriver {

    public static final Logger log = Logger.getLogger(ResultLogger.class.getName());
    ResultPage resultPage = new ResultPage(driver);

    public ResultLogger(WebDriver driver) {
        super(driver);
    }

    public boolean isListEmpty() {
        boolean result = resultPage.getItemsNamesText().isEmpty();
        log.info("List is empty " + result);
        return result;
    }

    public void clickOnFirstElementInListOfItems() {
        log.info("Click on the first element of list");
        resultPage.clickOnFirstElementInListOfItems();
    }
}
