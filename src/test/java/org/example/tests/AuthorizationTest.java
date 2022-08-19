package org.example.tests;

import org.example.driver.BaseTest;
import org.example.loggers.LoginPageService;
import org.example.loggers.StartedPageService;
import org.example.object.User;
import org.example.service.UserService;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizationTest extends BaseTest {

    private StartedPageService startedPageService;
    private LoginPageService loginPageService;

    @BeforeMethod(alwaysRun = true)
    public void registration() {
        User user = UserService.credentials();

        startedPageService = new StartedPageService();
        loginPageService = startedPageService.clickOnSignInMenu();
        startedPageService = loginPageService.logIn(user);
    }

    @Test(description = "1.1")
    public void getTitle() {
        String getTitleText = startedPageService.getAccountGreetingText();
        assertThat(getTitleText, Matchers.equalTo("Hello, Amili"));
    }
}
