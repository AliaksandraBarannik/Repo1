package org.example.service;

import org.example.pages.StartedPage;

import java.util.logging.Logger;

public class StartedPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(StartedPageService.class.getName());
    private StartedPage startedPage = new StartedPage();

    public LoginPageService clickOnSignInMenu() {
        log.info("Click on 'Sign in' menu button");
        startedPage.clickOnSignInMenu();
        return new LoginPageService();
    }

    public String getAccountGreetingText() {
        log.info("Get text with user name");
        return startedPage.getAccountGreetingText();
    }

    public ResultPageService fillSearchField(String text) {
        log.info("Fill search filed with text " + text);
        startedPage.fillSearchField(text);
        return new ResultPageService();
    }

    public StartedPageService goToMainPage() {
        startedPage.goToMainPage();
        return this;
    }

    public ShoppingCartPageService clickOnCartButton() {
        log.info("Click on Cart button");
        startedPage.clickOnCartButton();
        return new ShoppingCartPageService();
    }
}
