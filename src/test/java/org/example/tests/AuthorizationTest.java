package org.example.tests;

import org.example.driver.Driver;
import org.example.loggers.LoginLogger;
import org.example.loggers.StartedLogger;
import org.example.model.User;
import org.example.service.UserService;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorizationTest extends Driver {

    private StartedLogger startedLogger;

    @BeforeMethod(alwaysRun = true)
    public void registration() {
        User user = UserService.credentials();

        LoginLogger loginLogger = new LoginLogger(driver);
        startedLogger = new StartedLogger(driver);
        startedLogger.clickOnSignInMenu();
        loginLogger.logIn(user);

    }

    @Test(description = "1.1")
    public void getTitle() {
        String text = startedLogger.getAccountGreetingText();
        assertThat(text, Matchers.equalTo("Hello, Amili"));
    }
}
