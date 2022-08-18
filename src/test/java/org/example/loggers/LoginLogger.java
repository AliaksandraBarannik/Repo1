package org.example.loggers;

import org.example.model.User;
import org.example.pages.InitDriver;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class LoginLogger extends InitDriver {

    public static final Logger log = Logger.getLogger(LoginLogger.class.getName());
    private LoginPage loginPage = new LoginPage(driver);

    public LoginLogger(WebDriver driver) {
        super(driver);
    }

    public LoginLogger addEmail(String email) {
        log.info("Add email");
        loginPage.addEmail(email);
        return this;
    }

    public void clickOnSubmitButton() {
        log.info("Click submit button");
        loginPage.clickOnSubmitButton();

    }

    public LoginLogger addPassword(String password) {
        log.info("Add password");
        loginPage.addPassword(password);
        return this;
    }

    public void logIn(User user) {
        addEmail(user.getEmail());
        clickOnSubmitButton();
        addPassword(user.getPassword());
        clickOnSubmitButton();
    }

}
