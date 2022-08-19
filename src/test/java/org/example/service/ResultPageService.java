package org.example.service;

import org.example.pages.ResultPage;

import java.util.logging.Logger;

public class ResultPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(ResultPageService.class.getName());
    ResultPage resultPage = new ResultPage();

    public boolean isListEmpty() {
        boolean result = resultPage.getListOfItemsNamesText().isEmpty();
        log.info("List is empty " + result);
        return result;
    }

    public ProductPageService clickOnFirstElementInListOfItems() {
        log.info("Click on the first element of list");
        resultPage.clickOnFirstElementInListOfItems();
        return new ProductPageService();
    }
}
