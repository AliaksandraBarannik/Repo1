package org.example.tests;

import org.example.driver.BaseTest;
import org.example.loggers.LoginPageService;
import org.example.loggers.ResultPageService;
import org.example.loggers.StartedPageService;
import org.example.object.User;
import org.example.service.UserService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchProductTest extends BaseTest {

    private StartedPageService startedPageService;
    private ResultPageService resultPageService;
    private LoginPageService loginPageService;

    @BeforeMethod(alwaysRun = true)
    public void registration() {
        User user = UserService.credentials();

        startedPageService = new StartedPageService();
        resultPageService = new ResultPageService();
        loginPageService = startedPageService.clickOnSignInMenu();
        startedPageService = loginPageService.logIn(user);
    }

    @Test(description = "1.2")
    public void checkSearch() {
        startedPageService.fillSearchField("iPhone")
                .clickOnSubmitButton();
        assertThat("List of items is empty", !resultPageService.isListEmpty());
    }
}
