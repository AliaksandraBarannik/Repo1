package org.example.tests;

import org.example.driver.Driver;
import org.example.loggers.LoginLogger;
import org.example.loggers.ResultLogger;
import org.example.loggers.StartedLogger;
import org.example.model.User;
import org.example.service.UserService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchProductTest extends Driver {

    private StartedLogger startedLogger;
    private ResultLogger resultLogger;

    @BeforeMethod(alwaysRun = true)
    public void registration() {
        User user = UserService.credentials();

        LoginLogger loginLogger = new LoginLogger(driver);
        resultLogger = new ResultLogger(driver);
        startedLogger = new StartedLogger(driver);
        startedLogger.clickOnSignInMenu();
        loginLogger.logIn(user);
    }

    @Test(description = "1.2")
    public void checkSearch() {
        startedLogger.fillSearchField("iPhone")
                .clickOnSubmitButton();
        assertThat("List of items is empty", !resultLogger.isListEmpty());
    }
}
